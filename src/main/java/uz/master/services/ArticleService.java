package uz.master.services;

import org.springframework.stereotype.Service;
import uz.master.DTOs.ArticleCreateDTO;
import uz.master.domain.Articles;
import uz.master.mapper.ArticleMapper;
import uz.master.repository.ArticleRepository;

@Service
public class ArticleService {

    private final ArticleRepository repository;
    private final FileStorageService fileStorageService;
    private final ArticleMapper mapper;

    public ArticleService(ArticleRepository repository, FileStorageService fileStorageService, ArticleMapper mapper) {
        this.repository = repository;
        this.fileStorageService = fileStorageService;
        this.mapper = mapper;
    }


    public String createArticle(ArticleCreateDTO dto) {
        try {
            Articles entity = mapper.toEntity(dto);
            entity.setLogo("/uploadsFile/" + fileStorageService.store(dto.getLogo()));
            entity.setDeleted(false);
            entity.setActive(true);
            repository.save(entity);
        } catch (Exception e){
            return e.getMessage();
        }
        return "Successfully saved!";
    }

}
