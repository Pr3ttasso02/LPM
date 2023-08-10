#include <stdio.h>
#include <string.h>

const int TAMANHO_MAX = 100;

void inverter(char frase[]) {
  
  char letra;
  int tamanho = strlen(frase);
  for(int i=0; i<(tamanho/2) ;i++){
    letra = frase[i];
    frase[i] = frase[tamanho-i-1];
    frase[tamanho-i-1] = letra;
  }
  
}

void lerFrase(char * frase){
  printf("Digite uma frase de até 100 caracteres ou 'fim' para terminar: ");
  fgets(frase, TAMANHO_MAX, stdin); //fgets é mais seguro que gets e mais completo que scanf
  frase[strlen(frase)-1]='\0';    //serve para tirar o \n da frase
}

int main() {
  int num=0;
  char * frase;
  
  lerFrase(frase);
  while(strcmp(frase, "fim")!=0){
     inverter(frase);
     printf("Invertida: %s\n", frase);
     lerFrase(frase);
  }
    
}
