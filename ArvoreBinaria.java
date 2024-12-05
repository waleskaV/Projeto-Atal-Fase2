public class ArvoreBinaria {
    private Nodo raiz;

    // Classe interna Nodo representando os nós da árvore
    private static class Nodo {
        Livro livro;
        Nodo esquerdo;
        Nodo direito;

        Nodo(Livro livro) {
            this.livro = livro;
        }
    }

    // Método para inserir um livro na árvore
    public void inserir(Livro livro) {
        raiz = inserirRecursivo(raiz, livro);
    }

    private Nodo inserirRecursivo(Nodo atual, Livro livro) {
        if (atual == null) {
            return new Nodo(livro); // Cria um novo nodo
        }

        // Ordenação por título (critério principal)
        if (livro.getTitulo().compareToIgnoreCase(atual.livro.getTitulo()) < 0) {
            atual.esquerdo = inserirRecursivo(atual.esquerdo, livro); // Vai para a subárvore esquerda
        } else if (livro.getTitulo().compareToIgnoreCase(atual.livro.getTitulo()) > 0) {
            atual.direito = inserirRecursivo(atual.direito, livro); // Vai para a subárvore direita
        }
        return atual; // Retorna o nodo atual
    }

    // Método para buscar um livro por título
    public Livro buscar(String titulo) {
        return buscarRecursivo(raiz, titulo);
    }

    private Livro buscarRecursivo(Nodo atual, String titulo) {
        if (atual == null) {
            return null; // Não encontrado
        }
        if (titulo.equalsIgnoreCase(atual.livro.getTitulo())) {
            return atual.livro; // Livro encontrado
        }

        // Busca na subárvore esquerda ou direita
        if (titulo.compareToIgnoreCase(atual.livro.getTitulo()) < 0) {
            return buscarRecursivo(atual.esquerdo, titulo);
        } else {
            return buscarRecursivo(atual.direito, titulo);
        }
    }

    // Método para exibir os livros em ordem alfabética (in-order traversal)
    public void exibirEmOrdem() {
        exibirEmOrdemRecursivo(raiz);
    }

    private void exibirEmOrdemRecursivo(Nodo atual) {
        if (atual != null) {
            exibirEmOrdemRecursivo(atual.esquerdo); // Visita a subárvore esquerda
            System.out.println(atual.livro); // Exibe o livro
            exibirEmOrdemRecursivo(atual.direito); // Visita a subárvore direita
        }
    }

    // Método para listar livros de um autor específico
    public void listarPorAutor(String autor) {
        System.out.println("Livros do autor \"" + autor + "\":");
        listarPorAutorRecursivo(raiz, autor);
    }

    private void listarPorAutorRecursivo(Nodo atual, String autor) {
        if (atual != null) {
            listarPorAutorRecursivo(atual.esquerdo, autor); // Busca na subárvore esquerda
            if (atual.livro.getAutor().equalsIgnoreCase(autor)) {
                System.out.println(atual.livro); // Exibe se o autor coincide
            }
            listarPorAutorRecursivo(atual.direito, autor); // Busca na subárvore direita
        }
    }

    // Método para listar livros por ano de publicação
    public void listarPorAno(int ano) {
        System.out.println("Livros publicados no ano " + ano + ":");
        listarPorAnoRecursivo(raiz, ano);
    }

    private void listarPorAnoRecursivo(Nodo atual, int ano) {
        if (atual != null) {
            listarPorAnoRecursivo(atual.esquerdo, ano); // Busca na subárvore esquerda
            if (atual.livro.getAnoPublicacao() == ano) {
                System.out.println(atual.livro); // Exibe se o ano coincide
            }
            listarPorAnoRecursivo(atual.direito, ano); // Busca na subárvore direita
        }
    }
}
