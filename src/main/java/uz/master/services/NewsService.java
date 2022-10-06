package uz.master.services;

import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import uz.master.domain.News;
import uz.master.repository.NewsRepository;

import java.util.List;

@Service
public class NewsService {

    private final NewsRepository repository;

    public NewsService(NewsRepository repository) {
        this.repository = repository;
    }

    public List<News> getAllNews(int page) {
        return repository.findNewsByNewsTrueAndDeletedFalseAndActiveTrue(PageRequest.of(page, 10));
    }


    public List<News> getAllSeminars(int page) {
        return repository.findNewsBySeminarTrueAndDeletedFalseAndActiveTrue(PageRequest.of(page, 5));
    }
}
