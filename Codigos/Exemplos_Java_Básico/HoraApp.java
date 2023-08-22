/** 
 * MIT License
 *
 * Copyright(c) 2023 João Caram <caram@pucminas.br>
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

 /**
  * Demonstração do uso de objetos da classe Hora em um programa/app. 
  * Este programa nada mais faz além de testar algumas operações da classe (o que aprenderemos a fazer melhor posteriormente).
  */
public class HoraApp {
    
    public static void main(String[] args) {
        Hora hora1 = new Hora();
        Hora hora2 = new Hora();

        hora1.ajustar((byte)22, (byte)33, (byte)45);
        System.out.print("Hora 1: ");
        System.out.println(hora1.horaFormatada());

        hora1.incrementar((byte)12, 'm');
        System.out.print("Hora 1: ");
        System.out.println(hora1.horaFormatada());
    
        hora1.incrementar((byte)25, 'm');
        System.out.print("Hora 1: ");
        System.out.println(hora1.horaFormatada());
        
        hora1.incrementar((byte)55, 's');
        System.out.print("Hora 1: ");
        System.out.println(hora1.horaFormatada());

        hora1.incrementar((byte)4, 'h');
        System.out.print("Hora 1: ");
        System.out.println(hora1.horaFormatada());

        hora1.ajustar((byte)22, (byte)33, (byte)45); 
        System.out.print("Hora 1: ");
        System.out.println(hora1.horaFormatada());

        System.out.print("Hora 2: ");
        System.out.println(hora2.horaFormatada());
        
        System.out.print("Hora 1 está na frente de hora 2? ");
        System.out.println(hora1.estahNaFrenteDe(hora2));

        System.out.print("Hora 2 está na frente de hora 1? ");
        System.out.println(hora2.estahNaFrenteDe(hora1));

        hora1.ajustar((byte)27, (byte)33, (byte)45);
        System.out.print("Hora 1 ajustada para 27:33:45: ");
        System.out.println(hora1.horaFormatada());
    }
}
