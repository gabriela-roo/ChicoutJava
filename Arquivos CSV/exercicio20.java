import com.opencsv.CSVReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

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

    @Override
    public String toString() {
        return "Nome: " + nome + ", Preço: R$" + preco + ", Quantidade: " + quantidade;
    }
}

public class LerCSVProdutos {
    public static void main(String[] args) {
        String nomeArquivo = "produtos.csv";
        List<Produto> produtos = new ArrayList<>();

        try (CSVReader reader = new CSVReader(new FileReader(nomeArquivo))) {
            String[] linha;
            reader.readNext(); // Ignorar cabeçalho

            while ((linha = reader.readNext()) != null) {
                String nome = linha[0];
                double preco = Double.parseDouble(linha[1]);
                int quantidade = Integer.parseInt(linha[2]);

                Produto produto = new Produto(nome, preco, quantidade);
                produtos.add(produto);
            }

            System.out.println("Detalhes dos produtos:");
            for (Produto produto : produtos) {
                System.out.println(produto);
            }
        } catch (IOException e) {
            System.out.println("Erro ao ler o arquivo CSV: " + e.getMessage());
        }
    }
}
