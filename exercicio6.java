import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class LerArquivoCSV {
    public static void main(String[] args) {
        String nomeArquivo = "dados.csv";

        try {
            FileReader arquivoLeitura = new FileReader(nomeArquivo);
            BufferedReader lerArquivo = new BufferedReader(arquivoLeitura);

            String linha;
            while ((linha = lerArquivo.readLine()) != null) {
                String[] campos = linha.split(",");
                for (String campo : campos) {
                    System.out.print(campo + " | ");
                }
                System.out.println(); // Pula para a próxima linha no console
            }

            lerArquivo.close();
        } catch (IOException e) {
            System.out.println("Erro ao ler o arquivo: " + e.getMessage());
        }
    }
}
