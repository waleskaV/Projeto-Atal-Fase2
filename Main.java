import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ArvoreBinaria arvoreLivros = new ArvoreBinaria(); // Inicializa a árvore binária
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("-------------------------------------------------");
            System.out.println("** MENU BIBLIOTECA DIGITAL **");
            System.out.println("1 - Adicionar livro");
            System.out.println("2 - Listar livros (em ordem alfabética)");
            System.out.println("3 - Buscar livro por título");
            System.out.println("4 - Listar livros de um autor");
            System.out.println("5 - Listar livros por ano de publicação");
            System.out.println("6 - Sair");
            System.out.print("Escolha uma opção: ");

            int opcao = scanner.nextInt();
            scanner.nextLine(); // Consumir a nova linha

            switch (opcao) {
                case 1:
                    System.out.println("Digite o título do livro: ");
                    String titulo = scanner.nextLine();
                    System.out.println("Digite o autor do livro: ");
                    String autor = scanner.nextLine();
                    System.out.println("Digite o ano de publicação do livro: ");
                    int ano = scanner.nextInt();

                    Livro novoLivro = new Livro(titulo, autor, ano);
                    arvoreLivros.inserir(novoLivro);
                    System.out.println("Livro adicionado com sucesso.");
                    break;

                case 2:
                    System.out.println("Lista de livros (em ordem alfabética):");
                    arvoreLivros.exibirEmOrdem();
                    break;

                case 3:
                    System.out.println("Digite o título do livro que deseja buscar: ");
                    String tituloBusca = scanner.nextLine();
                    Livro livroEncontrado = arvoreLivros.buscar(tituloBusca);
                    System.out.println(livroEncontrado != null ? livroEncontrado : "Livro não encontrado.");
                    break;

                case 4:
                    System.out.println("Digite o nome do autor: ");
                    String autorBusca = scanner.nextLine();
                    arvoreLivros.listarPorAutor(autorBusca);
                    break;

                case 5:
                    System.out.println("Digite o ano de publicação: ");
                    int anoBusca = scanner.nextInt();
                    arvoreLivros.listarPorAno(anoBusca);
                    break;

                case 6:
                    System.out.println("Obrigada por utilizar a Biblioteca Digital, Até logo!");
                    scanner.close();
                    return;

                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
            System.out.println(); // Linha em branco para organização do menu
        }
    }
}
