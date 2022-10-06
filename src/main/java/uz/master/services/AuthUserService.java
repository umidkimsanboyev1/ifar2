package uz.master.services;

import org.springframework.stereotype.Service;
import uz.master.DTOs.AuthUser;
import uz.master.repository.AuthUserRepository;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;

@Service
public class AuthUserService {

    private final AuthUserRepository authUserRepository;

    public AuthUserService(AuthUserRepository authUserRepository) {
        this.authUserRepository = authUserRepository;
    }

    public AuthUser getUser(Long id){
        AuthUser authUser = authUserRepository.findAuthUserByIdAndDeletedFalse(id).get();
        return authUser;
    }

    public AuthUser findUser(String name) {
        List<String> strings = Arrays.stream(name.split(" ")).toList();
        if(strings.size() != 2){
           return new AuthUser();
        }
        AuthUser user = authUserRepository.findAuthUserByNameIgnoreCase(strings.get(1));
        if(Objects.nonNull(user) && user.getSurName().equalsIgnoreCase(strings.get(0))){
            return user;
        }
        return new AuthUser();
    }
}
