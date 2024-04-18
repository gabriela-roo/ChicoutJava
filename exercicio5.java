import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.io.IOException;

public class SubstituirPalavra {
    public static void main(String[] args) {
        String nomeArquivoEntrada = "meuarquivo.txt";
        String nomeArquivoSaida = "meuarquivo_python.txt";

        try {
            FileReader arquivoLeitura = new FileReader(nomeArquivoEntrada);
            BufferedReader lerArquivo = new BufferedReader(arquivoLeitura);

            FileWriter arquivoEscrita = new FileWriter(nomeArquivoSaida);
            PrintWriter gravarArquivo = new PrintWriter(arquivoEscrita);

            String linha;
            while ((linha = lerArquivo.readLine()) != null) {
                String linhaSubstituida = linha.replaceAll("Java", "Python");
                gravarArquivo.println(linhaSubstituida);
            }

            lerArquivo.close();
            gravarArquivo.close();
            System.out.println("Substituição concluída. Resultado salvo em " + nomeArquivoSaida);
        } catch (IOException e) {
            System.out.println("Erro ao processar o arquivo: " + e.getMessage());
        }
    }
}
