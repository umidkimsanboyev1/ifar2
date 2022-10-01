package uz.master.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import uz.master.domain.Articles;

@Repository
public interface ArticleRepository extends JpaRepository<Articles, Long> {



}
