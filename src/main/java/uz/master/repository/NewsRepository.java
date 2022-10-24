package uz.master.repository;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import uz.master.domain.News;

import java.util.List;

public interface NewsRepository extends JpaRepository<News, Long> {

    List<News> findNewsByNewsTrueAndDeletedFalseOrderByCreatedDateDesc(Pageable pageable);
    List<News> findNewsByNewsTrueAndDeletedFalseOrderByCreatedDateAsc(Pageable pageable);

    List<News> findNewsByNewsTrueAndDeletedFalseAndTitleContainingIgnoreCaseAndBodyContainingIgnoreCase(String title, String body);
    List<News> findNewsBySeminarTrueAndDeletedFalseAndTitleContainingIgnoreCaseAndBodyContainingIgnoreCase(String title, String body);

    List<News> findNewsBySeminarTrueAndDeletedFalseOrderByCreatedDateDesc(Pageable pageable);
    List<News> findNewsBySeminarTrueAndDeletedFalseOrderByCreatedDateAsc(Pageable pageable);

}
