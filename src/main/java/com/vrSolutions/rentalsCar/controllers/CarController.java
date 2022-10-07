package com.vrSolutions.rentalsCar.controllers;

import java.util.List;
import javax.validation.Valid;
import com.vrSolutions.rentalsCar.dto.CarDto;
import com.vrSolutions.rentalsCar.service.CarService;
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
@RequestMapping("/car")
public class CarController {

    @Autowired
    private CarService carServiceImpl;

    @PostMapping(value = "/v1/addCar")
    public ResponseEntity<CarDto> save(@RequestBody @Valid CarDto carDto){
        return ResponseEntity.status(HttpStatus.OK).body(carServiceImpl.save(carDto));
    }

    @PutMapping ("/{id}")
    public ResponseEntity<CarDto> update(@RequestBody CarDto carDto){
        return ResponseEntity.status(HttpStatus.OK).body(carServiceImpl.update(carDto));
    }

    @GetMapping("/{id}")
    public ResponseEntity<CarDto> findById(@PathVariable Long id){
        return ResponseEntity.status(HttpStatus.OK).body(carServiceImpl.findById(id));
    }

    @GetMapping
    public ResponseEntity<List<CarDto>> getAll(@PathVariable Long id){
        return ResponseEntity.status(HttpStatus.OK).body(carServiceImpl.getAll());
    }



    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id){
        carServiceImpl.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }


}
