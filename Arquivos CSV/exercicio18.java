import com.opencsv.CSVReader;
import java.io.FileReader;
import java.io.IOException;

public class LerCSV {
    public static void main(String[] args) {
        String nomeArquivo = "alunos.csv";

        try (CSVReader reader = new CSVReader(new FileReader(nomeArquivo))) {
            String[] linha;
            System.out.println("Conteúdo do arquivo CSV:");

            while ((linha = reader.readNext()) != null) {
                for (String coluna : linha) {
                    System.out.print(coluna + " ");
                }
                System.out.println(); // Pular para a próxima linha
            }
        } catch (IOException e) {
            System.out.println("Erro ao ler o arquivo CSV: " + e.getMessage());
        }
    }
}
