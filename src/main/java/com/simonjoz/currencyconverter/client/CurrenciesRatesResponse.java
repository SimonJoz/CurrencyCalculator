package com.simonjoz.currencyconverter.client;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.math.BigDecimal;

@Data
public class CurrenciesRatesResponse {

    @JsonProperty("Realtime Currency Exchange Rate")
    private RealtimeCurrencyExchangeRate currencyExchangeRate;

    @Data
    public static class RealtimeCurrencyExchangeRate {
        @JsonProperty("5. Exchange Rate")
        private BigDecimal rate;
    }
}

