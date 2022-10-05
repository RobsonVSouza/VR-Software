package com.vrSolutions.rentalsCar.service;

import com.vrSolutions.rentalsCar.dto.CarDto;
import com.vrSolutions.rentalsCar.mapper.CarMapper;
import com.vrSolutions.rentalsCar.models.Car;
import com.vrSolutions.rentalsCar.repository.CarRepository;
import java.util.List;
import java.util.Optional;
import javax.persistence.EntityExistsException;
import javax.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class CarService {

    @Autowired
    private static CarRepository carRepository;

    @Autowired
    private static CarMapper carMapper;

    public CarDto save(CarDto dto){
        Car carEntity = carRepository.findByLicensePlate(dto.getLicensePlate());
        if (carEntity != null){
            throw new EntityExistsException("Já existe carro cadastrado");
        }
        return carMapper.toDto(carRepository.save(carMapper.toEntity(dto)));
    }

    public CarDto update(CarDto dto){
        Car carEntity = carRepository.findByLicensePlate(dto.getLicensePlate());
        if (carEntity == null){
            throw new EntityExistsException("Não existe carro cadastrado");
        }
        return carMapper.toDto(carRepository.save(carMapper.toEntity(dto)));
    }

    public CarDto findById(Long id){
        Optional<Car> carOptional = carRepository.findById(id);
        findCarById(carOptional);
        return carMapper.toDto(carOptional.get());
    }

    private static void findCarById(Optional<Car> carOptional) {
        if (carOptional.isEmpty()){
            throw new EntityNotFoundException("O carro não existe");
        }
    }

    public List<CarDto> getAll() {
        return carMapper.toListDto(carRepository.findAll());
    }

    public void delete(Integer id){
        Optional<Car> carOptional = carRepository.findById(Long.valueOf(id));

        if (carOptional.isEmpty()){
            throw new EntityNotFoundException("Não foi possivel deletar o carro");
        }
        carRepository.deleteById(Long.valueOf(id));
    }

}
