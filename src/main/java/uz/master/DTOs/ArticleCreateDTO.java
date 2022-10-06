package uz.master.DTOs;

import lombok.Getter;
import lombok.Setter;
import org.springframework.web.multipart.MultipartFile;

@Getter
@Setter
public class ArticleCreateDTO {
    private String theme;
    private String universities;
    private String authors;
    private MultipartFile logo;
    private String downloadLink;
    private String publishedLink;

    private String accepted;
    private String received;
    private String revised;
    private String published;

}
