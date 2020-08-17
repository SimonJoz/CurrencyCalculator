package com.simonjoz.currencyconverter.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;


@Getter
@Setter
@NoArgsConstructor
public class CurrencyAttributes {
    @NotBlank
    private String from;
    @NotBlank
    private String to;
    @NotNull
    private BigDecimal amount;
    private BigDecimal result;
}
