package org.example;

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

}
