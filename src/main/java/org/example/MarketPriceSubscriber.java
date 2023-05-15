package org.example;

public class MarketPriceSubscriber implements PriceSubscriber{
    private final MarginAdjusterService adjusterService;

    public MarketPriceSubscriber(MarginAdjusterService adjusterService) {
        this.adjusterService = adjusterService;
    }

    @Override
    public void onMessage(String message) {
        adjusterService.adjustPrice(message);
    }
}
