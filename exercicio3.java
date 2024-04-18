import java.io.FileWriter;
import java.io.PrintWriter;
import java.io.IOException;

public class AdicionarAoArquivoTexto {
    public static void main(String[] args) {
        String nomeArquivo = "meuarquivo.txt";
        String mensagemAdicional = "Isso é uma adição!";

        try {
            FileWriter arquivoEscrita = new FileWriter(nomeArquivo, true);
            PrintWriter gravarArquivo = new PrintWriter(arquivoEscrita);

            gravarArquivo.println(mensagemAdicional);

            gravarArquivo.close();
            System.out.println("Adição feita com sucesso em " + nomeArquivo);
        } catch (IOException e) {
            System.out.println("Erro ao adicionar ao arquivo: " + e.getMessage());
        }
    }
}
