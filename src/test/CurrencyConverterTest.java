package test;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import com.google.gson.Gson;

public class CurrencyConverterTest {

    @Test
    public void testJsonParsing() {
        String jsonResponse = """
            {
                "base": "USD",
                "rates": {
                    "BRL": 5.23,
                    "EUR": 0.85
                }
            }
        """;

        Gson gson = new Gson();
        ExchangeRates rates = gson.fromJson(jsonResponse, ExchangeRates.class);

        assertEquals("USD", rates.base);
        assertEquals(5.23, rates.rates.get("BRL"));
    }

    @Test
    public void testCurrencyConversion() {
        double amount = 100.0;
        double rate = 5.23;
        double converted = amount * rate;

        assertEquals(523.0, converted, 0.01);
    }
}