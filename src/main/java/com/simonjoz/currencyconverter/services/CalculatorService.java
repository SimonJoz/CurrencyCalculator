package com.simonjoz.currencyconverter.services;

import com.simonjoz.currencyconverter.model.CurrencyAttributes;
import com.simonjoz.currencyconverter.provider.RateProvider;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Slf4j
@Service
@RequiredArgsConstructor
public class CalculatorService {

    private final RateProvider provider;

    public void convertCurrencies(CurrencyAttributes attributes) {
        log.info("Calculate result ");
        BigDecimal rate = provider.getRate(attributes.getFrom(), attributes.getTo());
        BigDecimal result = attributes.getAmount().multiply(rate);
        attributes.setResult(result);
    }


}
