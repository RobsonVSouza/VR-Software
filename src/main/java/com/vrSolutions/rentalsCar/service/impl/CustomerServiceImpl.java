package com.vrSolutions.rentalsCar.service.impl;

import com.vrSolutions.rentalsCar.dto.CustomerDto;
import com.vrSolutions.rentalsCar.mapper.CustomerMapper;
import com.vrSolutions.rentalsCar.models.Customer;
import com.vrSolutions.rentalsCar.repository.CustomerRepository;
import com.vrSolutions.rentalsCar.service.CustomerService;
import java.util.List;
import java.util.Optional;
import javax.persistence.EntityExistsException;
import javax.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    private static CustomerRepository customerRepository;

    @Autowired
    private static CustomerMapper customerMapper;

    @Override public CustomerDto save(CustomerDto dto){
        Customer customerEntity = customerRepository.findByDriverLicense(dto.getDriverLicense());
        if (customerEntity != null){
            throw new EntityExistsException("Já existe cliente cadastrado");
        }
        return customerMapper.toDto(customerRepository.save(customerMapper.toEntity(dto)));
    }

    @Override public CustomerDto update(CustomerDto dto){
        Customer customerEntity = customerRepository.findByDriverLicense(dto.getDriverLicense());
        if (customerEntity == null){
            throw new EntityExistsException("Não existe cliente cadastrado");
        }
        return customerMapper.toDto(customerRepository.save(customerMapper.toEntity(dto)));
    }

    @Override public CustomerDto findById(Long id){
        Optional<Customer> customerOptional = customerRepository.findById(id);
        return customerMapper.toDto(customerOptional.get());
    }

    @Override public List<CustomerDto> getAll() {
        return customerMapper.toListDto(customerRepository.findAll());
    }

    @Override public void delete(Long id){
        Optional<Customer> customerOptional = customerRepository.findById(id);

        if (customerOptional.isEmpty()){
            throw new EntityNotFoundException("Não foi possivel deletar o cliente");
        }
        customerRepository.deleteById(id);
    }

}
