import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

public class Arquivos10 {
    static Scanner leitor;
    static String nomeArquivo = "numeros";
    
    /**
     * Cria um vetor de inteiros a partir de uma linha CSV como 1;2;3;4.
     * @param linha Linha CSV com valores inteiros no formato valor;valor;valor
     * @return Vetor de inteiros criado a partir da linha
     */
    static int[] criarVetorDeInteiros(String linha){
        String[] valores = linha.split(";");
        int[] vet = new int[valores.length];
        for (int i = 0; i < vet.length; i++) {
            vet[i] = Integer.parseInt(valores[i]);
        }
        return vet;
    }

    /**
     * Cria um vetor de inteiros a partir da soma dos vizinhos de um vetor original.
     * Caso o vetor tenha tamanho ímpar, o último valor será somado consigo mesmo. Por
     * exemplo, um vetor | 3 | 4 | 5 | 6 |  retorna outro | 7 | 11 |. Um vetor | 3 | 4 | 5| retorna outro | 7 | 10 |. 
     * @param vet O vetor original contendo os vizinhos para somar. Pode ser de qualquer tamanho
     * @return Um novo vetor com os vizinhos somados como descrito anteriormente.
     */
    public static int[] somarVizinhosEmVetorDeInteiros(int[] vet){
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

    /**
     * Imprime todo um vetor de números inteiros. Demonstra o uso do "for" iterável ("foreach")
     * @param vet O vetor a ser impresso
     */
    public static void imprimirVetorDeInteiros(int[] vet){
        System.out.print("| ");
        for (int i : vet) {
            System.out.print(i + " | ");
        }
    }

    public static void main(String[] args) throws FileNotFoundException {
         leitor= new Scanner(new File(nomeArquivo));
        int[] vetor;
        while(leitor.hasNextLine()){
            String linha = leitor.nextLine();
           
            vetor = criarVetorDeInteiros(linha);            //usando método utilitário
            
            System.out.print("\nVetor original: ");
            imprimirVetorDeInteiros(vetor);

            vetor = somarVizinhosEmVetorDeInteiros(vetor);  //mesma ação do exercício 2
            System.out.print("\nVetor criado:  ");
            imprimirVetorDeInteiros(vetor);
            System.out.print("\n----------------");
        }
        leitor.close();    
    }
    
}
