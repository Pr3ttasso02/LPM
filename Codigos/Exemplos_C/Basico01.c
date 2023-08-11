#include <stdio.h>
#include <stdlib.h>

void inverter(int vetor[], int tamanho) {
  int tmp;
  int oposto;
  for (int i = 0; i < (tamanho / 2); i++) {
    oposto = (tamanho - i - 1);
    tmp = vetor[i];
    vetor[i] = vetor[oposto];
    vetor[oposto] = tmp;
  }
}

int * lerVetor(int tamanho){
  int * vetor = malloc(tamanho);
  for (int i = 0; i < tamanho; i++) {
    printf("Digite o número na posição %d: ", (i + 1));
    scanf("%d", &vetor[i]);
  }
  return vetor;
}

void imprimir(int *vetor, int tamanho){
  for (int i = 0; i < tamanho; i++)
    printf("%d ", vetor[i]);
}

int main() {
  const int TAMANHO = 6;
  int * inteiros;
    
  inteiros = lerVetor(TAMANHO);
  inverter(inteiros, TAMANHO);
  printf("\nInvertido:\n");
  imprimir(inteiros, TAMANHO);
  printf("\nFIM.\n");
  free(inteiros);
  return 0;
}
