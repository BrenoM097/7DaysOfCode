package DaysOfCode.demo;

import java.io.IOException;
import java.math.BigInteger;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class MarvelApiClient implements Connector {
    private final String PRIVATEKEY = "013d0f328a968967e3600c8a81aed2f3b83acad0";
    private final String PUBLICKEY = "2cae79b4405dee7324187971dbf75c9f";
    private String json;
    private int statusCode;
    String timestamp = String.valueOf(System.currentTimeMillis());
    private final String HASH = timestamp + PRIVATEKEY + PUBLICKEY;
    private final String URLTOCALL = String.format("http://gateway.marvel.com/v1/public/comics?ts=%s&apikey=%s&hash=%s", timestamp, PUBLICKEY, getHashMd5(HASH));

    @Override
   public void connect() throws IOException, InterruptedException {
        //Criando a Url com base no link montado.
        URI apiIMarvel = URI.create(this.URLTOCALL);

        //criando conexão.
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder().uri(apiIMarvel).build();

        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

        statusCode = response.statusCode();
        json = response.body();


    }
    public  String getHashMd5(String value) {
        MessageDigest md;
        try {
            md = MessageDigest.getInstance("MD5");
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
        BigInteger hash1 = new BigInteger(1, md.digest(value.getBytes()));
        return hash1.toString(16);
    }

    @Override
    public String getJsonBody() { return json; }
    @Override
    public int getStatusCode() { return statusCode; }

    public String getURLTOCALL() { return URLTOCALL; }

}
