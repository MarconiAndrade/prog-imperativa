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
            for(int j = 0; j < QTD; i++){
                System.out.println("Digite o título do produto:");
                prod[j].titulo = input.nextLine();
                System.out.println("Digite a descrição do produto:");
                prod[j].descricao = input.nextLine();
                System.out.println("Digite o preço unitário do produto:");
                prod[j].precoUnitario = input.nextDouble();
                System.out.println("Digite a quantidade do estoque:");
                prod[j].qtdEstoque = input.nextInt();
                input.nextLine();//enter da digitação anterior
            }
        }

    }

    public static void imprimirVetor(Produto[] prod){
        for(int i = 0; i < QTD; i++){
            System.out.printf("\nTítulo: %s", prod[i].titulo);
            System.out.printf("\nDescrição: %s", prod[i].descricao);
            System.out.printf("\nPreço unitário: R$%.2f", prod[i].precoUnitario);
            System.out.printf("\nQuantidade no estoque: %d\n", prod[i].qtdEstoque);
        }
    }
}