# Laboratório de Programação Modular

Repositório de conteúdo da disciplina Laboratório de Programação Modular. Ênfase nos códigos utilizados na disciplina e guias de solução de exemplos/exercícios.
DESAFIO #3:

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class SomaVizinhos {

    public static int[] somaVizinhos(int[] vetor) {
        int tamanho = vetor.length;
        int[] vetorSoma = new int[(tamanho + 1) / 2];

        for (int i = 0; i < tamanho; i += 2) {
            if (i + 1 < tamanho) {
                vetorSoma[i / 2] = vetor[i] + vetor[i + 1];
            } else {
                vetorSoma[i / 2] = vetor[i] * 2; // Último número somado consigo mesmo se ímpar
            }
        }

        return vetorSoma;
    }

    public static List<int[]> lerVetoresDeArquivo(String nomeArquivo) throws IOException {
        List<int[]> vetores = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(nomeArquivo))) {
            String linha;
            while ((linha = br.readLine()) != null) {
                String[] valores = linha.split(";");
                int[] vetor = new int[valores.length];
                for (int i = 0; i < valores.length; i++) {
                    vetor[i] = Integer.parseInt(valores[i]);
                }
                vetores.add(vetor);
            }
        }

        return vetores;
    }

    public static void main(String[] args) {
        String nomeArquivo = "vetores.txt";

        try {
            List<int[]> vetores = lerVetoresDeArquivo(nomeArquivo);

            for (int[] vetor : vetores) {
                int[] resultado = somaVizinhos(vetor);
                System.out.println("Vetor original:");
                for (int valor : vetor) {
                    System.out.print(valor + " ");
                }
                System.out.println("\nVetor com a soma de vizinhos:");
                for (int valor : resultado) {
                    System.out.print(valor + " ");
                }
                System.out.println("\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}  


ArquivoData;

import java.util.Calendar;

public class Data {
    private int dia;
    private int mes;
    private int ano;

    public Data(int dia, int mes, int ano) {
        Calendar calendar = Calendar.getInstance();
        calendar.setLenient(false); // Evita que datas inválidas sejam aceitas
        calendar.set(Calendar.YEAR, ano);
        calendar.set(Calendar.MONTH, mes - 1); // Mês começa de 0 em Calendar
        calendar.set(Calendar.DAY_OF_MONTH, dia);

        // Verifica se a data é válida, caso contrário, reverter para 01/01/1900
        try {
            calendar.getTime(); // Vai lançar uma exceção para datas inválidas
            this.dia = dia;
            this.mes = mes;
            this.ano = ano;
        } catch (Exception e) {
            this.dia = 1;
            this.mes = 1;
            this.ano = 1900;
        }
    }

}

