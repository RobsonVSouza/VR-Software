package com.vrSolutions.rentalsCar.service.impl;

import com.vrSolutions.rentalsCar.dto.CategoryDto;
import com.vrSolutions.rentalsCar.mapper.CategoryMapper;
import com.vrSolutions.rentalsCar.models.Category;
import com.vrSolutions.rentalsCar.repository.CategoryRepository;
import com.vrSolutions.rentalsCar.service.CategoryService;
import java.util.List;
import java.util.Optional;
import javax.persistence.EntityExistsException;
import javax.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
class CategoryServiceImpl implements CategoryService {


    private final CategoryRepository categoryRepository;

    private final CategoryMapper categoryMapper;

    @Override
    public CategoryDto save(CategoryDto dto){
        Optional<Category> categoryEntity = categoryRepository.findByName(dto.getName());
        if (categoryEntity.isPresent()){
            throw new EntityExistsException("Já existe categoria cadastrado");
        }
        return categoryMapper.toDto(categoryRepository.save(categoryMapper.toEntity(dto)));
    }

    @Override public CategoryDto update(Long id, CategoryDto dto){
        Optional <Category> categoryEntity = categoryRepository.findById(id);
        if (categoryEntity.isEmpty()){
            throw new EntityNotFoundException("A categoria não existe");
        }
        return categoryMapper.toDto(categoryRepository.save(categoryMapper.toEntity(dto)));
    }

    @Override public CategoryDto findById(Long id){
        Optional<Category> categoryOptional = categoryRepository.findById(id);
        if (categoryOptional.isEmpty()){
            throw new EntityNotFoundException("A categoria não existe");
        }
        return categoryMapper.toDto(categoryOptional.get());
    }

    @Override public List<CategoryDto> getAll() {
        return categoryMapper.toListDto(categoryRepository.findAll());
    }

    @Override public void delete(Long id){
        Optional<Category> categoryOptional = categoryRepository.findById(id);

        if (categoryOptional.isEmpty()){
            throw new EntityNotFoundException("Não foi possivel deletar a categoria");
        }
        categoryRepository.deleteById(id);
    }


}
