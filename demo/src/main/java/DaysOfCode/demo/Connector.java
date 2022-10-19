package DaysOfCode.demo;

import java.io.IOException;

public interface Connector {
    void connect() throws IOException, InterruptedException;

    String getJsonBody();

    int getStatusCode();
}
