import java.util.Scanner;

public class ConversorDeMoedas {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean continuar = true;

        while (continuar) {

            System.out.println("Escolha uma opção para Conversão de Valores:");
            System.out.println("1. Dólar para Euro");
            System.out.println("2. Euro para Dolar");
            System.out.println("3. Real para Dólar");
            System.out.println("4. Dolar para Real");
            System.out.println("5. Real para Peso Argentino");
            System.out.println("6. Peso Argentino para Real");
            System.out.println("7. Sair");

            int opcao = scanner.nextInt();

            if (opcao == 7) {
                continuar = false;
                System.out.println("Operação encerrada.");
                break;
            } else {

                String moeda1 = "";
                String moeda2 = "";

                switch (opcao) {
                    case 1:
                        moeda1 = "USD";
                        moeda2 = "EUR";
                        break;
                    case 2:
                        moeda1 = "EUR";
                        moeda2 = "USD";
                        break;
                    case 3:
                        moeda1 = "BRL";
                        moeda2 = "USD";
                        break;
                    case 4:
                        moeda1 = "USD";
                        moeda2 = "BRL";
                        break;
                    case 5:
                        moeda1 = "BRL";
                        moeda2 = "ARS";
                        break;
                    case 6:
                        moeda1 = "ARS";
                        moeda2 = "BRL";
                        break;
                    default:
                        System.out.println("Opção inválida. Tente novamente.");
                        continue; // Volta ao início do loop
                }

                System.out.println("Insira um valor:");
                double valor = scanner.nextDouble();

                //Chmando o método
                ConversorAPI.converterMoeda(moeda1, moeda2, valor); // Realizando a conversão
            }


        }
        scanner.close();
    }
}










