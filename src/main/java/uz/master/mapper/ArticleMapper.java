package uz.master.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import uz.master.DTOs.ArticleCreateDTO;
import uz.master.DTOs.ArticleThymeleafDTO;
import uz.master.domain.Articles;

@Mapper(componentModel = "spring")
public interface ArticleMapper {

    @Mapping(target = "logo", ignore = true)
    Articles toEntity(ArticleCreateDTO dto);

    @Mapping(target = "universities", ignore = true)
    @Mapping(target = "authors", ignore = true)
    ArticleThymeleafDTO toThymeleafDTO(Articles articles);
}
