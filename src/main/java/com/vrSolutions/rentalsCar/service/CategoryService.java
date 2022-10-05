package com.vrSolutions.rentalsCar.service;

import com.vrSolutions.rentalsCar.dto.CategoryDto;
import com.vrSolutions.rentalsCar.mapper.CategoryMapper;
import com.vrSolutions.rentalsCar.models.Category;
import com.vrSolutions.rentalsCar.repository.CategoryRepository;
import java.util.List;
import java.util.Optional;
import javax.persistence.EntityExistsException;
import javax.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CategoryService {

    @Autowired
    private static CategoryRepository categoryRepository;

    @Autowired
    private static CategoryMapper categoryMapper;

    public CategoryDto save(CategoryDto dto){
        Category CategoryEntity = categoryRepository.findByName(dto.getName());
        if (CategoryEntity != null){
            throw new EntityExistsException("Já existe categoria cadastrado");
        }
        return categoryMapper.toDto(categoryRepository.save(categoryMapper.toEntity(dto)));
    }

    public CategoryDto update(CategoryDto dto){
        Category CategoryEntity = categoryRepository.findByName(dto.getName());
        if (CategoryEntity == null){
            throw new EntityExistsException("Não existe categoria cadastrada");
        }
        return categoryMapper.toDto(categoryRepository.save(categoryMapper.toEntity(dto)));
    }

    public CategoryDto findById(Long id){
        Optional<Category> CategoryOptional = categoryRepository.findById(id);
        if (CategoryOptional.isEmpty()){
            throw new EntityNotFoundException("A categoria não existe");
        }
        return categoryMapper.toDto(CategoryOptional.get());
    }

    public List<CategoryDto> getAll() {
        return categoryMapper.toListDto(categoryRepository.findAll());
    }

    public void delete(Integer id){
        Optional<Category> carOptional = categoryRepository.findById(Long.valueOf(id));

        if (carOptional.isEmpty()){
            throw new EntityNotFoundException("Não foi possivel deletar a categoria");
        }
        categoryRepository.deleteById(Long.valueOf(id));
    }


}
