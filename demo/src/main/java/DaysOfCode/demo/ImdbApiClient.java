package DaysOfCode.demo;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ImdbApiClient {
   private final String URLTOCALL;
    private String json;

    private int statusCode;

    ImdbApiClient(String url) {
        this.URLTOCALL = url;
    }


    public void connect() throws IOException, InterruptedException {
        //Criando a Url com base no link montado e fazendo a conexão.
        URI apiIMDB = URI.create(URLTOCALL);

        //criando conexão.
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder().uri(apiIMDB).build();

        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

         statusCode = response.statusCode();
         json = response.body();

    }

    public String getJsonBody() {
        return json;
    }

    public int getStatusCode() {
        return statusCode;

    }

}
