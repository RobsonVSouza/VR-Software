package com.vrSolutions.rentalsCar.service.impl;

import com.vrSolutions.rentalsCar.dto.RentalDto;
import com.vrSolutions.rentalsCar.exception.DefaultException;
import com.vrSolutions.rentalsCar.mapper.BrandMapper;
import com.vrSolutions.rentalsCar.mapper.RentalMapper;
import com.vrSolutions.rentalsCar.models.Brand;
import com.vrSolutions.rentalsCar.models.Rental;
import com.vrSolutions.rentalsCar.repository.BrandRepository;
import com.vrSolutions.rentalsCar.repository.RentalRepository;
import com.vrSolutions.rentalsCar.service.RentalService;
import java.util.List;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class RentalServiceImpl implements RentalService {

    private final RentalRepository rentalRepository;

    private final RentalMapper rentalMapper;

    @Override
    public RentalDto save(RentalDto dto) {
        Optional<Rental> rentalEntity = rentalRepository.findById(dto.getId());
        if (rentalEntity.isPresent()){
            throw new DefaultException("Já cadastrado");
        }
        return rentalMapper.toDto(rentalRepository.save(rentalMapper.toEntity(dto)));
    }

    @Override
    public RentalDto update(Long id, RentalDto dto) {
        return null;
    }

    @Override
    public RentalDto findById(Long id) {
        return null;
    }

    @Override
    public List<RentalDto> getAll() {
        return null;
    }

    @Override
    public void delete(Long id) {

    }
}
