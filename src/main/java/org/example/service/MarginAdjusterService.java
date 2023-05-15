package org.example.service;

import org.example.model.Price;
import org.example.model.dto.PriceDto;
import org.example.parser.PriceParser;

import java.math.BigDecimal;

public class MarginAdjusterService {
    private static final BigDecimal BID_MARGIN = BigDecimal.valueOf(-0.001);
    private static final BigDecimal ASK_MARGIN = BigDecimal.valueOf(0.001);
    private final PriceParser priceParser;

    public MarginAdjusterService(PriceParser priceParser) {
        this.priceParser = priceParser;
    }

    public PriceDto adjustPrice(String messagePrice) {
        Price price = priceParser.parse(messagePrice);
        BigDecimal adjustedBid = price.getBid().add(price.getBid().multiply(BID_MARGIN));
        BigDecimal adjustedAsk = price.getAsk().add(price.getAsk().multiply(ASK_MARGIN));
        return createAdjustedPriceDto(price, adjustedBid, adjustedAsk);

    }

    private PriceDto createAdjustedPriceDto(Price price, BigDecimal adjustedBid, BigDecimal adjustedAsk) {
        return PriceDto.builder()
                .id(price.getId())
                .instrumentName(price.getInstrumentName())
                .bid(adjustedBid)
                .ask(adjustedAsk)
                .timestamp(price.getTimestamp())
                .build();
    }
}
