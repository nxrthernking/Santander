package org.example;

public class PriceController {

    private final PriceService service;

    public PriceController(PriceService service) {
        this.service = service;
    }

    public PriceDto getLastPrice() {
        return service.getLastPrice();
    }
}
