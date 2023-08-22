import java.util.Scanner;

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

public class Basico04 {

    final int TAMANHO_MAX = 100;

    /**
     * Inverte uma frase (string) recebida por parâmetro.
     * @param frase Uma string com a frase a ser invertida. Pode ser vazia
     * @return A frase invertida em uma nova String
     */
    static String inverter(String frase) {

        String outra = "";
        
        int tamanho = frase.length();
        for (int i = tamanho - 1; i >= 0; i--) {
            outra += frase.charAt(i);
        }
        return outra;
    }

    static String lerFrase(Scanner teclado) {
        String aux;
        System.out.print("Digite uma frase de até 100 caracteres ou 'fim' para terminar: ");
        aux = teclado.nextLine();
        return aux;
    }

    public static void main(String[] args) {

        String frase;
        Scanner teclado = new Scanner(System.in);

        frase = lerFrase(teclado);
        while (!frase.toLowerCase().equals("fim")) {
            frase = inverter(frase);
            System.out.println("Invertida: " + frase);
            frase = lerFrase(teclado);
        }
        teclado.close();
    }

}
