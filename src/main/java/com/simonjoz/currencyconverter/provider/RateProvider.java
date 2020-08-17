package com.simonjoz.currencyconverter.provider;

import com.simonjoz.currencyconverter.client.CurrenciesRatesResponse;
import com.simonjoz.currencyconverter.client.CurrencyExchangeClient;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.beans.BeanInfo;
import java.math.BigDecimal;

@Slf4j
@Service
@RequiredArgsConstructor
public class RateProvider {
    private final CurrencyExchangeClient client;

    public BigDecimal getRate(String currencyFrom, String currencyTo) {
        CurrenciesRatesResponse rate = client.getRate(currencyFrom, currencyTo);
        BigDecimal response;
        log.info("Validating response");
        try {
            response = rate.getCurrencyExchangeRate().getRate();
        } catch (NullPointerException e) {
            log.warn("Api call limit exceeded.");
            return BigDecimal.ZERO;
        }
        return response;
    }
}
