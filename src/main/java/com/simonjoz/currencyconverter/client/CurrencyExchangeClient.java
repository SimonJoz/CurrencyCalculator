package com.simonjoz.currencyconverter.client;

import lombok.Data;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

@Slf4j
@RequiredArgsConstructor
@Service
public class CurrencyExchangeClient {
    @Value("${spring.currenciesRateApi.apiURL}")
    private String apiURL;
    @Value("${spring.currenciesRateApi.key}")
    private String key;

    private final RestTemplate restTemplate;


    public CurrenciesRatesResponse getRate(String currencyFrom, String currencyTo) {
        String url = apiURL;
        Map<String, Object> parameters = new HashMap<>();
        parameters.put("currencyFrom", currencyFrom);
        parameters.put("currencyTo", currencyTo);
        parameters.put("key", key);
        log.info("Getting API response.");
        var response = restTemplate.getForObject(url, CurrenciesRatesResponse.class, parameters);
        log.debug("Response {}", response);
        return response;
    }
}
