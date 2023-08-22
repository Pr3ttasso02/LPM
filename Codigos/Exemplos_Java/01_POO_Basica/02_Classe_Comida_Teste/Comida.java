import java.text.NumberFormat;

/** 
 * MIT License
 *
 * Copyright(c) 2022-2023 João Caram <caram@pucminas.br>
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

public class Comida {

    //#region Requisitos
        /**
         * No momento, só são vendidas duas comidas: Sanduíche ou Pizza.
         * Uma comida:
         *      - tem um preço inicial
         *      - tem uma quantidade máxima de adicionais
         *      - tem um preço por adicional
         *      - tem um preço total a pagar
         * 
         *                  |    SANDUICHE   |  PIZZA   |
         * INICIAL          |   R$13.00      | R$25.00  |
         * MAX. ADICIONAIS  |       5        |    8     |
         * PRECO ADICIONAL  |   R$2.00       |  R$4.00  |
         * 
         * PRECO TOTAL: inicial + (qtAdicionais)*(precoAdicional)
         * 
         */    
    //#endregion

    //#region Atributos
    
    private double valorBase;
    private String descricao;
    private int qtdAdicionais;
    private int maxAdicionais;
    private double valorAdicional;
    //#endregion

    //#region Construtores
    
    /**
     * Inicializador para encapsular o processo nos construtores. Recebe um tipo e uma quantidade de adicionais para a comida. Tipos possíveis são
     * "PIZZA" ou "SANDUICHE" e a quantidade de adicionais segue a regra do problema (respectivamente, máximos de 8 e 5). Em caso de tipo incorreto,
     * cria um sanduíche. Em caso de valor incorreto de adicionais, mantém em 0.
     * @param tipo
     * @param qtAdicionais
     */
    private void init(String tipo, int qtAdicionais){
        if(tipo.equals("PIZZA")){        
            this.valorBase = 25;
            this.descricao= "PIZZA";
            this.valorAdicional = 4;
            this.maxAdicionais = 8;
        }
        else{
            this.valorBase = 13;
            this.descricao = "SANDUICHE";
            this.valorAdicional = 2;
            this.maxAdicionais = 5;
        }
        this.qtdAdicionais = 0;
        this.adicionarIngredientes(qtAdicionais);
    }
    /**
     * Construtor da Comida sem nenhum adicional. Configura os valores para cada tipo de comida.
     * @param tipo String "PIZZA" ou "SANDUICHE". Parâmetro inválido cria um Sanduiche.
     */
    public Comida(String tipo) {
        tipo = tipo.toUpperCase();
        this.init(tipo, 0);
    }

    /**
     * Construtor da Comida com adicionais. Configura os valores para cada tipo de comida e verifica as regras:
     * máximo de 5 adicionais para sanduíche e 8 para pizza. Em caso de valores inválidos, coloca os adicionais como 0.
     * @param tipo String "pizza" ou "sanduíche". Parâmetro inválido cria um Sanduiche.
     * @param qtdAdicionais int Quantidade de adicionais na criação da comida, conforme regra acima.
     */
    public Comida(String tipo, int qtAdicionais) {
        tipo = tipo.toUpperCase();
        this.init(tipo, qtAdicionais);
    }

    //#endregion

    //#region Métodos de negócio
   
    /**
     * Preço final da comida, incluindo adicionais.
     * @return Double com o preço a pagar pela comida.
     */
    public double precoFinal() {
        return this.valorBase + (this.qtdAdicionais * this.valorAdicional);
    }

    /**
     * Tenta adicionar ingredientes à comida. Faz a validação de máximo (Sanduíche: 5, Pizza: 8) e 
     * não altera a quantidade em caso de verificação falsa. Retorna TRUE/FALSE conforme mudou ou não
     * a quantidade de ingredientes.
     * @param quantos Quantos ingredientes a adicionar.
     * @return TRUE se pôde adicionar os ingreientes, FALSE caso contrário.
     */
    public boolean adicionarIngredientes(int quantos) {
        boolean resposta = false;
        if(this.validarAdicionais(quantos)){
            this.qtdAdicionais += quantos;
            resposta = true;
        }
        return resposta;
    }

    /**
     * Valida a quantidade de adicionais conforme a regra. Método privado, para ser chamado pelo 'adicionarIngredientes'
     * @param quantos Quantos ingredientes a serem adicionados.
     * @return TRUE se é possível adicionar, FALSE caso contrário.
     */
    private boolean validarAdicionais(int quantos){
        int total = this.qtdAdicionais+quantos;
        return (total>=0 && total<=this.maxAdicionais);
     }

     /**
      * Relatório em string da comida. A primeira linha informa descrição e quantidade de adicionais, a segunda linha informa o preço a pagar.
      * @return String no formato:<pre>
      *XXXX COM N ADICIONAIS.
      *VALOR A PAGAR:  R$ XX,XX
      * </pre>
      */
    public String relatorio(){
        NumberFormat formatter = NumberFormat.getCurrencyInstance();
        
        StringBuilder relatorio = new StringBuilder(this.descricao);
        relatorio.append(" COM "+this.qtdAdicionais+" ADICIONAIS.\n");
        relatorio.append("VALOR A PAGAR: "+formatter.format(this.precoFinal()));
        
        return relatorio.toString();
    }
    //#endregion
}
