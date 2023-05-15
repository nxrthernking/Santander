package org.example.service;

import org.example.mapper.PriceMapper;
import org.example.model.dto.PriceDto;
import org.example.repository.PriceRepository;

public class PriceService {
    private final PriceRepository repository;

    private final PriceMapper mapper;

    public PriceService(PriceRepository repository, PriceMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    public PriceDto getLastPrice() {
        return mapper.mapEntity(repository.getLastPrice());
    }

    public void save(PriceDto dto) {
        repository.save(mapper.mapDto(dto));
    }

}
