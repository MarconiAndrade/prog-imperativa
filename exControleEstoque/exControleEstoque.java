import java.util.Scanner;

public class exControleEstoque{
    public static Scanner input = new Scanner(System.in);
    public static final QTD = 3;
    public static void main(String[] args){
        Produto[] produtos = new Produto[QTD];
        int opcao, tam = 0;

        do{
            System.out.println("-----MENU-----");
            System.out.println("1 - Cadastrar novo produto");
            System.out.println("2 - Listar produto(s)");
            System.out.println("3 - Filtrar por categoria");
            System.out.println("4 - Ordenar");
            System.out.println("5 - Remover elemento");
            System.out.println("6 - Atualizar preço");
            System.out.println("7 - Listagem com subtotal do valor em estoque por categoria");

            opcao = input.nextInt();
            switch(opcao){
                case 1:
                    tam = cadastrarProduto(produtos, tam);
                    break;
                case 2:
                    tam = imprimirVetor(produtos);
                    break;
                case 3:
                    tam = 
                    break;
                case 4:

                    break;
                case 5:

                    break;
                case 6:

                    break;
                case 7:

                    break;
                default:
                    System.out.println("Opção inválida!");
                    break;
            }
        } while(opcao != 0);
    }

    public static int cadastrarProduto(Produto[] produtos, int tam){
        if(tam >= produtos.length){
            System.out.println("Não é possível cadastrar mais produtos, vetor cheio!");
            return tam;
        }    

        Produto prod = new Produto();

        input.nextLine();
        System.out.println("Nome do produto:");
        prod.nome = input.nextLine();
        System.out.println("Descrição do produto");
        prod.descricao = input.nextLine();
        System.out.println("Categoria do produto");
        prod.categoria = input.nextLine();
        System.out.println("Preço unitário do produto:");
        prod.preco = input.nextDouble();
        System.out.println("Quantidade no estoque");
        prod.estoque = input.nextInt();        
        System.out.println("Quantidade mínima no estoque:");
        prod.qtdMinima = input.nextInt();    


        produtos[tam] = prod;
        return tam+1;
    }

    public static void imprimirVetor(Produto[] prod){
        for(int i = 0; i < QTD; i++){
            System.out.println("\n--------- Produto " + (i+1) + " ---------");
            imprimir(prod[i]);
        }
    }

    public static void imprimir(Produto prod){
        System.out.printf("\nNome: %s", prod.nome);
        System.out.printf("\nDescrição: %s", prod.descricao);
        System.out.printf("\nCategoria: %s", prod.categoria);
        System.out.printf("\nPreço unitário: R$%.2f", prod.precoUnitario);
        System.out.printf("\nQuantidade no estoque: %d\n", prod.qtdEstoque);
    }

    
}