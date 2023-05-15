package org.example;

public class PriceMapper extends Mapper<Price, PriceDto> {

    @Override
    public Price mapDto(PriceDto dto) {
        return Price.builder()
                .id(dto.getId())
                .instrumentName(dto.getInstrumentName())
                .bid(dto.getBid())
                .ask(dto.getAsk())
                .timestamp(dto.getTimestamp())
                .build();
    }

    @Override
    public PriceDto mapEntity(Price entity) {
        return PriceDto.builder()
                .id(entity.getId())
                .instrumentName(entity.getInstrumentName())
                .bid(entity.getBid())
                .ask(entity.getAsk())
                .timestamp(entity.getTimestamp())
                .build();
    }
}
