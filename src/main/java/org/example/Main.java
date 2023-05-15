package org.example;

public class Main {
    public static void main(String[] args) {
        PriceRepository repository = new PriceRepository();
        PriceParser priceParser = new PriceParser();
        PriceMapper priceMapper = new PriceMapper();
        MarginAdjusterService adjusterService = new MarginAdjusterService(repository, priceParser);
        PriceService priceService = new PriceService(repository, priceMapper);
        PriceController priceController = new PriceController(priceService);
        MarketPriceSubscriber priceSubscriber = new MarketPriceSubscriber(adjusterService);

        String message1 = "106, EUR/USD, 1.1000, 1.2000, 01-06-2020 12:01:01:001";
        String message2 = "107, EUR/JPY, 119.60, 119.90, 01-06-2020 12:01:02:002";
        String message3 = "108, GBP/USD, 1.2500, 1.2560, 01-06-2020 12:01:02:002";

        priceSubscriber.onMessage(message1);
        priceSubscriber.onMessage(message2);
        priceSubscriber.onMessage(message3);

        PriceDto lastPrice = priceController.getLastPrice();

        System.out.println(lastPrice);



    }
}