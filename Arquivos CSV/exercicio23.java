import com.opencsv.CSVReader;
import com.opencsv.CSVWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Produto {
    private String nome;
    private double preco;
    private int quantidade;

    public Produto(String nome, double preco, int quantidade) {
        this.nome = nome;
        this.preco = preco;
        this.quantidade = quantidade;
    }

    public String getNome() {
        return nome;
    }

    public double getPreco() {
        return preco;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    @Override
    public String toString() {
        return "Nome: " + nome + ", Preço: R$" + preco + ", Quantidade: " + quantidade;
    }
}

public class GerenciarProdutosCSV {
    public static void main(String[] args) {
        String nomeArquivo = "produtos.csv";

        try (CSVReader reader = new CSVReader(new FileReader(nomeArquivo))) {
            List<Produto> produtos = new ArrayList<>();
            String[] linha;

            // Ler e armazenar os produtos do arquivo CSV
            while ((linha = reader.readNext()) != null) {
                String nome = linha[0];
                double preco = Double.parseDouble(linha[1]);
                int quantidade = Integer.parseInt(linha[2]);
                Produto produto = new Produto(nome, preco, quantidade);
                produtos.add(produto);
            }

            // Solicitar ao usuário o nome do produto a ser excluído
            Scanner scanner = new Scanner(System.in);
            System.out.print("Digite o nome do produto a ser excluído: ");
            String nomeProduto = scanner.nextLine();

            // Excluir o produto se encontrado
            boolean excluido = false;
            for (Produto produto : produtos) {
                if (produto.getNome().equalsIgnoreCase(nomeProduto)) {
                    System.out.println("Produto encontrado:");
                    System.out.println(produto);

                    System.out.print("Deseja realmente excluir este produto? (S/N): ");
                    String confirmacao = scanner.nextLine();
                    if (confirmacao.equalsIgnoreCase("S")) {
                        produtos.remove(produto);
                        excluido = true;
                        System.out.println("Produto excluído do arquivo.");
                    }
                    break;
                }
            }

            // Se o produto não foi encontrado, exibir mensagem
            if (!excluido) {
                System.out.println("Produto não encontrado ou não foi excluído.");
            }

            // Atualizar o arquivo CSV com as informações atualizadas dos produtos
            try (CSVWriter writer = new CSVWriter(new FileWriter(nomeArquivo))) {
                writer.writeNext(new String[]{"Nome", "Preço", "Quantidade"}); // Escrever cabeçalho

                for (Produto produto : produtos) {
                    String[] novaLinha = {produto.getNome(), String.valueOf(produto.getPreco()), String.valueOf(produto.getQuantidade())};
                    writer.writeNext(novaLinha);
                }

                System.out.println("Arquivo CSV 'produtos.csv' atualizado com sucesso.");
            } catch (IOException e) {
                System.out.println("Erro ao atualizar o arquivo CSV: " + e.getMessage());
            }

        } catch (IOException e) {
            System.out.println("Erro ao ler o arquivo CSV: " + e.getMessage());
        }
    }
}
