package DaysOfCode.demo;

import java.io.IOException;
import java.io.Writer;
import java.util.List;



public class HTMLGenerator {
    Writer writer;

    HTMLGenerator(Writer write) {
        this.writer = write;
    }
    String divTemplate =
            """    
                         <head>
                         <style type="text/css">
                         .container {
                                         width: 100vw;
                                         height: 100vh;
                                         background: #6C7A89;
                                         display: flex;
                                         flex-direction: row;
                                         justify-content: center;
                                         align-items: center
                                     }
                                     .box {
                                         width: 300px;
                                         height: 300px;
                                         
                                     }
                         </style>
                        <meta charset="utf-8">
                        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
                        <link rel="stylesheet"href="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css"
                            + "integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">				
                    </head>
                           
                    <div class="container">
                    <div class="box">
                            <div class="card text-white bg-dark mb-3" style="max-width: 18rem;">
                                <h4 class="card-header">%s</h4>
                                <div class="card-body">
                                    <img class="card-img" src="%s" alt="%s">
                                    <p class="card-text mt-2">Nota: %s - Ano: %s</p>
                                 </div>
                               </div>
                             </div>
                            </div>
                            """;

    public void generate(List<Filme> filme) throws IOException {

    for(int i = 0; i < 249; i++)
         writer.write(String.format(divTemplate, filme.get(i).getTitle(), filme.get(i).getImage(), filme.get(i).getTitle(), filme.get(i).getRating(), filme.get(i).getYear()));
    }

}
