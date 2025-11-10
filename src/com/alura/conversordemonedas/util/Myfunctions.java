package com.alura.conversordemonedas.util;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Scanner;

import com.google.gson.Gson;
import com.google.gson.JsonObject;

public class Myfunctions {

    //mostrar menu
    public static void mostrarMenu(){
        System.out.println("Bienvenido/a al Conversor de Moneda");
        System.out.println("1) Dólar =>> Peso argentino");
        System.out.println("2) Peso argentino =>> Dólar");
        System.out.println("3) Dólar =>> Real Brasileño");
        System.out.println("4) Real Brasileño  =>> Dólar");
        System.out.println("5) Dólar =>> Peso colombiano");
        System.out.println("6) Peso colombiano =>> Dólar");
        System.out.println("7) Salir");
    }

    public static int solicitarEntero(String msj, Scanner lectura){
        boolean repetir = true;
        String entrada = "";
        int opcion=0;
        while(repetir){
            println(msj);
            entrada = lectura.nextLine();
            try {
                opcion = Integer.parseInt(entrada);
                repetir=false;
            } catch (NumberFormatException e) {
                println("Debe ingresar un número válido.\n");
            }
        }
        return opcion;
    }

  

    public static void println(String msj){
        System.out.println(msj);
    }

    public static String generarDireccion(String monedaInicial, String monedaCambio, int cantidadACambiar){
        
        String paginaExchange = "https://v6.exchangerate-api.com/v6/";
        //var apiKey = "1ee3477afadea2a872f2a810";
        var apiKey = System.getenv("EXCHANGE_API_KEY");

        var pair = "/pair/"+monedaInicial+"/"+monedaCambio+"/"+cantidadACambiar;

        return paginaExchange+apiKey+pair;
    }

    public static String consultarApi(String direccion, int cantidadACambiar, String monedaInicial, String monedaCambio){
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

                    return "El valor "+cantidadACambiar+" ["+monedaInicial+"]"+
                            " corresponde al vlaor final de =>>> $"+resultado+" ["+monedaCambio+"]";
                }catch (Exception e){
                    return e.getMessage();
                }
    }

    public static boolean realizarOtraConsulta(Scanner lectura){
        boolean repetir = true;
        boolean opcion=true;
        while(repetir){
            println("Desea hacer otra consulta?");
            String respuesta = lectura.next();
            lectura.nextLine();
            if (respuesta.equals("si")){
                repetir=false;
                opcion=true;
            }else if (respuesta.equals("no")){
                repetir=false;
                opcion=false;
            }else{
                println("Ingreso una respuesta incorrecta");
            }
        }
        return opcion;
    }
}
