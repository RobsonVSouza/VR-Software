package com.vrSolutions.rentalsCar.service.impl;

import com.vrSolutions.rentalsCar.dto.CarDto;
import com.vrSolutions.rentalsCar.mapper.CarMapper;
import com.vrSolutions.rentalsCar.models.Car;
import com.vrSolutions.rentalsCar.repository.CarRepository;
import com.vrSolutions.rentalsCar.service.CarService;
import java.util.List;
import java.util.Optional;
import javax.persistence.EntityExistsException;
import javax.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class CarServiceImpl implements CarService {

    @Autowired
    private static CarRepository carRepository;

    @Autowired
    private static CarMapper carMapper;

    @Override public CarDto save(CarDto dto){
        Car carEntity = carRepository.findByLicensePlate(dto.getLicensePlate());
        if (carEntity != null){
            throw new EntityExistsException("Já existe carro cadastrado");
        }
        return carMapper.toDto(carRepository.save(carMapper.toEntity(dto)));
    }

    @Override public CarDto update(CarDto dto){
        Car carEntity = carRepository.findByLicensePlate(dto.getLicensePlate());
        if (carEntity == null){
            throw new EntityExistsException("Não existe carro cadastrado");
        }
        return carMapper.toDto(carRepository.save(carMapper.toEntity(dto)));
    }

    @Override public CarDto findById(Long id){
        Optional<Car> carOptional = carRepository.findById(id);
        return carMapper.toDto(carOptional.get());
    }

    @Override public List<CarDto> getAll() {
        return carMapper.toListDto(carRepository.findAll());
    }

    @Override public void delete(Long id){
        Optional<Car> carOptional = carRepository.findById(id);

        if (carOptional.isEmpty()){
            throw new EntityNotFoundException("Não foi possivel deletar o carro");
        }
        carRepository.deleteById(id);
    }

}
