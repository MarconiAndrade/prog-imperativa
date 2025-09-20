import java.util.Arrays;
import java.util.Scanner;

public class Exercicio {
    public static final int QTD = 30;
    public static void main(String args[]){
        int[] vetor1 = new int[QTD];
        int[] vetor2 = new int[QTD];

        inserirElemento(vetor1, 10);
        inserirElemento(vetor2, 10);

        System.out.println("\nO primeiro vetor é:");
        System.out.println(Arrays.toString(vetor1));
        System.out.println("\nO segundo vetor é:");
        System.out.println(Arrays.toString(vetor2));

    }

    public static int inserirElemento(int[] v,int tam){
        Scanner scanner = new Scanner(System.in);
        for(int i = 0; i < v.length; i++){
            System.out.format("Digite o %dº número do vetor:", i+1);
            v[i] = scanner.nextInt();

            
        }
        return tam+1;
    }

    public static int buscaSequencial(int[] v, int tam, int x){


    }
}