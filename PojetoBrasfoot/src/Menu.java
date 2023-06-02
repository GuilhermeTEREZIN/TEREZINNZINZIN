import java.util.Scanner;

public class Menu {
    public static void menu() {
        Scanner scanner = new Scanner(System.in);
        int opcao = 0;

        while (opcao != 3) {
            System.out.println("Menu:");
            System.out.println("1. Novo Jogo");
            System.out.println("2. Meu Ponto");
            System.out.println("3. Sair");
            System.out.print("Escolha uma opção: ");

            opcao = scanner.nextInt();

            switch (opcao) {
                case 1:
                    System.out.println("Opção selecionada: Novo Jogo");
                    // Coloque aqui o código para iniciar um novo jogo
                    break;
                case 2:
                    System.out.println("Opção selecionada: Meu Ponto");
                    // Coloque aqui o código para exibir informações sobre o seu ponto
                    break;
                case 3:
                    System.out.println("Opção selecionada: Sair");
                    break;
                default:
                    System.out.println("Opção inválida! Escolha uma opção válida.");
                    break;
            }

            System.out.println(); // Linha em branco para separar as iterações do menu
        }

        System.out.println("Programa encerrado.");
        scanner.close();
    }
}