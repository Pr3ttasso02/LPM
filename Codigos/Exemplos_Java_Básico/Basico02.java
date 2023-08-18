/** 
 * MIT License
 *
 * Copyright(c) 2022 João Caram <caram@pucminas.br>
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */

import java.util.Arrays;
import java.util.Scanner;

public class Basico02 {
    static Scanner teclado;

    /**
     * Imprimte todo um vetor de números inteiros. Demonstra o uso do "for" iterável ("foreach")
     * @param vet O vetor a ser impresso
     */
    public static void imprimirVetorDeInteiros(int[] vet){
        for (int i : vet) {
            System.out.print(i + " - ");
        }
    }

    /**
     * Faz a leitura de um vetor de inteiros já criado.
     * @param vet O vetor para ser preenchido
     */
    public static void lerVetorDeInteiros(int[] vet){
        for (int i = 0; i < vet.length; i++) {
            System.out.print("\nDigite o "+(i+1)+" número: ");
            vet[i] = Integer.parseInt(teclado.nextLine());
        }
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
    public static void main(String[] args) {
        teclado = new Scanner(System.in);
        int[] valores = new int[5];
        

        lerVetorDeInteiros(valores);  //para testes 1 e 2 
        int[] vetorSomado = somarVizinhosEmVetorDeInteiros(valores);
        imprimirVetorDeInteiros(vetorSomado);
        teclado.close();
    }
}
