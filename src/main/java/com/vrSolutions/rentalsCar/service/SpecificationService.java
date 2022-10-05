package com.vrSolutions.rentalsCar.service;

import com.vrSolutions.rentalsCar.dto.SpecificationDto;
import com.vrSolutions.rentalsCar.mapper.SpecificationMapper;
import com.vrSolutions.rentalsCar.models.Specification;
import com.vrSolutions.rentalsCar.repository.SpecificationRepository;
import java.util.List;
import java.util.Optional;
import javax.persistence.EntityExistsException;
import javax.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SpecificationService {

    @Autowired
    private static SpecificationRepository specificationRepository;

    @Autowired
    private static SpecificationMapper specificationMapper;

    public SpecificationDto save(SpecificationDto dto){
        Specification specificationEntity = specificationRepository.findByName(dto.getName());
        if (specificationEntity != null){
            throw new EntityExistsException("Já espefificaçao cadastrada");
        }
        return specificationMapper.toDto(specificationRepository.save(specificationMapper.toEntity(dto)));
    }

    public SpecificationDto update(SpecificationDto dto){
        Specification specificationEntity = specificationRepository.findByName(dto.getName());
        if (specificationEntity == null){
            throw new EntityExistsException("Não espefificaçao cadastrada");
        }
        return specificationMapper.toDto(specificationRepository.save(specificationMapper.toEntity(dto)));
    }

    public SpecificationDto findById(Long id){
        Optional<Specification> specificationOptional = specificationRepository.findById(id);
        if (specificationOptional.isEmpty()){
            throw new EntityNotFoundException("A espefificaçao não existe");
        }
        return specificationMapper.toDto(specificationOptional.get());
    }

    public List<SpecificationDto> getAll() {
        return specificationMapper.toListDto(specificationRepository.findAll());
    }

    public void delete(Integer id){
        Optional<Specification> specificationOptional = specificationRepository.findById(Long.valueOf(id));

        if (specificationOptional.isEmpty()){
            throw new EntityNotFoundException("Não foi possivel deletar a espefificaçao");
        }
        specificationRepository.deleteById(Long.valueOf(id));
    }
}
