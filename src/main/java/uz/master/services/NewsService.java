package uz.master.services;

import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import uz.master.DTOs.NewsDTO;
import uz.master.domain.News;
import uz.master.mapper.NewsMapper;
import uz.master.repository.NewsRepository;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Service
public class NewsService {

    private final NewsRepository repository;
    private final NewsMapper mapper;
    private final FileStorageService fileStorageService;

    public NewsService(NewsRepository repository, NewsMapper mapper, FileStorageService fileStorageService) {
        this.repository = repository;
        this.mapper = mapper;
        this.fileStorageService = fileStorageService;
    }

    public List<News> getAllNews(int page, boolean byDate) {
        List<News> content;
        if(byDate) content = repository.findNewsByNewsTrueAndDeletedFalseOrderByCreatedDateDesc(PageRequest.of(page, 10));
        else content = repository.findNewsByNewsTrueAndDeletedFalseOrderByCreatedDateAsc(PageRequest.of(page, 10));
        content.forEach(news -> news.setSeen(news.getSeen() + 1));
        repository.saveAll(content);
        return content;
    }


    public List<News> getAllSeminars(int page, boolean byDate) {
        List<News> content;
        if(byDate) content = repository.findNewsBySeminarTrueAndDeletedFalseOrderByCreatedDateDesc(PageRequest.of(page, 10));
        else content = repository.findNewsBySeminarTrueAndDeletedFalseOrderByCreatedDateAsc(PageRequest.of(page, 10));
        content.forEach(news -> news.setSeen(news.getSeen() + 1));
        repository.saveAll(content);
        return content;
    }

    public String createNews(NewsDTO dto) {
        SimpleDateFormat formatter = new SimpleDateFormat("dd:MM:yyyy HH:mm");
        try{
            MultipartFile picture = dto.getPicture();
            News entity = mapper.toEntity(dto);
            entity.setPicture("/uploads/" + fileStorageService.store(picture));
            entity.setDeleted(false);
            entity.setCreatedDate(formatter.format(new Date()));
            entity.setSeen(1);
            entity.setNews(true);
            repository.save(entity);
        } catch (Exception e){
            System.out.println(e.getMessage());
            return e.getMessage();
        }
        return "Successfully added news";
    }


    public List<News> newsSearch(String text) {
        List<News> content = repository.findNewsByNewsTrueAndDeletedFalseAndTitleContainingIgnoreCaseAndBodyContainingIgnoreCase(text, text);
        content.forEach(news -> news.setSeen(news.getSeen() + 1));
        repository.saveAll(content);
        return content;
    }

    public List<News> seminarSearch(String text) {
        List<News> content = repository.findNewsBySeminarTrueAndDeletedFalseAndTitleContainingIgnoreCaseAndBodyContainingIgnoreCase(text, text);
        content.forEach(news -> news.setSeen(news.getSeen() + 1));
        repository.saveAll(content);
        return content;
    }
}
