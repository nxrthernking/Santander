package org.example;

import org.example.controller.PriceController;
import org.example.mapper.PriceMapper;
import org.example.model.dto.PriceDto;
import org.example.parser.PriceParser;
import org.example.repository.PriceRepository;
import org.example.service.MarginAdjusterService;
import org.example.service.PriceService;
import org.example.subscriber.MarketPriceSubscriber;

public class Main {
    public static void main(String[] args) {
        PriceRepository repository = new PriceRepository();
        PriceParser priceParser = new PriceParser();
        PriceMapper priceMapper = new PriceMapper();
        MarginAdjusterService adjusterService = new MarginAdjusterService(priceParser);
        PriceService priceService = new PriceService(repository, priceMapper);
        PriceController priceController = new PriceController(priceService);
        MarketPriceSubscriber priceSubscriber = new MarketPriceSubscriber(adjusterService, priceService);

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