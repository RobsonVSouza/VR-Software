package com.vrSolutions.rentalsCar.service;

import static org.springframework.data.jpa.domain.AbstractPersistable_.id;

import com.vrSolutions.rentalsCar.dto.BrandDto;
import com.vrSolutions.rentalsCar.mapper.BrandMapper;
import com.vrSolutions.rentalsCar.models.Brand;
import com.vrSolutions.rentalsCar.repository.BrandRepository;
import javax.persistence.EntityExistsException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BrandService {

    @Autowired
    private static BrandRepository brandRepository;

    @Autowired
    private static BrandMapper brandMapper;

    public BrandDto save(BrandDto dtoBrand){
        Brand brandEntity = brandRepository.findByCar(dtoBrand.getCars());
        if (brandEntity != null){
            throw new EntityExistsException("Já cadastrado");
        }
        return brandMapper.toDtoBrand(brandRepository.save(brandMapper.toBrandEntity(dtoBrand)));
    }

    public BrandDto update(BrandDto dtoBrand){
        Brand brandEntity = brandRepository.findByCar(dtoBrand.getCars());
        if (brandEntity == null){
            throw new EntityExistsException("Não tem aluguel cadastrado");
        }
        return brandMapper.toDtoBrand(brandRepository.save(brandMapper.toBrandEntity(dtoBrand)));
    }



}
