package exProvaCC;
import java.util.Scanner;

public class EstudoProva{
    public static Scanner input = new Scanner(System.in);
    public static void main(String[] args){
        Produto[] produtos = new Produto[10];
        
        produtos[0] = new Produto(); produtos[0].nome = "refrigerante"; produtos[0].id = 4; produtos[0].descricao = "Refrigerante 2L"; produtos[0].qtdEstoque = 100; produtos[0].precoUnit = 8.79;
        produtos[1] = new Produto(); produtos[1].nome = "salgado"; produtos[1].id = 2; produtos[1].descricao = "Salgado de Queijo"; produtos[1].qtdEstoque = 50; produtos[1].precoUnit = 5.25;
        produtos[2] = new Produto(); produtos[2].nome = "suco"; produtos[2].id = 1; produtos[2].descricao = "Suco de Uva 1L"; produtos[2].qtdEstoque = 20; produtos[2].precoUnit = 10.58;
        produtos[3] = new Produto(); produtos[3].nome = "massa"; produtos[3].id = 3; produtos[3].descricao = "Bolo"; produtos[3].qtdEstoque = 10; produtos[3].precoUnit = 15.00;
        
        int tamProdutos = 4;

        listar(produtos, tamProdutos);
        //bubbleSortPorID(produtos, tamProdutos);
        //bubbleSortPorNome(produtos, tamProdutos);
        //insertionSortPorID(produtos, tamProdutos);
        //insertionSortPorNome(produtos, tamProdutos);
        selectionSortPorID(produtos, tamProdutos);
        listar(produtos, tamProdutos);

        System.out.println("Digite o ID que você deseja pesquisar:");
        int pesquisaID = input.nextInt();
        if(buscaSequencialPorID(produtos, tamProdutos, pesquisaID) != -1){
            System.out.println("Achou o ID");
        }
        else{
            System.out.println("NÃO achou o ID");
        }

        System.out.println("\nDigite o nome de um produto que gostaria de ver se tem:");
        String pesquisaNome = input.nextLine();
        if(buscaBinariaPorNome(produtos, tamProdutos, pesquisaNome) != -1){
            System.out.println("Achou o nome");
        }
        else{
            System.out.println("NÃO achou o nome");
        }
    }

/*     public static void bubbleSortPorID(Produto[] v, int tam){
        Produto aux;
        for(int i = 0; i < tam - 1; i++){
            for(int j = 0; j < tam - 1 - i; j++){
                if(v[j].id > v[j+1].id){
                    aux = v[j];
                    v[j] = v[j+1];
                    v[j+1] = aux;
                }
            }
        }
    } */

/*     public static void bubbleSortPorNome(Produto[] v, int tam){
        Produto aux;
        for(int i = 0; i < tam - 1; i++){
            for(int j = 0; j < tam - 1-i; j++){
                if(v[j].nome.compareTo(v[j+1].nome) > 0){
                    aux = v[j];
                    v[j] = v[j+1];
                    v[j+1] = aux;
                }
            }
        }
    } */

/*     public static void insertionSortPorID(Produto[] v, int tam){
        Produto aux;
        for(int i = 1; i < tam; i++){
            aux = v[i];
            int j = i - 1;
            while(j >= 0 && v[j].id > aux.id){
                v[j+1] = v[j];
                j--;
            }
            v[j+1] = aux;
        }
    } */

/*     public static void insertionSortPorNome(Produto[] v, int tam){
        Produto aux;
        for(int i = 1; i < tam; i++){
            aux = v[i];
            int j = i - 1;
            while(j >= 0 && v[j].nome.compareTo(aux.nome) > 0){
                v[j+1] = v[j];
                j--;
            }
            v[j+1] = aux;
        }
    } */

    public static void selectionSortPorID(Produto[] v, int tam){
        Produto aux;
        int posMenor;
        for(int i = 0; i < tam; i++){
            posMenor = i;
            for(int j = i + 1; j < tam; j++){
                if(v[j].id < v[posMenor].id){
                    posMenor = j;
                }
            }
            aux = v[posMenor];
            v[posMenor] = v[i];
            v[i] = aux;
        }
    }

    public static int buscaSequencialPorID(Produto[] v, int tam, int x){
        for(int i = 0; i < tam; i++){
            if(v[i].id == x){
                return i;
            }
        }
        return -1;
    }

    public static int buscaBinariaPorNome(Produto[] v, int tam, String x){
        int inicio = 0, fim = tam-1, meio;
        while(inicio <= fim){
            meio = (inicio + fim)/2;
            if(v[meio].nome.equals(x)){
                return meio;
            }
            else if(v[meio].nome.compareTo(x) > 0){
                fim = meio - 1;
            }
            else{
                inicio = meio + 1;
            }
        }
        return -1;
    }

    public static void listar(Produto[] v, int tam){
        System.out.println("\nLISTAGEM DOS PRODUTOS\n");
        for(int i = 0; i < tam; i++){
            System.out.printf("%2d %s      // %s\n", v[i].id, v[i].descricao, v[i].nome);
        }
    }
}