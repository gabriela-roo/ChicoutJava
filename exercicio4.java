import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class ContarLinhasArquivo {
    public static void main(String[] args) {
        String nomeArquivo = "meuarquivo.txt";
        int totalLinhas = 0;

        try {
            FileReader arquivoLeitura = new FileReader(nomeArquivo);
            BufferedReader lerArquivo = new BufferedReader(arquivoLeitura);

            while (lerArquivo.readLine() != null) {
                totalLinhas++;
            }

            lerArquivo.close();
            System.out.println("O arquivo \"" + nomeArquivo + "\" possui " + totalLinhas + " linhas.");
        } catch (IOException e) {
            System.out.println("Erro ao ler o arquivo: " + e.getMessage());
        }
    }
}
