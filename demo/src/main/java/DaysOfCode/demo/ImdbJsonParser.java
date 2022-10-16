package DaysOfCode.demo;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ImdbJsonParser {
    private final List<String> filmes = new ArrayList<>();
    private final List<String> filmesTitulo = new ArrayList<>();
    private final List<String> filmesImageUrl = new ArrayList<>();
    private final List<String> filmesAno = new ArrayList<>();
    private final List<String> filmesRating = new ArrayList<>();

    private final List<Filme> filmeUnico = new ArrayList<>();



    public void parseJson(String json) {
         final int MAXSIZE = 250;

        //bloco de codigo que pega apenas o que está dentro de {} do json completo.
        Pattern p = Pattern.compile("\\{([^}]+?)}");
        Matcher matcher = p.matcher(json);
        while (matcher.find()) {
            filmes.add(matcher.group());
        }

        String [] atributos = filmes.toString().split(",");

        //for encadeado que pega os atributos e coloca em uma lista separada para cada um.
        for(String x : atributos) {
            if(x.contains("title")) {
                filmesTitulo.add(x.substring(9, x.length() - 1));

            }else if(x.contains("image")) {
                filmesImageUrl.add(x.substring(9, x.length() - 1));

            }else if(x.contains("imDbRating")) {
                filmesRating.add(x.substring(14, x.length() - 1));

            }else if(x.contains("year")) {
                filmesAno.add(x.substring(8, x.length() - 1));

            }
        }

        //junta as listas separadas criando um objeto Filme para cada grupo de atributos.
        for(int i = 0; i < MAXSIZE; i++) {
            filmeUnico.add(new Filme(filmesTitulo.get(i), filmesImageUrl.get(i), filmesRating.get(i), filmesAno.get(i)));

        }
    }

    public List<Filme> getFilmeList() {
        return filmeUnico;
    }

}
