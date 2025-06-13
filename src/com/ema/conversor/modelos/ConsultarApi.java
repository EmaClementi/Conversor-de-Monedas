package com.ema.conversor.modelos;

import com.google.gson.Gson;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.List;

public class ConsultarApi {

    List<Conversion> conversiones = new ArrayList<>();

    public void convertir(String monedaInicial, String monedaConvertir, int cantidad){
        HttpClient cliente = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("https://v6.exchangerate-api.com/v6/2614ec2a990720c6cdb4e249/pair/"+monedaInicial+"/"+monedaConvertir+"/"+cantidad))
                .build();

        try{
            HttpResponse<String> response = cliente.send(request, HttpResponse.BodyHandlers.ofString());
            String json = response.body();

            Gson gson = new Gson();
            ConversionApi conversionApi = gson.fromJson(json, ConversionApi.class);
            Conversion conversion = new Conversion(conversionApi,cantidad);
            conversiones.add(conversion);
            conversion.getConversion();

        }catch (IOException | InterruptedException e ) {
            throw new RuntimeException("Error al conectar con la API" + e.getMessage());

        }
    }
    public List<Conversion> getConversiones() {
        return conversiones;
    }


}
