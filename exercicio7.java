import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class OrdenarLinhas {
    public static void main(String[] args) {
        String nomeArquivoEntrada = "meuarquivo.txt";
        String nomeArquivoSaida = "meuarquivo_ordenado.txt";
        List<String> linhas = new ArrayList<>();

        try {
            FileReader arquivoLeitura = new FileReader(nomeArquivoEntrada);
            BufferedReader lerArquivo = new BufferedReader(arquivoLeitura);

            String linha;
            while ((linha = lerArquivo.readLine()) != null) {
                linhas.add(linha);
            }

            lerArquivo.close();

            Collections.sort(linhas);

            FileWriter arquivoEscrita = new FileWriter(nomeArquivoSaida);
            PrintWriter gravarArquivo = new PrintWriter(arquivoEscrita);

            for (String linhaOrdenada : linhas) {
                gravarArquivo.println(linhaOrdenada);
            }

            gravarArquivo.close();
            System.out.println("Linhas ordenadas e salvas em " + nomeArquivoSaida);
        } catch (IOException e) {
            System.out.println("Erro ao processar o arquivo: " + e.getMessage());
        }
    }
}
