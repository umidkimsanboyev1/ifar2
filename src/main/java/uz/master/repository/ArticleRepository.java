package uz.master.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import uz.master.domain.Articles;

public interface ArticleRepository extends JpaRepository<Articles, Long> {
}
