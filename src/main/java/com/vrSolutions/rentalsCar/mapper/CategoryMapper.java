package com.vrSolutions.rentalsCar.mapper;

import com.vrSolutions.rentalsCar.dto.CategoryDto;
import com.vrSolutions.rentalsCar.models.Category;
import java.util.List;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public abstract class CategoryMapper {

    public abstract CategoryDto toDto(Category entity);
    @Mapping(target = "createdAt", ignore = true)
    public abstract Category toEntity(CategoryDto dto);

    public abstract List<CategoryDto> toListDto(List<Category> entityList);

}
