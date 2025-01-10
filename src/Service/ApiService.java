package Service;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ApiService {
    private String apiKey;

    public ApiService(String apiKey) {
        this.apiKey = apiKey;
    }

    public String getResponse(String coinCode) throws IOException, InterruptedException {

        String url = "https://v6.exchangerate-api.com/v6/" + this.apiKey + "/latest/" + coinCode;
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(url))
                .build();

        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
        return response.body();
    }



}
