import java.util.Scanner;

public class Main{
    public static Scanner input = new Scanner(System.in);
    public static void main(String[] args){
        Aluno aluno = new Aluno();

        preencherInformacoes(aluno);
        imprimir(aluno);
        double media = calcularMedia(aluno);
        System.out.println("\nA média do aluno é: " + media);
    }

    public static void preencherInformacoes(Aluno al){
        System.out.println("Digite o seu nome:");
        al.nome = input.nextLine();
        System.out.println("Digite sua idade:");
        al.idade = input.nextInt();
        System.out.println("Digite sua 1ª nota:");
        al.nota1 = input.nextDouble();
        System.out.println("Digite sua 2ª nota:");
        al.nota2 = input.nextDouble();
    }
    
    public static void imprimir(Aluno al){
        System.out.printf("(%s, %d anos, %.1f, %.1f)", al.nome, al.idade, al.nota1, al.nota2);
    }

    public static double calcularMedia(Aluno al){
        return (al.nota1*2 + al.nota2*3)/5;
    }
}