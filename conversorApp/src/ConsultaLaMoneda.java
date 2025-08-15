import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ConsultaLaMoneda {
    public Monedas buscarMoneda(String monedaBase, String monedaTarget) {
        URI direccion = URI.create("https://v6.exchangerate-api.com/v6/59c6af5cb2f0e61878ccc195/latest/" + monedaBase);

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(direccion)
                .build();

        try {
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

            JsonObject jsonObject = JsonParser.parseString(response.body()).getAsJsonObject();
            String baseCode = jsonObject.get("base_code").getAsString();
            double targetRate = jsonObject.getAsJsonObject("conversion_rates").get(monedaTarget).getAsDouble();

            return new Monedas(baseCode, monedaTarget, targetRate);
        } catch (Exception e) {
            throw new RuntimeException("No es posible procesarlo ya que no se encuentra la moneda");
        }
    }
}