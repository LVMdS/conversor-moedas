// ExchangeRates.java
import java.util.Map;

public class ExchangeRates {
    public String base; // Moeda base (ex.: "USD")
    public Map<String, Double> rates; // Map de moedas e suas respectivas taxas de câmbio

    @Override
    public String toString() {
        return "ExchangeRates{" +
                "base='" + base + '\'' +
                ", rates=" + rates +
                '}';
    }
}
