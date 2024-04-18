import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.io.IOException;

public class RemoverLinhas {
    public static void main(String[] args) {
        String nomeArquivoEntrada = "meuarquivo.txt";
        String nomeArquivoSaida = "meuarquivo_sem_excluir.txt";

        try {
            FileReader arquivoLeitura = new FileReader(nomeArquivoEntrada);
            BufferedReader lerArquivo = new BufferedReader(arquivoLeitura);

            FileWriter arquivoEscrita = new FileWriter(nomeArquivoSaida);
            PrintWriter gravarArquivo = new PrintWriter(arquivoEscrita);

            String linha;
            while ((linha = lerArquivo.readLine()) != null) {
                if (!linha.contains("excluir")) {
                    gravarArquivo.println(linha);
                }
            }

            lerArquivo.close();
            gravarArquivo.close();
            System.out.println("Linhas removidas e resultado salvo em " + nomeArquivoSaida);
        } catch (IOException e) {
            System.out.println("Erro ao processar o arquivo: " + e.getMessage());
        }
    }
}
