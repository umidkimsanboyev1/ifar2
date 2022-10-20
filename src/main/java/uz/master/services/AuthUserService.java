package uz.master.services;

import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import uz.master.DTOs.AuthUser;
import uz.master.DTOs.AuthUserDTO;
import uz.master.DTOs.PasswordDTO;
import uz.master.mapper.AuthUserMapper;
import uz.master.repository.AuthUserRepository;
import uz.master.session.SessionUser;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;

@Service
public class AuthUserService {

    private final AuthUserRepository authUserRepository;
    private final AuthUserMapper mapper;
    private final PasswordEncoder encoder;
    private final SessionUser sessionUser;
    private final FileStorageService fileStorageService;

    public AuthUserService(AuthUserRepository authUserRepository, AuthUserMapper mapper, PasswordEncoder encoder, SessionUser sessionUser, FileStorageService fileStorageService) {
        this.authUserRepository = authUserRepository;
        this.mapper = mapper;
        this.encoder = encoder;
        this.sessionUser = sessionUser;
        this.fileStorageService = fileStorageService;
    }

    public AuthUser getUser(Long id) {
        AuthUser authUser = authUserRepository.findAuthUserByIdAndDeletedFalse(id).get();
        return authUser;
    }

    public AuthUser findUser(String name) {
        List<String> strings = Arrays.stream(name.split(" ")).toList();
        if (strings.size() != 2) {
            throw new UsernameNotFoundException("USER NOT FOUND");
        }
        AuthUser user = authUserRepository.findAuthUserByNameIgnoreCase(strings.get(1));
        if (!(Objects.nonNull(user) && user.getSurName().equalsIgnoreCase(strings.get(0)))) {
            throw new UsernameNotFoundException("USER NOT FOUND");
        }
        return user;
    }

    public String editProfile(AuthUserDTO dto) {
        MultipartFile picture = dto.getPicture();
        AuthUser authUser1 = authUserRepository.findAuthUserByIdAndDeletedFalse(sessionUser.getId()).get();
        List<String> mails = Arrays.stream(dto.getEmails().split(";")).toList();
        AuthUser authUser = mapper.toEntity(dto);
        authUser.setPassword(authUser1.getPassword());
        authUser.setId(authUser1.getId());
        authUser.setUsername(authUser1.getUsername());
        authUser.setEmail1(mails.get(0));
        authUser.setEmail2(mails.get(1));
        authUser.setPicture("/DBProjects/IFAR2/src/main/resources/static/images/" + fileStorageService.store(picture));
        authUser.setDeleted(false);
        authUserRepository.save(authUser);
        return "Succes";
    }

    public String changePassword(PasswordDTO dto) {
        AuthUser user = authUserRepository.findAuthUserByIdAndDeletedFalse(sessionUser.getId()).get();
        if(!encoder.matches(dto.getOld(), user.getPassword())){
            throw new RuntimeException("Password is not correct");
        }
        if(!dto.getPassword1().equals(dto.getPassword2())){
            throw new RuntimeException("Password Miss Match");
        }
        user.setPassword(encoder.encode(dto.getPassword1()));
        authUserRepository.save(user);
        return "Success";
    }
}
