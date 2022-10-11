package com.vrSolutions.rentalsCar.service.impl;

import com.vrSolutions.rentalsCar.dto.SpecificationDto;
import com.vrSolutions.rentalsCar.mapper.SpecificationMapper;
import com.vrSolutions.rentalsCar.models.Specification;
import com.vrSolutions.rentalsCar.repository.SpecificationRepository;
import com.vrSolutions.rentalsCar.service.SpecificationService;
import java.util.List;
import java.util.Optional;
import javax.persistence.EntityExistsException;
import javax.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SpecificationServiceImpl implements SpecificationService {

    @Autowired
    private static SpecificationRepository specificationRepository;

    @Autowired
    private static SpecificationMapper specificationMapper;

    @Override public SpecificationDto save(SpecificationDto dto){
        Specification specificationEntity = specificationRepository.findByName(dto.getName());
        if (specificationEntity != null){
            throw new EntityExistsException("Já espefificaçao cadastrada");
        }
        return specificationMapper.toDto(specificationRepository.save(specificationMapper.toEntity(dto)));
    }

    @Override public SpecificationDto update(SpecificationDto dto){
        Specification specificationEntity = specificationRepository.findByName(dto.getName());
        if (specificationEntity == null){
            throw new EntityNotFoundException("Não espefificaçao cadastrada");
        }
        return specificationMapper.toDto(specificationRepository.save(specificationMapper.toEntity(dto)));
    }

    @Override public SpecificationDto findById(Long id){
        Optional<Specification> specificationOptional = specificationRepository.findById(id);
        if (specificationOptional.isEmpty()){
            throw new EntityNotFoundException("A espefificaçao não existe");
        }
        return specificationMapper.toDto(specificationOptional.get());
    }

    @Override public List<SpecificationDto> getAll() {
        return specificationMapper.toListDto(specificationRepository.findAll());
    }

    @Override public void delete(Long id){
        Optional<Specification> specificationOptional = specificationRepository.findById(id);

        if (specificationOptional.isEmpty()){
            throw new EntityNotFoundException("Não foi possivel deletar a especificaçao");
        }
        specificationRepository.deleteById(id);
    }
}
