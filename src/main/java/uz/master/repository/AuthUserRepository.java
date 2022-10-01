package uz.master.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import uz.master.DTOs.AuthUser;

@Repository
public interface AuthUserRepository extends JpaRepository<AuthUser, Long> {
}
