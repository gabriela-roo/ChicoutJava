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

public class AtualizarProdutosCSV {
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

            
            Scanner scanner = new Scanner(System.in);
            System.out.print("Digite o nome do produto a ser atualizado: ");
            String nomeProduto = scanner.nextLine();

            // Pesquisar e atualizar o produto se encontrado
            boolean encontrado = false;
            for (Produto produto : produtos) {
                if (produto.getNome().equalsIgnoreCase(nomeProduto)) {
                    System.out.println("Produto encontrado:");
                    System.out.println(produto);

                    System.out.print("Novo preço: ");
                    double novoPreco = scanner.nextDouble();
                    scanner.nextLine(); 

                    System.out.print("Nova quantidade: ");
                    int novaQuantidade = scanner.nextInt();
                    scanner.nextLine(); 

                    produto.setPreco(novoPreco);
                    produto.setQuantidade(novaQuantidade);

                    encontrado = true;
                    break;
                }
            }

            // Se o produto não foi encontrado, exibir mensagem
            if (!encontrado) {
                System.out.println("Produto não encontrado.");
            }

            try (CSVWriter writer = new CSVWriter(new FileWriter(nomeArquivo))) {
                writer.writeNext(new String[]{"Nome", "Preço", "Quantidade"}); 

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
