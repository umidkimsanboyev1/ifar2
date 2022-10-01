package uz.master.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import uz.master.domain.News;

@Repository
public interface NewsRepository extends JpaRepository<News, Long> {
}
