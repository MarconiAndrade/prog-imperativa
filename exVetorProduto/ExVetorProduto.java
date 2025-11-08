import java.util.Scanner;

public class ExVetorProduto{
    public static Scanner input = new Scanner(System.in);
    public static final int QTD = 2;
    public static void main(String[] args){
        Produto[] produtos = new Produto[QTD];
        preencherVetor(produtos);
        imprimirVetor(produtos);
    }

    public static void preencherVetor(Produto[] prod){
        for(int i = 0; i < QTD; i++){
            prod[i] = new Produto();
            preencherInformacoes(prod[i]);
        }
    }

    public static void preencherInformacoes(Produto prod){
        System.out.println("Digite o título do produto:");
        prod.titulo = input.nextLine();
        System.out.println("Digite a descrição do produto:");
        prod.descricao = input.nextLine();
        System.out.println("Digite o preço unitário do produto:");
        prod.precoUnitario = input.nextDouble();
        System.out.println("Digite a quantidade do estoque:");
        prod.qtdEstoque = input.nextInt();
        input.nextLine();//enter da digitação anterior
    }

    public static void imprimirVetor(Produto[] prod){
        for(int i = 0; i < QTD; i++){
            System.out.println("\n--------- Produto " + (i+1) + " ---------");
            imprimir(prod[i]);
        }
    }

    public static void imprimir(Produto prod){
        System.out.printf("\nTítulo: %s", prod.titulo);
        System.out.printf("\nDescrição: %s", prod.descricao);
        System.out.printf("\nPreço unitário: R$%.2f", prod.precoUnitario);
        System.out.printf("\nQuantidade no estoque: %d\n", prod.qtdEstoque);
    }
}