package uz.master.services;


import lombok.NonNull;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.io.FileSystemResource;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;
import uz.master.DTOs.UploadsDto;
import uz.master.domain.Uploads;
import uz.master.repository.UploadsRepository;

import javax.annotation.PostConstruct;
import java.io.IOException;
import java.nio.file.*;
import java.util.Optional;

@Slf4j
@Service("fileService")
public class FileStorageService {
    public static final String UPLOADS_URL = "/DBProjects/IFAR2/src/main/resources/static/images/";
    public static final Path PATH = Paths.get(UPLOADS_URL);

    private final UploadsRepository repository;

    public FileStorageService(UploadsRepository repository) {
        this.repository = repository;
    }

    @PostConstruct
    public void init() {
        if (!Files.exists(PATH)) {
            try {
                Files.createDirectories(PATH);
            } catch (IOException e) {
                e.printStackTrace();
                log.error(e.getMessage(), e);
            }
        }
    }

    @SneakyThrows
    public String store(@NonNull MultipartFile file) {
        String originalFilename = file.getOriginalFilename();
        String extension = StringUtils.getFilenameExtension(file.getOriginalFilename());
        String generatedName = "%s.%s".formatted(System.currentTimeMillis(), extension);
        Path rootPath = Paths.get(UPLOADS_URL, generatedName);
        Files.copy(file.getInputStream(), rootPath, StandardCopyOption.REPLACE_EXISTING);
        Uploads uploadedFile = new Uploads(originalFilename, generatedName, file.getContentType(), (UPLOADS_URL + generatedName), file.getSize());
        repository.save(uploadedFile);
        return generatedName;
    }


    public UploadsDto loadResource(@NonNull String fileName) throws NoSuchFileException {
        Optional<Uploads> uploads = repository.findByGeneratedName(fileName);
        if (uploads.isEmpty()) throw new NoSuchFileException("not found");
        FileSystemResource resource = new FileSystemResource(UPLOADS_URL + fileName);
        return UploadsDto.builder().resource(resource).originalName(uploads.get().getOriginalName()).newName(uploads.get().getGeneratedName()).contentType(uploads.get().getContentType()).size(uploads.get().getSize()).build();
    }
}
