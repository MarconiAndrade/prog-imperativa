import java.util.Scanner;

public class Exemplo04{
    public static final int QTD = 4;
    public static void main(String args[]){
        Scanner input = new Scanner(System.in);
        int[] numeros = new int[QTD];
        int soma = 0;
        double media;
        for(int i = 0; i < numeros.length; i++){
            System.out.printf("Digite o %dº número: ", i+1);
            numeros[i] = input.nextInt();
            soma += numeros[i];
        }
        media = (double) soma/QTD;
        System.out.printf("A média destes %d números é %.2f\n", QTD, media);
        System.out.println("Impressão de números maiores que a média:");
        for(int i = 0; i < numeros.length; i++){
            if(numeros[i] > media){
                System.out.printf("v[%d] = %d\n", i+1, numeros[i]);
            }
        }
    }

    public static void preencherVetorDigitacao(int[] v){
        for(int i = 0; i < v.length; i++){
            System.out.printf("Digite o %dº", i+1);
        }
    }
}