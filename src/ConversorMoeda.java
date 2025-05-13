import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import org.json.JSONObject;

public class ConversorMoeda {
    private static final String ACCESS_KEY = "6a01040e0d7e07b0b2f1bbc7";

    public double converter(String de, String para, double valor) throws Exception {
        if (de == null || para == null || de.isEmpty() || para.isEmpty()) {
            throw new IllegalArgumentException("Códigos de moeda não podem ser nulos ou vazios.");
        }

        String uri = String.format("https://v6.exchangerate-api.com/v6/%s/latest/%s", ACCESS_KEY, de);

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder().uri(new URI(uri)).build();
        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

        JSONObject json = new JSONObject(response.body());

        if (!json.getString("result").equals("success")) {
            String errorMessage = json.has("error-type") ? json.getString("error-type") : "Erro desconhecido na API.";
            System.out.println("Resposta da API: " + json.toString(2));
            throw new RuntimeException("Erro ao converter moeda: " + errorMessage);
        }

        JSONObject conversionRates = json.getJSONObject("conversion_rates");

        if (!conversionRates.has(para)) {
            System.out.println("Resposta da API: " + json.toString(2));
            throw new RuntimeException("Moeda de destino '" + para + "' não encontrada.");
        }

        double taxa = conversionRates.getDouble(para);
        return valor * taxa;
    }

    // Método main para teste
    public static void main(String[] args) {
        ConversorMoeda conversor = new ConversorMoeda();
        try {
            double resultado = conversor.converter("USD", "BRL", 100.0);
            System.out.println("Resultado: " + resultado);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}