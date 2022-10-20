package uz.master.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;

@Entity
@Getter
@Setter
public class Articles {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String theme;
    private String universities;
    private String authors;
    private String logo;
    private String downloadLink;
    private String publishedLink;

    private String accepted;
    private String received;
    private String revised;
    private String published;
    private Date createdAt;
    private boolean openAccess;
    private boolean deleted;
    private boolean active;

}
