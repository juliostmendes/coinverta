package Service;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class ApiService {
    private String apiKey;

    public ApiService(String apiKey) {
        this.apiKey = apiKey;
    }

    public double getConversion(String coinToConvertCode, String currentConversionCode) throws IOException, InterruptedException {

        String url_str = "https://v6.exchangerate-api.com/v6/" + this.apiKey + "/latest/" + coinToConvertCode;
        URL url = new URL(url_str);
        HttpURLConnection request = (HttpURLConnection) url.openConnection();
        request.connect();

        JsonParser jp = new JsonParser();
        JsonElement root = jp.parse(new InputStreamReader((InputStream) request.getContent()));
        JsonObject jsonObject = root.getAsJsonObject();

        String reqResult = jsonObject.get("conversion_rates").getAsJsonObject().get(currentConversionCode).getAsString();

        return Double.parseDouble(reqResult);
    }

    public String getResponse(String coinToConvertCode, String currentConversionCode, double value) throws IOException, InterruptedException {
        double finalValue = getConversion(coinToConvertCode, currentConversionCode) * value;
        return String.format("The value of %f [%s] corresponds to ==> %f [%s]", value, coinToConvertCode, finalValue, currentConversionCode);
    }

}
