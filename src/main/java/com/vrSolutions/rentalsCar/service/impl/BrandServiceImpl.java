package com.vrSolutions.rentalsCar.service.impl;

import com.vrSolutions.rentalsCar.dto.BrandDto;
import com.vrSolutions.rentalsCar.mapper.BrandMapper;
import com.vrSolutions.rentalsCar.models.Brand;
import com.vrSolutions.rentalsCar.repository.BrandRepository;
import com.vrSolutions.rentalsCar.service.BrandService;
import java.util.List;
import java.util.Optional;
import javax.persistence.EntityExistsException;
import javax.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
class BrandServiceImpl implements BrandService {

    @Autowired
    private static BrandRepository brandRepository;

    @Autowired
    private static BrandMapper brandMapper;

    @Override
    public BrandDto save(BrandDto dtoBrand){
        Optional<Brand> brandEntity = brandRepository.findByName(dtoBrand.getName());
        if (brandEntity.isPresent()){
            throw new EntityExistsException("Já cadastrado");
        }
        return brandMapper.toDtoBrand(brandRepository.save(brandMapper.toBrandEntity(dtoBrand)));
    }

    @Override
    public BrandDto update(BrandDto dtoBrand){
        Optional<Brand> brandEntity = brandRepository.findById(dtoBrand.getId());
        if (brandEntity.isPresent()){
            throw new EntityExistsException("Já cadastrado");
        }
        return brandMapper.toDtoBrand(brandRepository.save(brandMapper.toBrandEntity(dtoBrand)));
    }

    @Override
    public BrandDto findById(Long id){
        Optional<Brand> brandEntity = brandRepository.findById(id);
        if (brandEntity.isEmpty()){
            throw new EntityNotFoundException("A marca não existe no cadastro");
        }
        return brandMapper.toDtoBrand(brandEntity.get());
    }

    @Override
    public List<BrandDto> getAll() {
        return brandMapper.toListDto(brandRepository.findAll());
    }

    @Override
    public void delete(Long id){
        Optional<Brand> brandOptional = brandRepository.findById(id);

        if (brandOptional.isEmpty()){
            throw new EntityNotFoundException("Não foi possivel deletar a marca");
        }
        brandRepository.deleteById(id);
    }



}
