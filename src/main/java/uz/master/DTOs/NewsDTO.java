package uz.master.DTOs;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class NewsDTO {

    private String title;
    private String body;
    private boolean news;
    private boolean seminar;
    private String picture;

}
