package com.vrSolutions.rentalsCar.service;

import com.vrSolutions.rentalsCar.dto.BrandDto;
import com.vrSolutions.rentalsCar.mapper.BrandMapper;
import com.vrSolutions.rentalsCar.models.Brand;
import com.vrSolutions.rentalsCar.repository.BrandRepository;
import java.util.List;
import java.util.Optional;
import javax.persistence.EntityExistsException;
import javax.persistence.EntityNotFoundException;
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
            throw new EntityExistsException("Não tem marca cadastrada");
        }
        return brandMapper.toDtoBrand(brandRepository.save(brandMapper.toBrandEntity(dtoBrand)));
    }

    public BrandDto findById(Long id){
        Optional<Brand> brandEntity = brandRepository.findById(id);
        if (brandEntity.isEmpty()){
            throw new EntityNotFoundException("A marca não existe no cadastro");
        }
        return brandMapper.toDtoBrand(brandEntity.get());
    }

    public List<BrandDto> getAll() {
        return brandMapper.toListDto(brandRepository.findAll());
    }

    public void delete(Integer id){
        Optional<Brand> brandOptional = brandRepository.findById(Long.valueOf(id));

        if (brandOptional.isEmpty()){
            throw new EntityNotFoundException("Não foi possivel deletar a marca");
        }
        brandRepository.deleteById(Long.valueOf(id));
    }



}
