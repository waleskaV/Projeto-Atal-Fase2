public class ListaSequencial {
    private Livro[] livros;
    private int tamanho;

    // Construtor para inicializar a lista com uma capacidade máxima
    public ListaSequencial(int capacidade) {
        livros = new Livro[capacidade];
        tamanho = 0;
    }

    // Método para adicionar um livro à lista
    public boolean adicionar(Livro livro) {
        if (tamanho < livros.length) {
            livros[tamanho] = livro;
            tamanho++;
            return true;
        } else {
            System.out.println("Lista cheia, não é possível adicionar mais livros.");
            return false;
        }
    }

    // Método para listar todos os livros
    public void listar() {
        if (tamanho == 0) {
            System.out.println("A lista está vazia.");
        } else {
            for (int i = 0; i < tamanho; i++) {
                System.out.println(livros[i].toString());
            }
        }
    }

    // Método para buscar um livro pelo título
    public Livro buscar(String titulo) {
        for (int i = 0; i < tamanho; i++) {
            if (livros[i].getTitulo().equalsIgnoreCase(titulo)) {
                return livros[i];
            }
        }
        return null;
    }

    // Método para ordenar os livros pelo ano de publicação (usando Bubble Sort)
    public void ordenarPorAno() {
        for (int i = 0; i < tamanho - 1; i++) {
            for (int j = 0; j < tamanho - i - 1; j++) {
                if (livros[j].getAnoPublicacao() > livros[j + 1].getAnoPublicacao()) {
                    Livro temp = livros[j];
                    livros[j] = livros[j + 1];
                    livros[j + 1] = temp;
                }
            }
        }
    }
}
