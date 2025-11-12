import java.util.Scanner;

public class Main{
    public static Scanner input = new Scanner(System.in);
    public static void main(String[] args){

    }

    public static int cadastrarPessoa(Pessoa[] v, int qtd){
        if(qtd >= v.length){
            System.out.println("Vetor cheio! Não é possível cadastrar mais ninguém.");
        }
        else{
            System.out.println("Digite seu nome:");
            v.nome = input.nextLine();
            System.out.println("Digite sua idade:");
            v.idade = input.nextInt();
            System.out.println("Digite seu peso:");
            v.peso = input.nextDouble();
            System.out.println("Digite sua altura:");
            v.altura = input.nextDouble();
            buscarNome(v, qtd);
            if(buscarNome != -1){
                System.out.println("Favor digitar novamente seu nome com sobrenome:");
                v.nome = input.nextLine();
            }
            qtd++;
        }
        return qtd;
    }

    public static int buscarNome(Pessoa[] v, int qtd){
        for(int i = 0; i < qtd; i++){
            if(v[i] == v.nome){
                return i;
            }
        }
        return -1;
    }

    public static void imprimirPessoas(Pessoa [] v, int qtd){
        for(int i = 0; i < qtd; i++){
            System.out.printf("Pessoa %d\n", i+1);
            System.out.printf("Nome: %s\n", v[i].v.nome);
            System.out.printf("Idade: %d\n", v[i].v.idade);
            System.out.printf("Peso: %.2f\n", v[i].v.peso);
            System.out.printf("Altura: %.2f\n", v[i].v.altura);
            double imc = calcularIMC(v[i]);
            System.out.printf("IMC: %.2f\n", imc);
        }
    }

    public static double calcularIMC(Pessoa p){
        return p.peso/p.altura*p.altura;
    }

    
}