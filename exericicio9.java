import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class ContarPalavras {
    public static void main(String[] args) {
        String nomeArquivo = "meuarquivo.txt";
        String palavraBuscada = "Java";
        int contagem = 0;

        try {
            FileReader arquivoLeitura = new FileReader(nomeArquivo);
            BufferedReader lerArquivo = new BufferedReader(arquivoLeitura);

            String linha;
            while ((linha = lerArquivo.readLine()) != null) {
                String[] palavras = linha.split("\\s+"); // Divide a linha em palavras usando espaços como delimitador
                for (String palavra : palavras) {
                    if (palavra.equals(palavraBuscada)) {
                        contagem++;
                    }
                }
            }

            lerArquivo.close();
            System.out.println("A palavra \"" + palavraBuscada + "\" aparece " + contagem + " vezes no texto.");
        } catch (IOException e) {
            System.out.println("Erro ao ler o arquivo: " + e.getMessage());
        }
    }
}
