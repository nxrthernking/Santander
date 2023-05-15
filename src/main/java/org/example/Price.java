package org.example;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@AllArgsConstructor
@Builder
@ToString
@Getter
public class Price {
    private String id;
    private String instrumentName;
    private BigDecimal bid;
    private BigDecimal ask;
    private LocalDateTime timestamp;

}
