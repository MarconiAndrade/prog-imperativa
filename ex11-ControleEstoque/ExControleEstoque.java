import java.util.Scanner;

class Produto{
    String nome;
    String descricao;
    String categoria;
    double precoUnitario;
    int qtdEstoque;
    int qtdMinima;
}

public class ExControleEstoque{
    public static Scanner input = new Scanner(System.in);
    public static final int QTD = 3;
    public static void main(String[] args){
        Produto[] produtos = new Produto[QTD];
        int opcao, tam = 0;

        do{
            System.out.println("\n---------- MENU ----------");
            System.out.println("1 - Cadastrar novo produto");
            System.out.println("2 - Listar produto(s)");
            System.out.println("3 - Filtrar por categoria");
            System.out.println("4 - Ordenar");
            System.out.println("5 - Remover elemento");
            System.out.println("6 - Atualizar preço");
            System.out.println("7 - Listagem com subtotal do valor em estoque por categoria");
            System.out.println("0 - Sair do programa");

            opcao = input.nextInt();
            switch(opcao){
                case 1:
                    tam = cadastrarProduto(produtos, tam);
                    break;
                case 2:
                    imprimirVetor(produtos, tam);
                    break;
                case 3:
                    input.nextLine();
                    System.out.println("Qual categoria deseja filtrar?");
                    String categoriaFiltro = input.nextLine();
                    filtrarCategoria(produtos, tam, categoriaFiltro);
                    break;
                case 4:
                    insertionSortPorNome(produtos, tam);
                    break;
                case 5:
                    input.nextLine();
                    System.out.println("Qual produto deseja remover?");
                    String nomeProdRemocao = input.nextLine();
                    tam = remover(produtos, tam, nomeProdRemocao);
                    break;
                case 6:
                    input.nextLine();
                    System.out.println("Qual produto deseja atualizar o preço?");
                    String nomeProdNovoPreco = input.nextLine();
                    atualizarPreco(produtos, tam, nomeProdNovoPreco);
                    break;
                case 7:
                    listagem(produtos, tam);
                    break;
                default:
                    if(opcao == 0){
                        System.out.println("Fechando o programa");
                    }
                    else{
                    System.out.println("Opção inválida!");
                    }
                    break;
            }
        } while(opcao != 0);
    }

    public static int cadastrarProduto(Produto[] v, int tam){
        if(tam >= v.length){
            System.out.println("Não é possível cadastrar mais produtos, vetor cheio!");
            return tam;
        }    

        v[tam] = new Produto();

        input.nextLine();
        System.out.println("Nome do produto:");
        v[tam].nome = input.nextLine();
        System.out.println("Descrição do produto:");
        v[tam].descricao = input.nextLine();
        System.out.println("Categoria do produto:");
        v[tam].categoria = input.nextLine();
        System.out.println("Preço unitário do produto:");
        v[tam].precoUnitario = input.nextDouble();
        System.out.println("Quantidade no estoque");
        v[tam].qtdEstoque = input.nextInt();   
        System.out.println("Quantidade mínima no estoque:");
        v[tam].qtdMinima = input.nextInt();
        input.nextLine();//enter da digitação anterior
        tam++;
        return tam;
    }

    public static void imprimirVetor(Produto[] v, int tam){
        for(int i = 0; i < tam; i++){
            System.out.println("\n--------- Produto " + (i+1) + " ---------");
            imprimir(v[i]);
        }
    }

    public static void imprimir(Produto prod){
        System.out.printf("Nome: %s", prod.nome);
        System.out.printf("\nDescrição: %s", prod.descricao);
        System.out.printf("\nCategoria: %s", prod.categoria);
        System.out.printf("\nPreço unitário: R$%.2f", prod.precoUnitario);
        System.out.printf("\nQuantidade no estoque: %d\n", prod.qtdEstoque);
    }

    public static void filtrarCategoria(Produto[] v, int tam, String categEscolhida){
        for(int i = 0; i < tam; i++){
            if(v[i].categoria.equalsIgnoreCase(categEscolhida)){
                System.out.println("\n");
                imprimir(v[i]);
            }
        }
    }

    public static void insertionSortPorNome(Produto[] v, int tam){
        for(int i = 1; i < tam; i++){
            Produto chave = v[i];
            int j = i - 1;
            while(j >= 0 && v[j].nome.compareTo(chave.nome) > 0){
                v[j+1] = v[j];
                j--;
            }
            v[j+1] = chave;
        }
    }

    public static int remover(Produto[] v, int tam, String x){
        int pos = buscaSequencial(v, tam, x);
        if(pos == -1){
            System.out.println("Não encontrado no vetor!");
            return tam;
        }
        for(int i = pos; i < tam-1; i++){
            v[i] = v[i+1];
        }
        return tam-1;
    }

    public static int buscaSequencial(Produto[] v, int tam, String x){
        for(int i = 0; i < tam; i++){
            if(v[i].nome.equalsIgnoreCase(x)){
            return i;
            }
        }
        return -1;
    }

    public static void atualizarPreco(Produto[] v, int tam, String x){
        for(int i = 0; i < tam; i++){
            if(v[i].nome.equalsIgnoreCase(x)){
                System.out.println("Digite o novo preço:");
                double novoPreco = input.nextDouble();
                input.nextLine();
                v[i].precoUnitario = novoPreco;
                System.out.println("Preço atualizado!");
                return;
            }
        }
        System.out.println("Produto não encontrado!");
    }

    public static double listagem(Produto[] v, int tam){
        input.nextLine();
        System.out.println("Digite a categoria:");
        String categoriaBuscada = input.nextLine();
        double subtotal = 0;
        boolean achou = false;

        for(int i = 0; i < tam; i++){
            if(v[i].categoria.equalsIgnoreCase(categoriaBuscada)){
                System.out.printf("\nNome: %s", v[i].nome);
                System.out.printf("\nPreço: %.2f", v[i].precoUnitario);
                System.out.printf("\nQuantidade: %d", v[i].qtdEstoque);
                System.out.printf("\n-------------------");

                subtotal += v[i].precoUnitario * v[i].qtdEstoque;
                achou = true;
            }
        }
        if(!achou){
            System.out.println("Nenhum produto encontrado nesta categoria.");
            return 0;
        }
        System.out.printf("\nSubtotal da categoria %s: R$ %.2f", categoriaBuscada, subtotal);
        return subtotal;
    } 
}