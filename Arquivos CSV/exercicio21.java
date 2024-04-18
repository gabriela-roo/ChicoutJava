import com.opencsv.CSVWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class AdicionarProdutosCSV {
    public static void main(String[] args) {
        String nomeArquivo = "produtos.csv";

        try (CSVWriter writer = new CSVWriter(new FileWriter(nomeArquivo, true))) {
            Scanner scanner = new Scanner(System.in);

            System.out.println("Digite os detalhes dos produtos:");
            System.out.println("Para encerrar, deixe o nome em branco.");

            String nome, precoStr, quantidadeStr;
            while (true) {
                System.out.print("Nome do produto: ");
                nome = scanner.nextLine();
                if (nome.isEmpty()) {
                    break;
                }

                System.out.print("Preço: ");
                precoStr = scanner.nextLine();

                System.out.print("Quantidade: ");
                quantidadeStr = scanner.nextLine();

                String[] linha = {nome, precoStr, quantidadeStr};
                writer.writeNext(linha);

                System.out.println("Produto adicionado ao arquivo.");
            }

            System.out.println("Produtos adicionados ao arquivo CSV 'produtos.csv'.");
        } catch (IOException e) {
            System.out.println("Erro ao escrever no arquivo CSV: " + e.getMessage());
        }
    }
}
