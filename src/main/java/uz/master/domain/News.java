package uz.master.domain;


import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;

@Entity
@Getter
@Setter
public class News {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;
    private String body;

    private boolean news;
    private boolean seminar;

    private String picture;

    @CreationTimestamp
    private Date date;
    private Integer seen;
    private boolean deleted;
    private boolean active;
}
