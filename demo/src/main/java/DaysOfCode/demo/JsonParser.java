package DaysOfCode.demo;

import java.util.List;

public interface JsonParser {

     List<? extends Content> getFilmeList();
     void parseJson(String x);
}
