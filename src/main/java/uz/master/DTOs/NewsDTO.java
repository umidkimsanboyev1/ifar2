package uz.master.DTOs;

import lombok.Getter;
import lombok.Setter;
import org.springframework.web.multipart.MultipartFile;

@Getter
@Setter
public class NewsDTO {

    private String title;
    private String body;
    private String link;
    private boolean news;
    private boolean seminar;
    private MultipartFile picture;

}
