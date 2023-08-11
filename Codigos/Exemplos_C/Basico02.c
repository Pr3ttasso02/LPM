#include <stdio.h>
#include <stdlib.h>

int * lerVetor(int tamanho){
  int * vetor = malloc(tamanho);
  for (int i = 0; i < tamanho; i++) {
    printf("Digite o número na posição %d: ", (i + 1));
    scanf("%d", &vetor[i]);
  }
  return vetor;
}

int definirTamanhoNovo(int tamanho){
  int novoTamanho = (tamanho/2)+(tamanho%2);
  return novoTamanho;
}

void imprimir(int *vetor, int tamanho){
  for (int i = 0; i < tamanho; i++)
    printf("%d ", vetor[i]);
}

int * somarVizinhosEmVetorDeInteiros(int vet[], int tamanhoOriginal){
        int tamanhoNovoVetor = definirTamanhoNovo(tamanhoOriginal);    
        int ultimoValor = vet[tamanhoOriginal-1];
     
        int * novoVetor = malloc(tamanhoNovoVetor);

        for (int i = 0; i < tamanhoOriginal-1; i+=2) {
            novoVetor[i/2] = vet[i]+vet[i+1];
        }

        if(tamanhoOriginal%2==1){ //se for tamanho ímpar, guarda a soma do último consigo
            novoVetor[tamanhoNovoVetor-1] = ultimoValor+ultimoValor;          
        }       
        return novoVetor;
    }

int main(void){
    int tamanhoOriginal;
    
    int * inteiros;
    int * somados;

    printf("Qual será o tamanho do vetor? ");
    scanf("%d",&tamanhoOriginal);
    inteiros = lerVetor(tamanhoOriginal);
    
    somados = somarVizinhosEmVetorDeInteiros(inteiros, tamanhoOriginal);
    
    printf("\nVizinhos somados:\n");
    imprimir(somados, definirTamanhoNovo(tamanhoOriginal));
    printf("\nFIM.\n");

    free(inteiros);
    free(somados);
    return 0;
}