package com.vrSolutions.rentalsCar.service.impl;

import com.vrSolutions.rentalsCar.dto.BrandDto;
import com.vrSolutions.rentalsCar.exception.DefaultException;
import com.vrSolutions.rentalsCar.mapper.BrandMapper;
import com.vrSolutions.rentalsCar.models.Brand;
import com.vrSolutions.rentalsCar.repository.BrandRepository;
import com.vrSolutions.rentalsCar.service.BrandService;
import java.util.List;
import java.util.Optional;
import javax.persistence.EntityExistsException;
import javax.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
class BrandServiceImpl implements BrandService {

    private final BrandRepository brandRepository;

    private final BrandMapper brandMapper;

    @Override
    public BrandDto save(BrandDto dtoBrand){
        Optional<Brand> brandEntity = brandRepository.findByName(dtoBrand.getName());
        if (brandEntity.isPresent()){
            throw new DefaultException("Já cadastrado");
        }
        return brandMapper.toDtoBrand(brandRepository.save(brandMapper.toBrandEntity(dtoBrand)));
    }

    @Override
    public BrandDto update(Long id, BrandDto dtoBrand){
        Optional<Brand> brandEntity = brandRepository.findById(id);
        if (brandEntity.isEmpty()){
            throw new DefaultException("Não existe");
        }
        return brandMapper.toDtoBrand(brandRepository.save(brandMapper.toBrandEntity(dtoBrand)));
    }

    @Override
    public BrandDto findById(Long id){
        Optional<Brand> brandEntity = brandRepository.findById(id);
        if (brandEntity.isEmpty()){
            throw new DefaultException("A marca não existe no cadastro");
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
            throw new DefaultException("Não foi possivel deletar a marca");
        }
        brandRepository.deleteById(id);
    }



}
