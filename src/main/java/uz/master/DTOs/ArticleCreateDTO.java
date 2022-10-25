package uz.master.DTOs;

import lombok.Getter;
import lombok.Setter;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Getter
@Setter
public class ArticleCreateDTO {
    private String theme;
    private String authors;
    private String metaData;
    private String abstraction;
    private String downloadLink;

}
