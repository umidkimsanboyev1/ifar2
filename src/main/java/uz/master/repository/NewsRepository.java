package uz.master.repository;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import uz.master.domain.News;

import java.util.List;

@Repository
public interface NewsRepository extends JpaRepository<News, Long> {

    List<News> findNewsByNewsTrueAndDeletedFalseAndActiveTrue(Pageable pageable);
    List<News> findNewsBySeminarTrueAndDeletedFalseAndActiveTrue(Pageable pageable);

}
