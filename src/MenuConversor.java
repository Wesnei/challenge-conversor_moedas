import java.util.Scanner;

    public class MenuConversor {
        private final Scanner scanner;
        private final ConversorMoeda conversor;

        public MenuConversor() {
            scanner = new Scanner(System.in);
            conversor = new ConversorMoeda();
        }

        public void exibirMenu() {
            int opcao;

            while (true) {
                System.out.println("*******************************************");
                System.out.println(" Seja bem-vindo(a) ao Conversor de Moeda =]");
                System.out.println("*******************************************");
                System.out.println("1) Dólar => Peso argentino");
                System.out.println("2) Peso argentino => Dólar");
                System.out.println("3) Dólar => Real brasileiro");
                System.out.println("4) Real brasileiro => Dólar");
                System.out.println("5) Dólar => Peso colombiano");
                System.out.println("6) Peso colombiano => Dólar");
                System.out.println("7) Sair");
                System.out.print("Escolha uma opção válida: ");

                opcao = scanner.nextInt();

                if (opcao == 7) {
                    System.out.println("Encerrando o programa...");
                    break;
                }

                if (opcao < 1 || opcao > 6) {
                    System.out.println("Opção inválida.");
                    continue;
                }

                String de = "", para = "";

                switch (opcao) {
                    case 1 -> { de = "USD"; para = "ARS"; }
                    case 2 -> { de = "ARS"; para = "USD"; }
                    case 3 -> { de = "USD"; para = "BRL"; }
                    case 4 -> { de = "BRL"; para = "USD"; }
                    case 5 -> { de = "USD"; para = "COP"; }
                    case 6 -> { de = "COP"; para = "USD"; }
                }

                // Loop para permitir várias conversões com a mesma moeda
                while (true) {
                    System.out.print("Digite o valor que deseja converter: ");
                    double valor = scanner.nextDouble();

                    try {
                        double resultado = conversor.converter(de, para, valor);
                        System.out.printf("Valor %.2f [%s] corresponde ao valor final de >>> %.6f [%s]\n\n",
                                valor, de, resultado, para);
                    } catch (Exception e) {
                        System.out.println("Erro ao converter moeda: " + e.getMessage());
                    }

                    // Submenu
                    System.out.println("O que deseja fazer?");
                    System.out.println("1) Converter outro valor (mesma moeda)");
                    System.out.println("2) Voltar ao menu principal");
                    System.out.println("3) Sair");
                    System.out.print("Escolha uma opção: ");
                    int subOpcao = scanner.nextInt();

                    if (subOpcao == 2) {
                        break; // Volta ao menu principal
                    } else if (subOpcao == 3) {
                        System.out.println("Encerrando o programa...");
                        scanner.close();
                        return; // Encerra o programa
                    } else if (subOpcao != 1) {
                        System.out.println("Opção inválida. Voltando ao menu principal...");
                        break;
                    }
                }
            }

            scanner.close();
        }

        public static void main(String[] args) {
            MenuConversor menu = new MenuConversor();
            menu.exibirMenu();
        }
    }
