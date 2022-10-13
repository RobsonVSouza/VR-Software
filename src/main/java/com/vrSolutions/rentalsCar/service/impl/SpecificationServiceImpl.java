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
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
class SpecificationServiceImpl implements SpecificationService {

    private final SpecificationRepository specificationRepository;

    private final SpecificationMapper specificationMapper;

    @Override
    public SpecificationDto save(SpecificationDto dto){
        Optional <Specification> specificationEntity = specificationRepository.findByName(dto.getName());
        if (specificationEntity.isPresent()){
            throw new EntityExistsException("Já espefificaçao cadastrada");
        }
        return specificationMapper.toDto(specificationRepository.save(specificationMapper.toEntity(dto)));
    }

    @Override
    public SpecificationDto update(Long id,SpecificationDto dto){
        Optional <Specification> specificationEntity = specificationRepository.findById(id);
        if (specificationEntity.isEmpty()){
            throw new EntityNotFoundException("Não existe");
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
