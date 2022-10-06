package com.vrSolutions.rentalsCar.controllers;

import com.vrSolutions.rentalsCar.dto.CategoryDto;
import com.vrSolutions.rentalsCar.service.CategoryService;
import java.util.List;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/category")
public class CategoryController {

    @Autowired
    private static CategoryService categoryServiceImpl;

    @PostMapping(value = "v1/addCategory")
    public ResponseEntity<CategoryDto> save(@RequestBody @Valid CategoryDto categoryDto){
        return ResponseEntity.status(HttpStatus.OK).body(categoryServiceImpl.save(categoryDto));
    }

    @PutMapping("/{id}")
    public ResponseEntity<CategoryDto> update(@RequestBody CategoryDto categoryDto){
        return ResponseEntity.status(HttpStatus.OK).body(categoryServiceImpl.update(categoryDto));
    }

    @GetMapping("/{id}")
    public ResponseEntity<CategoryDto> findById(@PathVariable Long id){
        return ResponseEntity.status(HttpStatus.OK).body(categoryServiceImpl.findById(id));
    }

    @GetMapping
    public ResponseEntity<List<CategoryDto>> getAll(@PathVariable Long id){
        return ResponseEntity.status(HttpStatus.OK).body(categoryServiceImpl.getAll());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id){
        categoryServiceImpl.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
