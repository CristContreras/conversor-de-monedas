package com.alura.conversordemonedas.principal;

public class test {
    public static void main(String[] args) {
        String key = System.getenv("EXCHANGE_API_KEY");
        if (key == null) {
            System.out.println("⚠️ No se encontró la variable de entorno.");
        } else {
            System.out.println("✅ Variable encontrada: " + key);
        }
    }
}
