package org.example.controller;

import org.example.model.dto.PriceDto;
import org.example.service.PriceService;

public class PriceController {

    private final PriceService service;

    public PriceController(PriceService service) {
        this.service = service;
    }

    public PriceDto getLastPrice() {
        return service.getLastPrice();
    }
}
