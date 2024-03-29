package DaysOfCode.demo;

import java.io.*;
import java.lang.String;
import java.util.Collections;
import java.util.Comparator;


public class App {
    public static void main(String[] args) throws IOException {

        String apiLink = "https://imdb-api.com/en/API/Top250TVs/";
        final int SUCESSCODE = 200;

        final String TOKEN = "your key"; //"/"
        String urlToCall = apiLink + TOKEN;

        FileWriter writer = new FileWriter("filme.html");
        HTMLGenerator htmlGenerator = new HTMLGenerator(writer);
        ImdbApiClient apiClient = new ImdbApiClient(urlToCall);
        ImdbJsonParser imdbJsonParser = new ImdbJsonParser();
        MarvelApiClient marvelApi = new MarvelApiClient();

        try {
            apiClient.connect();
            imdbJsonParser.parseJson(apiClient.getJsonBody());

            

                if(apiClient.getStatusCode() != SUCESSCODE){
                  throw new RuntimeException("HTTP ERROR CODE: " + apiClient.getStatusCode());
                }

             System.out.println("Connection Imdb APi Successful!");

            Collections.sort(imdbJsonParser.getFilmeList(), Comparator.comparing(Filme::getRating));

                 //gera o arquivo .html com os dados do filme + o codigo html e css.
                htmlGenerator.generate(imdbJsonParser.getFilmeList()); // o inteiro passado é para selecionar o filme desejado dentre os 250.
                writer.flush();
                //abre automaticamente o arquivo gerado.
                java.awt.Desktop.getDesktop().open(new File("C:\\estudos\\7DaysOfCode\\demo\\filme.html"));

    }catch(Exception e) {
        e.printStackTrace();
    }


    }


}


