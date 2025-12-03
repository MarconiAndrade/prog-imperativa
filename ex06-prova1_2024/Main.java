import java.util.Scanner;

public class Prova2024{
    public static final int QTD = 4;
    public static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args){
        int[] vetor1 = new int[QTD];
        int[] vetor2 = new int[QTD];
        int[] vetorResult = new int[QTD];
        int tam1 = 0, tam2 = 0, tamR = 0, opcao;
        do{
            System.out.println("\nMENU");
            System.out.println("1 - Preencher vetor");
            System.out.println("2 - Imprimir vetor");
            System.out.println("3 - Procurar um número");
            System.out.println("4 - Gerar e imprimir vetor inverso");
            System.out.println("5 - Gerar e imprimir vetor soma");
            System.out.println("6 - Gerar e imprimir vetor par/ímpar");
            System.out.println("0 - Finalizar o programa");
            opcao = scanner.nextInt();
            switch(opcao){
                case 1:
                    System.out.println("Digite 1 para preencher o vetor 1 ou 2 para o vetor 2: ");
                    int escolha = scanner.nextInt();
                    if(escolha == 1){
                        tam1 = preecherVetor(vetor1, tam1);
                    }
                    else if(escolha == 2){
                        tam2 = preecherVetor(vetor2, tam2);
                    }
                    else{
                        System.out.println("Opção inválida!");
                    }
                    break;
                case 2:
                    System.out.println("Digite 1 para imprimir o vetor 1 ou 2 para o vetor 2: ");
                    int numImp = scanner.nextInt();
                    if(numImp == 1){
                        imprimirVetor(vetor1, tam1);
                    }
                    else if(numImp == 2){
                        imprimirVetor(vetor2, tam2);
                    }
                    else{
                        System.out.println("Opção inválida!");
                    }
                    break;
                case 3:
                    System.out.println("Digite um número para buscar sua posição: ");
                    int busca = scanner.nextInt();
                    int pos = buscaSequencial(vetor1, tam1, busca);
                    if(pos != -1){
                        System.out.println("O número " + busca + " foi encontrado na posição: " + pos);
                    }
                    else{
                        System.out.println("O número " + busca + " não foi encontrado no vetor");
                    }
                    break;
                case 4:
                    System.out.println("Vetor inverso: ");
                    tamR = inverterVetor(vetor1, tam1, vetorResult);
                    imprimirVetor(vetorResult, tamR);
                    break;
                case 5:
                    System.out.println("Vetor soma: ");
                    tamR = somar(vetor1, vetor2, vetorResult);
                    imprimirVetor(vetorResult, tamR);
                    break;
                case 6:
                    System.out.println("Vetor formado por pares e ímpares: ");
                    tamR = parImpar(vetor1, tam1, vetor2, tam2, vetorResult);
                    imprimirVetor(vetorResult, tamR);
                    break;
                default:
                    if(opcao != 0){
                        System.out.println("Opção inválida!");
                    }
            }
        } while(opcao != 0);
    }

    public static int preecherVetor(int[] v, int tam){
        if(tam >= v.length){
            System.out.println("Vetor cheio!");
            return tam;
        }
        for(int i = 0; i < v.length; i++){
            System.out.println("Digite o " + (i+1) + "º número do vetor: ");
            v[i] = scanner.nextInt();
            tam++;
        }
        return tam;
    }

    public static void imprimirVetor(int[] v, int tam){
        System.out.print("{");
        if(tam > 0){
            System.out.print(v[0]);
        }
        for(int i = 1; i < tam; i++){
            System.out.print(", " + v[i]);
        }
        System.out.println("}");
    }

    public static int buscaSequencial(int[] v, int tam, int x){
        for(int i = 0; i < tam; i ++){
            if(v[i] == x){
                return i;
            }
        }
        return -1;
    }

    public static int inverterVetor(int[] v, int tam, int [] vi){
        for(int i = 0; i < tam; i++){
            vi[i] = v[tam - 1 - i];
        }
        return tam;
    }

    public static int somar(int[] v1, int[] v2, int[] vs){
        for(int i = 0; i < v1.length; i++){
            vs[i] = v1[i] + v2[i];
        }
        return v1.length;
    }

    public static int parImpar(int[] v1, int tam1, int [] v2, int tam2, int[] vpi){
        int novoTam = 0;
        for(int i = 0; i < tam1; i++){
            if(v1[i] % 2 == 0){
                if(novoTam >= vpi.length){
                    System.out.println("O vetor resultado está cheio!");
                    return vpi.length;
                }
                vpi[novoTam] = v1[i];
                novoTam++; 
            }
        }
        for(int i = 0; i < tam2; i++){
            if(v2[i] % 2 != 0){
                if(novoTam >= vpi.length){
                    System.out.println("O vetor resultado está cheio!");
                    return novoTam;
                }
                vpi[novoTam] = v2[i];
                novoTam++; 
            }
        }
        return novoTam;
    }
}