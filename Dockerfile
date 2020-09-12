FROM openjdk:11
ADD target/currencyconverter-1.0.1.jar .
ADD forex_currency_list.csv .
EXPOSE 8000
CMD java -jar currencyconverter-1.0.1.jar