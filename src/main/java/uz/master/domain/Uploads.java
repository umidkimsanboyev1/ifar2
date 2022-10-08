package uz.master.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Getter
@Setter
@Entity
@NoArgsConstructor
public class Uploads {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String originalName;
    private String generatedName;
    private String contentType;
    private long size;
    private String path;

    public Uploads(String originalFilename, String generatedName, String contentType, String s, long size) {
        this.originalName = originalFilename;
        this.generatedName = generatedName;
        this.contentType = contentType;
        this.path = s;
        this.size = size;
    }
}
