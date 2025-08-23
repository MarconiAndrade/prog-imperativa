public class Exemplo02{
    public static void main(String args[]){
        System.out.println("Olá, turma!");
        System.out.println("Sequência até 100:");
        for(int i = 1; i <= 100; i++){
            System.out.println(i);
        }
        System.out.println("Ímpares até 100:");
        for(int j = 1; j < 100; j++){
            if (j%2 != 0){
                System.out.println(j);
            }
        }
        System.out.println("Pares até 100:");
        for(int k = 1; k <= 100; k++){
            if (k%2 == 0){
                System.out.println(k);
            }
        }
        System.out.println("Múltiplos de 3:");
        for(int t = 1; t <= 100; t++){
            if (t%3 == 0){
                System.out.println(t);
            }
        }
        System.out.println("Múltiplos de 3 e termiandos em 3:");
        for(int p = 1; p <= 100; p++){
            if(p%3 == 0 || p%10 == 3){
                System.out.println(p);
            }
        }
    }
}