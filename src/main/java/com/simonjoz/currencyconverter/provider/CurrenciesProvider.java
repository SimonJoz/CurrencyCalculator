package com.simonjoz.currencyconverter.provider;

import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.HashMap;
import java.util.Map;

@Slf4j
@Service
@Getter
public class CurrenciesProvider {
    @Value("${spring.application.currenciesPath}")
    private  String currenciesPath;

    private Map<String, String> currencies = new HashMap<>();


    @PostConstruct
    private void fetchCurrencies() {
        log.info("Loading currencies");
        try {
            Files.newBufferedReader(Path.of(currenciesPath))
                    .lines().forEach(line -> {
                String[] split = line.split(",");
                currencies.put(split[0],split[1]);
            });
        } catch (IOException e) {
            log.error("Currencies file not found !");
        } catch (ArrayIndexOutOfBoundsException ex){
            log.error("Parsing currencies file failed.");
        }
    }

}
