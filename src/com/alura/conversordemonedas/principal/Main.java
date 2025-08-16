package com.alura.conversordemonedas.principal;

import com.google.gson.Gson;
import com.google.gson.JsonObject;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Scanner;


public class Main {
    public static void main(String[] args) {
        Scanner lectura =new Scanner(System.in);
        while(true){
            var monedaInicial="";
            var monedaCambio="";
            //switch menu de opciones
            System.out.println("Bienvenido/a al Conversor de Moneda");
            System.out.println("1) Dólar =>> Peso argentino");
            System.out.println("2) Peso argentino =>> Dólar");
            System.out.println("3) Dólar =>> Real Brasileño");
            System.out.println("4) Real Brasileño  =>> Dólar");
            System.out.println("5) Dólar =>> Peso colombiano");
            System.out.println("6) Peso colombiano =>> Dólar");
            System.out.println("7) Salir");
            System.out.println("Elija una opción válida");
            int option = lectura.nextInt();
            switch (option){
                case 1:
                    monedaInicial="USD";
                    monedaCambio="ARS";
                    break;
                case 2:
                    monedaInicial="ARS";
                    monedaCambio="USD";
                    break;
                case 3:
                    monedaInicial="USD";
                    monedaCambio="BRL";
                    break;
                case 4:
                    monedaInicial="BRL";
                    monedaCambio="USD";
                    break;
                case 5:
                    monedaInicial="USD";
                    monedaCambio="COP";
                    break;
                case 6:
                    monedaInicial="COP";
                    monedaCambio="USD";
                    break;
                case 7:

                    break;
            }
            //fin switch
            if(monedaInicial!=""&&monedaCambio!=""){
                System.out.println("Ingrese el valor que desea convertir: ");
                var cantidadACambiar = lectura.nextInt();

                var paginaExchange = "https://v6.exchangerate-api.com/v6/";
                var apiKey = "1ee3477afadea2a872f2a810";
                var pair = "/pair/"+monedaInicial+"/"+monedaCambio+"/"+cantidadACambiar;

                String direccion = paginaExchange+apiKey+pair;

                //http cliente

                HttpClient client = HttpClient.newHttpClient();

                HttpRequest request = HttpRequest.newBuilder()
                        .uri(URI.create(direccion))
                        .build();
                try {
                    HttpResponse<String> response = client
                            .send(request, HttpResponse.BodyHandlers.ofString());
                    String json = response.body();

                    Gson gson = new Gson();
                    JsonObject obj = gson.fromJson(json, JsonObject.class);

                    double resultado = obj.get("conversion_result").getAsDouble();

                    System.out.println("El valor "+cantidadACambiar+" ["+monedaInicial+"]"+
                            " corresponde al vlaor final de =>>> $"+resultado+" ["+monedaCambio+"]");
                }catch (Exception e){
                    System.out.println(e.getMessage());
                }
            }else {
                break;
            }
        }
        System.out.println("Finalizo el programa");


    }
}
