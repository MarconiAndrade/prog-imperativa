import java.util.Scanner;

public class QuestaoConjuntos{
    public static Scanner input = new Scanner(System.in);
    public static void main(String[] args){
        int[] conjuntoA = new int[30];
        int[] conjuntoB = new int[30];
        int tamA = 0, tamB = 0, opcao;
        do{
            opcoesMenu();
            opcao = input.nextInt();
            switch(opcao){
                case 1:
                    tamA = inserirNumero(conjuntoA, tamA);
                    break;
                case 2:
                    tamB = inserirNumero(conjuntoB, tamB);
                    break;
                case 3:
                    imprimirConjuntos(conjuntoA, tamA, conjuntoB, tamB);
                    break;
                case 4:
                    uniao(conjuntoA, tamA, conjuntoB, tamB);
                    break;
                case 5:
                    intersecao(conjuntoA, tamA, conjuntoB, tamB);
                    break;
                case 6:
                    diferenca(conjuntoA, tamA, conjuntoB, tamB, "A", "B");
                    break;
                case 7:
                    diferenca(conjuntoB, tamB, conjuntoA, tamA, "B", "A");
                    break;
                case 0:
                    System.out.println("Saindo do programa...");
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        } while(opcao != 0);
        input.close();
    }

    public static void opcoesMenu(){
        System.out.println("\n1 - Inserir elemento no Conjunto A");
        System.out.println("2 - Inserir elemento no Conjunto B");
        System.out.println("3 - Imprimir os Conjuntos A e B");
        System.out.println("4 - Gerar e Imprimir a união de A e B");
        System.out.println("5 - Gerar e Imprimir a interseção entre A e B");
        System.out.println("6 - Gerar e Imprimir a diferença entre A e B");
        System.out.println("7 - Gerar e Imprimir a diferença entre B e A");
        System.out.println("0 - Sair");
        System.out.println("Escolha uma opção:");
    }

    public static int inserirNumero(int[] vetor, int tam){
        if(tam >= vetor.length){
            System.out.println("Conjunto cheio. Não é possível inserir mais números.");
            return tam;
        }
        System.out.print("Digite o número desejado:");
        int numero = input.nextInt();
        if(buscaSequencial(vetor, tam, numero) != -1){
            System.out.println("O número " + numero + " já existe no conjunto.");
            return tam;
        }
        vetor[tam] = numero;
        System.out.println("Número " + numero + " inserido com sucesso.");
        return tam + 1;
    }

    public static int buscaSequencial(int[] vetor, int tam, int x){
        for(int i = 0; i < tam; i++){
            if(vetor[i] == x){
                return i;
            }
        }
        return -1;
    }

    public static void imprimir(int[] vetor, int tam){
        System.out.print("{ ");
        for(int i = 0; i < tam; i++){
            System.out.print(vetor[i]);
            if(i < tam - 1){
                System.out.print(", ");
            }
        }
        System.out.print(" }");
    }

    public static void imprimirConjuntos(int[] a, int tamA, int[] b, int tamB){
        System.out.print("Conjunto A: ");
        imprimir(a, tamA);
        System.out.print("\nConjunto B: ");
        imprimir(b, tamB);
        System.out.println();
    }

    public static void uniao(int[] a, int tamA, int[] b, int tamB){
        int[] uniao = new int[tamA + tamB];
        int tamU = 0;
        for(int i = 0; i < tamA; i++){
            uniao[tamU++] = a[i];
        }
        for(int i = 0; i < tamB; i++){
            if(buscaSequencial(a, tamA, b[i]) == -1){
                uniao[tamU++] = b[i];
            }
        }
        System.out.print("União de A e B: ");
        imprimir(uniao, tamU);
        System.out.println();
    }

    public static void intersecao(int[] a, int tamA, int[] b, int tamB){
        int[] intersecao = new int[Math.min(tamA, tamB)];
        int tamI = 0;
        for(int i = 0; i < tamA; i++){
            if(buscaSequencial(b, tamB, a[i]) != -1){
                intersecao[tamI++] = a[i];
            }
        }
        System.out.print("Interseção de A e B: ");
        imprimir(intersecao, tamI);
        System.out.println();
    }

    public static void diferenca(int[] a, int tamA, int[] b, int tamB, String nomeA, String nomeB){
        int[] diferenca = new int[tamA];
        int tamD = 0;
        for(int i = 0; i < tamA; i++){
            if(buscaSequencial(b, tamB, a[i]) == -1){
                diferenca[tamD++] = a[i];
            }
        }
        System.out.print("Diferença de " + nomeA + " - " + nomeB + ": ");
        imprimir(diferenca, tamD);
        System.out.println();
    }
}