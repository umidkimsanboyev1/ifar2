package uz.master.services;

import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import uz.master.DTOs.NewsDTO;
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
        return repository.findNewsByNewsTrueAndDeletedFalse(PageRequest.of(page, 10));
    }


    public List<News> getAllSeminars(int page) {
        return repository.findNewsBySeminarTrueAndDeletedFalse(PageRequest.of(page, 5));
    }

    public String createNews(NewsDTO dto) {
        return null;
    }
}
