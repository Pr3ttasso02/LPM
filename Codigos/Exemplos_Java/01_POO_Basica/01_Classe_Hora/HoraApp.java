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

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
  * Demonstração do uso de objetos da classe Hora em um programa/app. 
  * Este programa nada mais faz além de testar algumas operações da classe (o que aprenderemos a fazer melhor posteriormente).
  */
public class HoraApp {
    
    //#region utilidades
    static Scanner teclado;
     /**
     * "Limpa" a tela (códigos de terminal VT-100)
     */
    public static void limparTela() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

     /**
     * Pausa para leitura de mensagens em console
     * 
     * @param teclado Scanner de leitura
     */
    static void pausa() {
        System.out.println("Enter para continuar.");
        teclado.nextLine();
    }

    /**
     * Encapsula uma leitura de teclado, com mensagem personalizada. A mensagem sempre é completada com ":". Retorna uma string 
     * que pode ser posteriormente convertida.
     * @param mensagem A mensagem a ser exibida, sem pontuação final.
     * @return String lida do usuário.
     */
    public static String leitura(String mensagem){
        System.out.print("\n"+mensagem+": ");
        return teclado.nextLine();
    }

    /**
     * Método para montagem de menu. Lê as opções de um arquivo e as numera automaticamente a partir de 1.
     * @param nomeArquivo Nome do arquivo texto com as opções (uma por linha)
     * @return Opção do usuário (int)
     * @throws FileNotFoundException em caso de arquivo não encontrado.
     */
    public static int menu(String nomeArquivo) throws FileNotFoundException {
        limparTela();
        File arqMenu = new File(nomeArquivo);
        Scanner leitor = new Scanner(arqMenu, "UTF-8");
        System.out.println(leitor.nextLine());
        System.out.println("==========================");
        int contador = 1;
        while(leitor.hasNextLine()){
            System.out.println(contador + " - " + leitor.nextLine());
            contador++;
        }
        System.out.println("0 - Sair");
        System.out.print("\nSua opção: ");
        int opcao = Integer.parseInt(teclado.nextLine());
        leitor.close();
        return opcao;
    }

    /**
     * Encapsula o processo de incrementar hora: lê do usuário o componente desejado (hora/minuto/segundo) e
     * a quantidade a incrementar, chama o incremento e imprime a hora com os novos dados
     * @param hora Hora a ser modificada
     */
    static void incrementarHora(Hora hora){
        Character posicao = leitura("Escolha hora(h), minuto(m) ou segundo(s) para incrementar").charAt(0);
        byte quantos = Byte.parseByte(leitura("Quantidade de unidades a acrescentar"));
        hora.incrementar(quantos, posicao);
    }

    /**
     * Encapsula o processo de ajustar hora: lê do usuário uma hora no formato HH:MM:SS e
     *  chama o ajuste. No final, imprime a hora com os novos dados
     * @param hora Hora a ser modificada
     */
    static void ajustarHora(Hora hora){
            String horas = leitura("Digite a hora no formato HH:MM:SS");
            String[] detalhes = horas.split(":");
            hora.ajustar(Byte.parseByte(detalhes[0]), Byte.parseByte(detalhes[1]), Byte.parseByte(detalhes[2]));
    }

    public static void main(String[] args) throws Exception{
        teclado = new Scanner(System.in);
        String nomeArq = "menuHora";
        int opcao = -1;
        Hora hora = new Hora();
        while(opcao!=0){
            limparTela();
            opcao = menu(nomeArq);
            switch(opcao){
                case 1 -> hora = new Hora();
                case 2 -> incrementarHora(hora);
                case 3 -> ajustarHora(hora);
                case 4 -> { } // não faz nada, pois o sistema sempre imprime a hora depois do switch
            }
            System.out.println("Hora atual: "+hora.horaFormatada());
            pausa();
        }

        teclado.close();
    }
}
