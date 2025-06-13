import com.ema.conversor.modelos.ConsultarApi;
import com.ema.conversor.modelos.Conversion;
import com.google.gson.Gson;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.List;
import java.util.Scanner;

public class Principal {
    public static void main(String[] args)  {

        Scanner teclado = new Scanner(System.in);

        int opcion = 0;
        var monedaInicial = "";
        var monedaConvertir = "";
        var cantidad = 0;

        ConsultarApi consulta = new ConsultarApi();

        while(opcion != 7){
            System.out.println("""
                ********************************************
                Sea bienvenido/a al Conversor de Moneda =]
                1) Dolar =>> Peso argentino
                2) Peso argentino =>> Dolar
                3) Dolar =>> Real brasileño
                4) Real brasileño =>> Dolar
                5) Dolar =>> Peso colombiano
                6) Peso colombiano =>> Dolar
                7) Historial de Conversiones
                8= Salir
                Elija una opcion valida: 
                ********************************************
                """);

            opcion = teclado.nextInt();

            switch (opcion){
                case 1:
                    monedaInicial = "USD";
                    monedaConvertir = "ARS";

                    System.out.println("Ingrese el valor que deseas convertir: ");
                    cantidad = teclado.nextInt();
                    consulta.convertir(monedaInicial,monedaConvertir,cantidad);
                    break;
                case 2:
                    monedaInicial = "ARS";
                    monedaConvertir = "USD";

                    System.out.println("Ingrese el valor que deseas convertir: ");
                    cantidad = teclado.nextInt();
                    consulta.convertir(monedaInicial,monedaConvertir,cantidad);
                    break;
                case 3:
                    monedaInicial = "USD";
                    monedaConvertir = "BRL";

                    System.out.println("Ingrese el valor que deseas convertir: ");
                    cantidad = teclado.nextInt();
                    consulta.convertir(monedaInicial,monedaConvertir,cantidad);
                    break;
                case 4:
                    monedaInicial = "BRL";
                    monedaConvertir = "USD";

                    System.out.println("Ingrese el valor que deseas convertir: ");
                    cantidad = teclado.nextInt();
                    consulta.convertir(monedaInicial,monedaConvertir,cantidad);
                    break;
                case 5:
                    monedaInicial = "USD";
                    monedaConvertir = "COP";

                    System.out.println("Ingrese el valor que deseas convertir: ");
                    cantidad = teclado.nextInt();
                    consulta.convertir(monedaInicial,monedaConvertir,cantidad);
                    break;
                case 6:
                    monedaInicial = "COP";
                    monedaConvertir = "USD";

                    System.out.println("Ingrese el valor que deseas convertir: ");
                    cantidad = teclado.nextInt();
                    consulta.convertir(monedaInicial,monedaConvertir,cantidad);
                    break;
                case 7:
                    List<Conversion> lista = consulta.getConversiones();
                    for (Conversion c : lista){
                        c.getConversion();
                    }

                    break;
                case 8:
                    System.out.println("Cerrando sesion.......");
                    break;
                default:
                    System.out.println("Opcion no valida");
                    break;
            }
        }







    }
}
