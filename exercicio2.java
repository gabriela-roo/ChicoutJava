import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class LerArquivoTexto {
    public static void main(String[] args) {
        String nomeArquivo = "meuarquivo.txt";

        try {
            FileReader arquivoLeitura = new FileReader(nomeArquivo);
            BufferedReader lerArquivo = new BufferedReader(arquivoLeitura);

            String linha;
            while ((linha = lerArquivo.readLine()) != null) {
                System.out.println(linha);
            }

            lerArquivo.close();
        } catch (IOException e) {
            System.out.println("Erro ao ler o arquivo: " + e.getMessage());
        }
    }
}
