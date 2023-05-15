package org.example;

import java.util.ArrayList;
import java.util.List;

public class PriceRepository implements Repository<Price> {


    List<Price> data = new ArrayList<>();

    @Override
    public void save(Price entity) {
        data.add(entity);
    }

    @Override
    public List<Price> findAll() {
       return data;
    }

    public Price getLastPrice() {
        return data.get(data.size() - 1);
    }
}
