import java.util.Scanner;

public class Basico01{
  static Scanner leitor = new Scanner(System.in);
  
  static int[] inverter(int vetor[]) {
    int tmp;
    int oposto;
    int tamanho = vetor.length;
    for (int i = 0; i < (tamanho/2); i++) {
      oposto = (tamanho - i - 1);
      tmp = vetor[i];
      vetor[i] = vetor[oposto];
      vetor[oposto] = tmp;
    }
    return vetor;
  }
  
  static int[] lerVetor(int tamanho){
    int[] vetor = new int[tamanho];
    for (int i = 0; i < tamanho; i++) {
      System.out.print("Digite o número na posição "+ (i + 1) +": ");
      vetor[i] = Integer.parseInt(leitor.nextLine());
    }
    return vetor;
  }
  
  static void imprimir(int[] vetor){
    for (int i = 0; i < vetor.length; i++)
      System.out.print(vetor[i]+" ");
  }
  
  public static void main(String[] args) throws Exception {
    final int TAMANHO = 6;
    int[]  inteiros;
      
    inteiros = lerVetor(TAMANHO);
    inteiros = inverter(inteiros);
    System.out.println("\nInvertido:\n");
    imprimir(inteiros);
    System.out.println("\nFIM.\n");
	leitor.close();
  }

  
}