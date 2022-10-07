package com.vrSolutions.rentalsCar.service.impl;

import com.vrSolutions.rentalsCar.dto.CarImageDto;
import com.vrSolutions.rentalsCar.mapper.CarImageMapper;
import com.vrSolutions.rentalsCar.models.CarImage;
import com.vrSolutions.rentalsCar.repository.CarImageRepository;
import com.vrSolutions.rentalsCar.service.CarImageService;
import java.util.List;
import java.util.Optional;
import javax.persistence.EntityExistsException;
import javax.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CarImageServiceImpl implements CarImageService {

    @Autowired
    private static CarImageRepository carImageRepository;

    @Autowired
    private static CarImageMapper carImageMapper;

    
    @Override public CarImageDto save(CarImageDto dto){
        CarImage carImageEntity = carImageRepository.findByImage(dto.getImage());
        if (carImageEntity != null){
            throw new EntityExistsException("Já existe imagem do carro cadastrado");
        }
        return carImageMapper.toDto(carImageRepository.save(carImageMapper.toEntity(dto)));
    }

    @Override public CarImageDto update(CarImageDto dto){
        CarImage carImageEntity = carImageRepository.findByImage(dto.getImage());
        if (carImageEntity == null){
            throw new EntityExistsException("Não existe imagem do carro cadastrado");
        }
        return carImageMapper.toDto(carImageRepository.save(carImageMapper.toEntity(dto)));
    }

    @Override public CarImageDto findById(Long id){
        Optional<CarImage> carImageOptional = carImageRepository.findById(id);
        return carImageMapper.toDto(carImageOptional.get());
    }

    @Override public List<CarImageDto> getAll() {
        return carImageMapper.toListDto(carImageRepository.findAll());
    }

    @Override public void delete(Long id){
        Optional<CarImage> carOptional = carImageRepository.findById(id);

        if (carOptional.isEmpty()){
            throw new EntityNotFoundException("Não foi possivel deletar a imagem do carro");
        }
        carImageRepository.deleteById(id);
    }


}
