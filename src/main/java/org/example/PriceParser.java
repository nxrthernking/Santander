package org.example;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.List;

public class PriceParser {

    private static final int ID = 0;
    private static final int INSTRUMENT_NAME = 1;
    private static final int BID = 2;
    private static final int ASK = 3;
    private static final int TIMESTAMP = 4;

    private static final String SPLITERATOR = ",";

    private final DateTimeFormatter format = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss:SSS");

    public Price parse(String message){
        String[] parts = message.split(SPLITERATOR);
        String id = parts[ID].trim();
        String instrumentName = parts[INSTRUMENT_NAME].trim();
        BigDecimal bid = new BigDecimal(parts[BID].trim());
        BigDecimal ask = new BigDecimal(parts[ASK].trim());
        String trim = parts[TIMESTAMP].trim();
        LocalDateTime timestamp = LocalDateTime.parse(parts[TIMESTAMP].trim(), format);
        return new Price(id, instrumentName, bid, ask, timestamp);
    }
}
