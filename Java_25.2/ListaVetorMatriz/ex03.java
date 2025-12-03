package ListaVetorMatriz;

import java.util.Scanner;

public class ex03{
    public static final int QTD = 9;
    public static void main(String[] args){
        int[] v1 = new int[QTD];
        int[] v2 = new int[QTD];

        preencherVetor(v1);
        quadradoVetor(v1);
        System.out.println();
    }

    public static void preencherVetor(int[] v){
        Scanner scanner = new Scanner(System.in);
        for(int i = 0; i < v.length; i++){
            System.out.format("Digite o %dº número do vetor: ", i+1);
            v[i] = scanner.nextInt();
        }
    }

    public static void quadradoVetor(int[] v){
        for(int j = 0; j < v.length; j++){
            Math.pow(v[j], 2);
        }
    }
}
