package uz.master.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import uz.master.DTOs.AuthUser;

import java.util.Optional;

@Repository
public interface AuthUserRepository extends JpaRepository<AuthUser, Long> {

    Optional<AuthUser> findAuthUserByUsernameAndDeletedFalse(String username);

    Optional<AuthUser> findAuthUserByIdAndDeletedFalse(Long id);


    AuthUser findAuthUserByNameIgnoreCase(String name);
}
