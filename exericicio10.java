import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class ConcatenarArquivos {
    public static void main(String[] args) {
        String nomeArquivo1 = "arquivo1.txt";
        String nomeArquivo2 = "arquivo2.txt";
        String nomeArquivoConcatenado = "arquivo_concatenado.txt";

        // Criar conteúdo para os dois arquivos
        String conteudoArquivo1 = "Conteúdo do arquivo 1.";
        String conteudoArquivo2 = "Conteúdo do arquivo 2.";

        try {
            // Escrever no arquivo 1
            FileWriter arquivoEscrita1 = new FileWriter(nomeArquivo1);
            BufferedWriter gravarArquivo1 = new BufferedWriter(arquivoEscrita1);
            gravarArquivo1.write(conteudoArquivo1);
            gravarArquivo1.close();

            // Escrever no arquivo 2
            FileWriter arquivoEscrita2 = new FileWriter(nomeArquivo2);
            BufferedWriter gravarArquivo2 = new BufferedWriter(arquivoEscrita2);
            gravarArquivo2.write(conteudoArquivo2);
            gravarArquivo2.close();

            // Concatenar os conteúdos dos arquivos 1 e 2
            FileReader arquivoLeitura1 = new FileReader(nomeArquivo1);
            BufferedReader lerArquivo1 = new BufferedReader(arquivoLeitura1);
            FileReader arquivoLeitura2 = new FileReader(nomeArquivo2);
            BufferedReader lerArquivo2 = new BufferedReader(arquivoLeitura2);

            FileWriter arquivoConcatenado = new FileWriter(nomeArquivoConcatenado);
            BufferedWriter gravarArquivoConcatenado = new BufferedWriter(arquivoConcatenado);

            String linha;
            while ((linha = lerArquivo1.readLine()) != null) {
                gravarArquivoConcatenado.write(linha + "\n");
            }

            while ((linha = lerArquivo2.readLine()) != null) {
                gravarArquivoConcatenado.write(linha + "\n");
            }

            lerArquivo1.close();
            lerArquivo2.close();
            gravarArquivoConcatenado.close();

            System.out.println("Arquivos concatenados com sucesso em " + nomeArquivoConcatenado);
        } catch (IOException e) {
            System.out.println("Erro ao manipular arquivos: " + e.getMessage());
        }
    }
}
