package com.vrSolutions.rentalsCar.controllers;

import com.vrSolutions.rentalsCar.dto.BrandDto;
import com.vrSolutions.rentalsCar.dto.CarDto;
import com.vrSolutions.rentalsCar.service.BrandService;
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
@RequestMapping("/brand")
public class BrandController {

    @Autowired
    private BrandService brandService;

    @PostMapping(value = "v1/addBrand")
    public ResponseEntity<BrandDto> save(@RequestBody @Valid BrandDto brandDto){
        return ResponseEntity.status(HttpStatus.OK).body(brandService.save(brandDto));
    }

    @PutMapping("/{id}")
    public ResponseEntity<BrandDto> update(@RequestBody BrandDto brandDto){
        return ResponseEntity.status(HttpStatus.OK).body(brandService.update(brandDto));
    }

    @GetMapping("/{id}")
    public ResponseEntity<BrandDto> findById(@PathVariable Long id){
        return ResponseEntity.status(HttpStatus.OK).body(brandService.findById(id));
    }

    @GetMapping
    public ResponseEntity<List<BrandDto>> getAll(@PathVariable Long id){
        return ResponseEntity.status(HttpStatus.OK).body(brandService.getAll());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id){
        brandService.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
