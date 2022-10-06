package uz.master.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import uz.master.DTOs.AuthUser;

import java.util.Optional;

public interface AuthUserRepository extends JpaRepository<AuthUser, Long> {

    Optional<AuthUser> findAuthUserByUsernameAndDeletedFalse(String username);

    Optional<AuthUser> findAuthUserByIdAndDeletedFalse(Long id);


    AuthUser findAuthUserByNameIgnoreCase(String name);
}
