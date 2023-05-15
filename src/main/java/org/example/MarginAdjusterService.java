package org.example;

import java.math.BigDecimal;
import java.util.Arrays;

public class MarginAdjusterService {
    private static final BigDecimal BID_MARGIN = BigDecimal.valueOf(-0.001);
    private static final BigDecimal ASK_MARGIN = BigDecimal.valueOf(0.001);

    private final PriceRepository repository;
    private final  PriceParser priceParser;

    public MarginAdjusterService(PriceRepository repository, PriceParser priceParser) {
        this.repository = repository;
        this.priceParser = priceParser;
    }

    public Price adjustPrice(String messagePrice) {
        Price price = priceParser.parse(messagePrice);
        BigDecimal adjustedBid = price.getBid().add(price.getBid().multiply(BID_MARGIN));
        BigDecimal adjustedAsk = price.getAsk().add(price.getAsk().multiply(ASK_MARGIN));
        Price adjustedPrice = createAdjustedPrice(price, adjustedBid, adjustedAsk);
        repository.save(adjustedPrice);
        return adjustedPrice;
    }

    private Price createAdjustedPrice(Price price, BigDecimal adjustedBid, BigDecimal adjustedAsk) {
        return Price.builder()
                .id(price.getId())
                .instrumentName(price.getInstrumentName())
                .bid(adjustedBid)
                .ask(adjustedAsk)
                .timestamp(price.getTimestamp())
                .build();
    }
}
