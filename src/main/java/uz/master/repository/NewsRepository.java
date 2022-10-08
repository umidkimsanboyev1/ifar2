package uz.master.repository;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import uz.master.domain.News;

import java.util.List;

public interface NewsRepository extends JpaRepository<News, Long> {

    List<News> findNewsByNewsTrueAndDeletedFalse(Pageable pageable);

    List<News> findNewsBySeminarTrueAndDeletedFalse(Pageable pageable);

}
