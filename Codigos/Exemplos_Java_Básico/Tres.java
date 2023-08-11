import java.util.Scanner;

public class Tres {
    public static void main(String[] args) {
        Scanner leitorTeclado = new Scanner(System.in);
        
        int tamanho;
        int[] v;
        
        System.out.print("Qual será o tamanho do vetor? ")
        tamanho = Integer.parseInt(leitorTeclado.nextLine());
        v = new int[tamanho];

        System.out.println("Carregando o vetor: ");
        for (int i = 0; i < v.length; i++) {
            v[i] = (i+1)*2;
            System.out.print(v[i]+" ");
        }
        System.out.println();
        leitorTeclado.close();
    }
}
