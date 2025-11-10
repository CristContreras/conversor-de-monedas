package com.alura.conversordemonedas.principal;
import java.util.Scanner;
import static com.alura.conversordemonedas.util.Myfunctions.*;

public class Main {
    public static void main(String[] args) {
        Scanner lectura = new Scanner(System.in);
        boolean repetir = true;
        while(repetir){
            String monedaInicial=null;
            String monedaCambio=null;
            mostrarMenu();
            System.out.print("Elija una opción válida: ");
            String option = lectura.next();
            lectura.nextLine();
            switch (option){
                case "1":
                    monedaInicial="USD";
                    monedaCambio="ARS";
                    break;
                case "2":
                    monedaInicial="ARS";
                    monedaCambio="USD";
                    break;
                case "3":
                    monedaInicial="USD";
                    monedaCambio="BRL";
                    break;
                case "4":
                    monedaInicial="BRL";
                    monedaCambio="USD";
                    break;
                case "5":
                    monedaInicial="USD";
                    monedaCambio="COP";
                    break;
                case "6":
                    monedaInicial="COP";
                    monedaCambio="USD";
                    break;
                case "7":
                    repetir=false;
                    break;
                default:
                    println("Opción no válida, intente nuevamente");
            }
            boolean sonMonedasValidas=(monedaInicial!=null&&monedaCambio!=null);
            if(sonMonedasValidas){
                int cantidadACambiar = solicitarEntero("Ingrese el valor que desea convertir: ", lectura);
                String direccion = generarDireccion(monedaInicial, monedaCambio, cantidadACambiar);
                println(consultarApi(direccion, cantidadACambiar, monedaInicial, monedaCambio));
            }

            if (repetir){
                repetir=realizarOtraConsulta(lectura);
            }
        }
        System.out.println("Finalizo el programa");

    }
}
