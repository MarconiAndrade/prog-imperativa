package ListaVetorMatriz;

public class ex01{
    public static void main(String[] args){

        int[] A = {1, 0, 5, -2, -5, 7};//a
        int soma = A[0] + A[1] + A[5];
        System.out.format("A soma é %d\n", soma);//b
        A[4] = 100;
        for(int i = 0; i < A.length; i++){
            System.out.println(A[i]);
        }
    }
}