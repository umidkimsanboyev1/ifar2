package uz.master.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import uz.master.domain.Uploads;

import java.util.Optional;

public interface UploadsRepository extends JpaRepository<Uploads, Long> {
    Optional<Uploads> findByGeneratedName(String filename);
}
