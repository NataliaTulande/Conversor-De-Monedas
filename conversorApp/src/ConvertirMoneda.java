import java.util.Scanner;

public class ConvertirMoneda {
    public static void convertir (String monedaBase, String monedaTarget, ConsultaLaMoneda consulta ,Scanner lectura){
        double cantidad;
        double cantidadConvertida;


        Monedas monedas = consulta.buscarMoneda(monedaBase, monedaTarget);
        System.out.println("La tasa de conversion actualmente es:\n1" + monedaBase + "=" + monedas.conversion_rate()+ " " + monedaTarget);
        System.out.println("Ingresa la cantidad: " + monedaBase);
        cantidad = Double.parseDouble(lectura.nextLine());
        cantidadConvertida = cantidad * monedas.conversion_rate();
        System.out.println(cantidad + " " + monedaBase + " = " + cantidadConvertida + " " + monedas.target_code());
    }
    public static void convertirOtraMoneda(ConsultaLaMoneda consulta, Scanner lectura){
        System.out.println("Ingrese el codigo de la moneda base: ");
        String monedaBase = lectura.nextLine().toUpperCase();
        System.out.println("Ingrese la moneda que desea convertir: ");
        String monedaObjetivo = lectura.nextLine().toUpperCase();
        convertir(monedaBase, monedaObjetivo, consulta,lectura);
    }
}
