package uz.master.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import uz.master.DTOs.ArticleCreateDTO;
import uz.master.domain.Articles;

@Mapper(componentModel = "spring")
public interface ArticleMapper {

    @Mapping(target = "logo", ignore = true)
    Articles toEntity(ArticleCreateDTO dto);

}
