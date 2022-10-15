package DaysOfCodeDay2.demo;


import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.lang.String;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class App {
    public static void main(String[] args) {

        String apiLink = "https://imdb-api.com/en/API/Top250TVs/";
        int successCode = 200;
        int maxSize = 250;
        String token = "k_e3cl21m0/";
        String urlToCall = apiLink + token;
        List<String> filmes = new ArrayList<>();
        List<String> filmesTitulo = new ArrayList<>();
        List<String> filmesImageUrl = new ArrayList<>();
        List<String> filmesAno = new ArrayList<>();
        List<String> filmesRating = new ArrayList<>();
        List<Filme> filmeUnico = new ArrayList<>();
        

        try {

        //Criando a Url com base no link montado e fazendo a conexão
        URI apiIMDB = URI.create(urlToCall);
		
        //criando conexão
		HttpClient client = HttpClient.newHttpClient();
		HttpRequest request = HttpRequest.newBuilder().uri(apiIMDB).build();

		HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

        //Se o codigo não for 200, joga um erro
        if(response.statusCode() != successCode){
            throw new RuntimeException("HTTP ERROR CODE: " + response.statusCode());
        }

        System.out.println("Connection Successful\n");

		String json = response.body();

        //bloco de codigo que pega apenas o que está dentro de {} no json completo
        Pattern p = Pattern.compile("\\{([^}]+?)}");
        Matcher matcher = p.matcher(json);
        while(matcher.find()) {
            filmes.add(matcher.group());
        }

            //splita o json que foi separado acima
        String [] atributos = filmes.toString().split(",");


    //for encadeado que pega o titulo e url da imagem e coloca em uma lista
    for(String x : atributos) {
        if(x.contains("title")) {
            filmesTitulo.add(x);
        }else if(x.contains("image")) {
            filmesImageUrl.add(x);
      }else if(x.contains("imDbRating")) {
            filmesRating.add(x);
        }else if(x.contains("year")) {
            filmesAno.add(x);
        }
    }

            for(int i = 0; i < maxSize; i++) {
                filmeUnico.add(new Filme(filmesTitulo.get(i), filmesImageUrl.get(i), filmesRating.get(i), filmesAno.get(i)));

            }


            System.out.println(filmeUnico.get(8).getAll());





    }catch(Exception e) {
        e.printStackTrace();
    }


    }
}