import java.util.Scanner;

public class Principal {
    public static void main(String[] args) {
        Scanner lectura = new Scanner(System.in);
        ConsultaLaMoneda consulta = new ConsultaLaMoneda();

        int opcion = 0;
        while (opcion != 6){
            System.out.println("------------------------------------------------------\n" +
                    "Bienvenid@ al conversor de monedas \n\n" +
                    "Ingresa el numero de la conversion que deseas realizar \n\n" +
                    "1. Dolar a Peso Argentino\n" +
                    "2. Dolar a Real Brasilero\n" +
                    "3. Dolar a Peso Colombiano\n" +
                    "4. Peso Colombiano a Peso Argentino\n" +
                    "5. Convertir a otra moneda\n" +
                    "6. Salir.\n" +
                    "------------------------------------------------------\n");
            opcion = lectura.nextInt();
            lectura.nextLine();

            switch (opcion){
                case 1:
                    ConvertirMoneda.convertir("USD", "ARS", consulta, lectura);
                    break;
                case 2:
                    ConvertirMoneda.convertir("USD", "BRL", consulta,lectura);
                    break;
                case 3:
                    ConvertirMoneda.convertir("USD", "COP", consulta,lectura);
                    break;
                case 4:
                    ConvertirMoneda.convertir("COP", "ARS", consulta,lectura);
                    break;
                case 5:
                    ConvertirMoneda.convertirOtraMoneda(consulta,lectura);
                    break;
                case 6:
                    System.out.println("Gracias por utilizar el conversor, saliendo....");
                    break;

                default:
                    System.out.println("Opcion no válida");
                    break;
            }
        }

    }
}
