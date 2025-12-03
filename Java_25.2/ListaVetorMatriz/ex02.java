package ListaVetorMatriz;

import java.util.Scanner;
import java.util.Arrays;

public class ex02{
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        int[] vetor = new int[5];
        System.out.println("Digite os valores desejados:");
        for(int i = 0; i < vetor.length; i++){
            vetor[i] = scanner.nextInt();
        }
        scanner.close();
        System.out.print("O vetor formado é: ");
        System.out.println(Arrays.toString(vetor));
    }    
}