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
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CustomerServiceImpl implements CustomerService {

    private final CustomerRepository customerRepository;

    private final CustomerMapper customerMapper;

    @Override public CustomerDto save(CustomerDto dto){
        Customer customerEntity = customerRepository.findByDriverLicense(dto.getDriverLicense());
        if (customerEntity != null){
            throw new EntityExistsException("Já existe cliente cadastrado");
        }
        return customerMapper.toDto(customerRepository.save(customerMapper.toEntity(dto)));
    }

    @Override public CustomerDto update(Long id, CustomerDto dto){
        Optional<Customer> customerEntity = customerRepository.findById(id);
        if (customerEntity.isEmpty()){
            throw new EntityNotFoundException("O cliente não existe no cadastro");
        }
        return customerMapper.toDto(customerRepository.save(customerMapper.toEntity(dto)));
    }

    @Override public CustomerDto findById(Long id){
        Optional<Customer> customerOptional = customerRepository.findById(id);
        if (customerOptional.isEmpty()){
            throw new EntityNotFoundException("O cliente não existe no cadastro");
        }
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
