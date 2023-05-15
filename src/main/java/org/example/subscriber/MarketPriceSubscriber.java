package org.example.subscriber;

import org.example.model.dto.PriceDto;
import org.example.service.MarginAdjusterService;
import org.example.service.PriceService;

public class MarketPriceSubscriber implements PriceSubscriber {
    private final MarginAdjusterService adjusterService;

    private final PriceService priceService;

    public MarketPriceSubscriber(MarginAdjusterService adjusterService, PriceService priceService) {
        this.adjusterService = adjusterService;
        this.priceService = priceService;
    }

    @Override
    public void onMessage(String message) {
        PriceDto priceDto = adjusterService.adjustPrice(message);
        priceService.save(priceDto);
    }
}
