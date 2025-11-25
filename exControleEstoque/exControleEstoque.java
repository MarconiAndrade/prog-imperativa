import java.util.Scanner;

public class exControleEstoque{
    public static Scanner input = new Scanner(System.in);
    public static final QTD = 3;
    public static void main(String[] args){
        Produto[] produto = new Produto[QTD];
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
                    
            }
        } while(opcao != 0);
    }
}