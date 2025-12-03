import java.util.Scanner;

public class Main{
    public static Scanner input = new Scanner(System.in);
    public static void main(String[] args){
        Produto produto1 = new Produto();
        Produto produto2 = new Produto();

        preencherInformacoes(produto1);
        preencherInformacoes(produto2);
        imprimir(produto1);
        imprimir(produto2);
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

    public static void imprimir(Produto prod){
        System.out.printf("\nTítulo: %s", prod.titulo);
        System.out.printf("\nDescrição: %s", prod.descricao);
        System.out.printf("\nPreço unitário: R$%.2f", prod.precoUnitario);
        System.out.printf("\nQuantidade no estoque: %d\n", prod.qtdEstoque);
    }
}