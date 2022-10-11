package com.vrSolutions.rentalsCar.controllers;

import com.vrSolutions.rentalsCar.dto.CarDto;
import com.vrSolutions.rentalsCar.dto.CustomerDto;
import com.vrSolutions.rentalsCar.service.CustomerService;
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
@RequestMapping("/customer")
public class CustomerController {

    @Autowired
    private CustomerService customerServiceImpl;

    @PostMapping
    public ResponseEntity<CustomerDto> save(@RequestBody @Valid CustomerDto customerDto){
        return ResponseEntity.status(HttpStatus.OK).body(customerServiceImpl.save(customerDto));
    }

    @PutMapping("/{id}")
    public ResponseEntity<CustomerDto> update(@RequestBody CustomerDto customerDto){
        return ResponseEntity.status(HttpStatus.OK).body(customerServiceImpl.update(customerDto));
    }

    @GetMapping("/{id}")
    public ResponseEntity<CustomerDto> findById(@PathVariable Long id){
        return ResponseEntity.status(HttpStatus.OK).body(customerServiceImpl.findById(id));
    }

    @GetMapping
    public ResponseEntity<List<CustomerDto>> getAll(@PathVariable Long id){
        return ResponseEntity.status(HttpStatus.OK).body(customerServiceImpl.getAll());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id){
        customerServiceImpl.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
