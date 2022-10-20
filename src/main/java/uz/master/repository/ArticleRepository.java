package uz.master.repository;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import uz.master.domain.Articles;

import java.util.List;

public interface ArticleRepository extends JpaRepository<Articles, Long> {

    List<Articles> findArticlesByThemeContainingIgnoreCaseOrAuthorsContainingIgnoreCaseAndDeletedFalseAndActiveTrue(String theme, String authors);
    List<Articles> findArticlesByDeletedFalseAndActiveTrueOrderByPublishedAsc(Pageable pageable);
    List<Articles> findArticlesByDeletedFalseAndActiveTrueOrderByPublishedDesc(Pageable pageable);
}
