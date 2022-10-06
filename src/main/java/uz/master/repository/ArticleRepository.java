package uz.master.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import uz.master.domain.Articles;


public interface ArticleRepository extends JpaRepository<Articles, Long> {



}
