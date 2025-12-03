import java.util.Scanner;
import java.util.Arrays;

public class Exemplo06{
    public static Scanner input = new Scanner(System.in);
    public static final int QTD = 5;
    public static void main(String[] args){
    
    int[] numeros1 = new int[QTD];
    int[] numeros2 = new int[QTD];
    int[] soma = new int[QTD];

    preencherVetor(numeros1);
    preencherVetor(numeros2);
    somarVetor(numeros1, numeros2, soma);

    System.out.println("\nO primeiro vetor é:");
    System.out.println(Arrays.toString(numeros1));
    System.out.println("\nO segundo vetor é:");
    System.out.println(Arrays.toString(numeros2));
    System.out.println("\nA soma deles é:");
    System.out.println(Arrays.toString(soma));
    }

    public static void preencherVetor(int[] v){
        for(int i = 0; i < v.length; i++){
            System.out.format("Digite o %dº número do vetor: ", i+1);
            v[i] = input.nextInt();
        }
    }

    public static void somarVetor(int[] v, int[] v1, int[] vs){
        for(int i = 0; i < v.length; i++){
        vs[i] = v[i] + v1[i];
        }
    }
}