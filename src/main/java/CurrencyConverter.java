import com.google.gson.Gson;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Map;

public class CurrencyConverter {

    private static final String API_URL = "https://v6.exchangerate-api.com/v6/623da6a44845e41e3201fdc7/latest/USD";

    public static double getConversionRate(String from, String to) throws Exception {
        String apiUrl = API_URL + from;
        HttpURLConnection connection = (HttpURLConnection) new URL(apiUrl).openConnection();
        connection.setRequestMethod("GET");

        try (InputStreamReader reader = new InputStreamReader(connection.getInputStream())) {
            Gson gson = new Gson();
            ExchangeRates rates = gson.fromJson(reader, ExchangeRates.class);
            return rates.rates.get(to);
        }
    }
}

class ExchangeRates {
    String base;
    Map<String, Double> rates;
}