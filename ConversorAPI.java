import com.google.gson.Gson;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class ConversorAPI {

    private static final String ApiKey = "SUA_CHAVE_API";

    public static void converterMoeda(String moeda1, String moeda2, double valor) {

        try {
            try {
                // Enderaço da API
                String url_str = "https://v6.exchangerate-api.com/v6/" + ApiKey + "/pair/" + moeda1 + "/" + moeda2;
                URL url = new URL(url_str);
                HttpURLConnection request = (HttpURLConnection) url.openConnection();
                request.setRequestMethod("GET");
                request.connect();

                // Lendo a resposta da API
                BufferedReader br = new BufferedReader(new InputStreamReader(request.getInputStream()));
                StringBuilder sb = new StringBuilder();
                String line;
                while ((line = br.readLine()) != null) {
                    sb.append(line);
                }

                // Convertendo o JSON para um Objeto
                Gson gson = new Gson();
                RespostaAPI resposta = gson.fromJson(sb.toString(), RespostaAPI.class);

                // Pegando a taxa de conversão
                double taxaDeConversao = resposta.getConversionRate();


                    //Calculando a conversão das moedas
                    double valorConvertido = valor * taxaDeConversao;
                    System.out.println("Taxa de Conversão: " + taxaDeConversao);
                    System.out.println("Valor convertido: " + valorConvertido);
                    //System.out.println(taxaDeConversao);
                    //System.out.println(valor);

            } catch (Exception e) {
                System.out.println("Erro ao realizar a conversão: " + e.getMessage());
            }
        } finally {

        }
    }
}
