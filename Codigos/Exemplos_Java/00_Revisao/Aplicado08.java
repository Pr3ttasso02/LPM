import java.util.Scanner;

public class Aplicado08 {

    //#region Variáveis/atributos
    
    /**
     * Para leitura via teclado em todo o app.
     */
    static Scanner teclado;

    /**
     * Vetor contendo o máximo de dias possíveis em cada mês.
     * Note que o mês 0 está atribuído com 0 dias - ou seja, usamos a posição 1 para
     * o mês de janeiro e assim por diante.
     */
    static int[] DIASDOMES = {0, 31, 28, 31, 30, 31, 30, 
        31, 31, 30, 31, 30, 31 };

    //#endregion

    //#region Utilidades

    /**
     * "Limpa" a tela (códigos de terminal VT-100)
     */
    public static void limparTela() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
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

    //#endregion

    //#region Solução
    /**
     * Verifica a validade de uma data no formato DD/MM/AAAA. Retorna uma string informando se a data é válida ou 
     * onde ela encontra-se errada. 
     * As datas consideradas válidas se iniciam em 01/01/1900.
     * O método ainda não é protegido contra erros de formatação (p.ex, letras em lugar de números) e, assim, pode
     * lançar exceção
     * @param data String DD/MM/AAAA com a data a verificar.
     * @return String com informação da validação. As respostas possíveis são:
     * <ul>
     * <li> "Data válida." para data válida </li>
     * <li> "Data em formato incorreto." para casos diferentes de DD/MM/AAAA </li>
     * <li> "Ano inválido: só de 1900 em diante." para anos anteriores a 1900 </li>
     * <li> "Mês inválido: só de 1 a 12." para meses menores que 1 ou maiores que 12 </li>
     * <li> "Dia inválido: máximo de DD para o mês MM." para erro de dia no mês correspondente (p.ex, 31/04)</li>
     * </ul>
     * @throws NumberFormatException Em caso de dígitos não numéricos na data.
     */
    public static String dataValida(String data){
        String resposta="Data válida.";
        
        String[] detalhes = data.split("/");
        if(detalhes.length!=3 || data.length()!=10)
            return "Data em formato incorreto.";

        int dia = Integer.parseInt(detalhes[0]);    
        int mes = Integer.parseInt(detalhes[1]);
        int ano = Integer.parseInt(detalhes[2]);
        int maxDia;
        
        if(ano<1900)
            resposta =  "Ano inválido: só de 1900 em diante.";
        else{
           if (mes < 1 || mes > 12)                           //mês<1 ou mês>12 --> data inválida
                resposta =  "Mês inválido: só de 1 a 12.";
           else { 
                   maxDia = DIASDOMES[mes];
                   if(anoBissexto(ano)&&mes==2)     //para fevereiro de bissextos...
                        maxDia++;
                   
                   if (dia > maxDia)                //verifica validade de acordo com o mês atual
                        resposta =  "Dia inválido: máximo de "+maxDia+" para o mês "+mes+".";
                }
        }                       
        return resposta;
    }

    /**
     * Verificação de ano bissexto. Retorna verdadeiro ou falso.
     * @param ano Ano a ser verificado.
     * @return true para ano bissexto, false caso contrário.
     */
    public static boolean anoBissexto(int ano){
        boolean resposta = false;
        if(ano%400==0) 
              resposta = true;
        else if(ano%4==0 && ano%100!=0)
              resposta = true;
        
        return resposta;
    }

    //#endregion

    public static void main(String[] args) {
        teclado = new Scanner(System.in);
        String data = leitura("Digite uma data no formato DD/MM/AAAA");
        System.out.println(dataValida(data));
        teclado.close();
    }

    
   
   

}