package com.simonjoz.currencyconverter.controller;


import com.simonjoz.currencyconverter.model.CurrencyAttributes;
import com.simonjoz.currencyconverter.provider.CurrenciesProvider;
import com.simonjoz.currencyconverter.services.CalculatorService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;
import java.util.Map;

@Controller
@RequiredArgsConstructor
@RequestMapping("/")
public class ConvertController {

    private final CurrenciesProvider currenciesProvider;
    private final CalculatorService calculatorService;

    @ModelAttribute("currencies")
    public Map<String, String> addCurrencies() {
        return currenciesProvider.getCurrencies();
    }

    @ModelAttribute("attributes")
    public CurrencyAttributes getAttribute() {
        return new CurrencyAttributes();
    }

    @GetMapping
    public String getIndex() {
        return "converter";
    }

    @PostMapping
    public String postResult(@Valid @ModelAttribute("attributes") CurrencyAttributes attributes, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "converter";
        }
        calculatorService.convertCurrencies(attributes);
        return "converter";
    }



}
