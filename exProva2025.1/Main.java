import java.util.Scanner;

public class Main{
    public static Scanner input = new Scanner(System.in);
    public static void main(String[] args){
        Pessoa[] pessoas = new Pessoa[3];
        int qtd = 0;
        qtd = cadastrarPessoa(pessoas, qtd);
        imprimirPessoas(pessoas, qtd);
        maisVelhaIMCMagreza(pessoas, qtd);

    }

    public static int cadastrarPessoa(Pessoa[] v, int qtd){
        if(qtd >= v.length){
            System.out.println("Vetor cheio! Não é possível cadastrar mais ninguém.");
            return qtd;
        }
        for(int i = 0; i < v.length; i++){
            v[qtd] = new Pessoa();
            System.out.println("Digite seu nome:");
            v[qtd].nome = input.nextLine();
            System.out.println("Digite sua idade:");
            v[qtd].idade = input.nextInt();
            input.nextLine();
            System.out.println("Digite seu peso:");
            v[qtd].peso = input.nextDouble();
            input.nextLine();
            System.out.println("Digite sua altura:");
            v[qtd].altura = input.nextDouble();
            input.nextLine();
            if(buscarNome(v, qtd, v[qtd].nome) != -1){
                System.out.println("Favor digitar novamente seu nome com sobrenome:");
                v[qtd].nome = input.nextLine();
            }
            qtd++;
        }
        return qtd;
    }

    public static int buscarNome(Pessoa[] v, int qtd, String nome){
        for(int i = 0; i < qtd; i++){
            if(v[i].nome.equals(nome)){
                return i;
            }
        }
        return -1;
    }

    public static void imprimirPessoas(Pessoa[] v, int qtd){
        for(int i = 0; i < qtd; i++){
            System.out.printf("\n-----Pessoa %d-----\n", i+1);
            System.out.printf("Nome: %s\n", v[i].nome);
            System.out.printf("Idade: %d\n", v[i].idade);
            System.out.printf("Peso: %.2f\n", v[i].peso);
            System.out.printf("Altura: %.2f\n", v[i].altura);
            double imc = calcularIMC(v[i]);
            System.out.printf("IMC: %.2f\n\n", imc);
        }
    }

    public static double calcularIMC(Pessoa p){
        return p.peso/(p.altura*p.altura);
    }

    public static int maisVelhaIMCMagreza(Pessoa[] v, int qtd){
        for(int i = 1; i <= qtd; i++){
            if(calcularIMC(v[i]) < 18.5){
                if(v[i].idade > v[i-1].idade){
                    System.out.printf("A pessoa mais velha com IMC Magreza está na posição %d\n", i+1);
                    return i;
                }
            }
            
        }
        return -1;
    }
}