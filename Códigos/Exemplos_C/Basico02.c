int * somarVizinhosEmVetorDeInteiros(int[] vet){
        int tamanhoNovoVetor = (vet.length/2)+1;  //assume que é um vetor de tamanho ímpar
        int ultimoValor = vet[vet.length-1];
     
        int[] novoVetor = new int[tamanhoNovoVetor];

        for (int i = 0; i < vet.length-1; i+=2) {
            novoVetor[i/2] = vet[i]+vet[i+1];
        }

        if(vet.length%2==1){ //se for tamanho ímpar, guarda a soma do último consigo
            novoVetor[tamanhoNovoVetor-1] = ultimoValor+ultimoValor;          
        }
        else{
            novoVetor = Arrays.copyOf(novoVetor, tamanhoNovoVetor-1);  //senão, descarta a última posição do novo vetor, em caso de tamanho par
        }
        return novoVetor;
    }

int main(void){

    return 0;
}