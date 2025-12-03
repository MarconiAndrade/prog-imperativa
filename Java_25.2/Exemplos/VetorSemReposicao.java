package Exemplos;

import java.util.Scanner;
import java.util.Arrays;

public class VetorSemReposicao{
    public static void main(String args[]){
        int[] numeros = new int[10];

        preencherVetorSemRepeticao(numeros);

        System.out.println("Os números digitados foram:");
        System.out.println(Arrays.toString(numeros));
    }

    public static void preencherVetorSemRepeticao(int[] v){
        Scanner scanner = new Scanner(System.in);
        for(int i = 0; i < v.length; i++){
            boolean numRepetido;

            do{
                System.out.format("Digite o %dº número: ", i+1);
                v[i] = scanner.nextInt();

                int pos = buscaSequencial(v, i, v[i]);
                numRepetido = (pos != -1);

                if (numRepetido){
                    System.out.println("Número já existente dentro do vetor, digite outro que não esteja");
                }

            }while(numRepetido);
        }
        scanner.close();
    }

    public static int buscaSequencial(int[] v, int tam, int x){
        for(int i = 0; i < tam; i ++){
            if(v[i] == x){
                return i;
            }
        }
        return -1;
    }
}