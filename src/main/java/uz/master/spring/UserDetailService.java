package uz.master.spring;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import uz.master.DTOs.AuthUser;
import uz.master.repository.AuthUserRepository;

@Service
public class UserDetailService implements UserDetailsService {

    private final AuthUserRepository repository;

    public UserDetailService(AuthUserRepository repository) {
        this.repository = repository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        AuthUser user = repository.findAuthUserByUsernameAndDeletedFalse(username).orElseThrow(() -> {
            throw new UsernameNotFoundException("User Not Found");
        });
        return new uz.master.spring.UserDetails(user);
    }

}
