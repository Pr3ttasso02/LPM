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

 /**
  * Demonstração do uso de objetos da classe Hora em um programa/app. 
  * Este programa nada mais faz além de testar algumas operações da classe (o que aprenderemos a fazer melhor posteriormente).
  */
public class HoraApp {
    
    public static void main(String[] args) {
        Hora hora = new Hora();
        Hora hora2 = new Hora();

        hora.ajustar((byte)22, (byte)33, (byte)45); 
        System.out.println(hora.hora+":"+hora.minuto+":"+hora.segundo);

        hora.incrementar((byte)12, 'm');
        System.out.println(hora.hora+":"+hora.minuto+":"+hora.segundo);
    
        hora.incrementar((byte)25, 'm');
        System.out.println(hora.hora+":"+hora.minuto+":"+hora.segundo);

        hora.incrementar((byte)55, 's');
        System.out.println(hora.hora+":"+hora.minuto+":"+hora.segundo);

        hora.incrementar((byte)4, 'h');
        System.out.println(hora.hora+":"+hora.minuto+":"+hora.segundo);

        hora.ajustar((byte)22, (byte)33, (byte)45); 
        System.out.println(hora.estahNaFrenteDe(hora2));

        System.out.println(hora2.estahNaFrenteDe(hora));

        hora.ajustar((byte)27, (byte)33, (byte)45);
        System.out.println(hora.hora+":"+hora.minuto+":"+hora.segundo);
    }
}
