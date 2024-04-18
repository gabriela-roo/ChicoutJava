import com.opencsv.CSVWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

class Venda {
    private String data;
    private double valor;
    private String produto;

    public Venda(String data, double valor, String produto) {
        this.data = data;
        this.valor = valor;
        this.produto = produto;
    }

    public String getData() {
        return data;
    }

    public double getValor() {
        return valor;
    }

    public String getProduto() {
        return produto;
    }
}

public class ExportarVendasCSV {
    public static void main(String[] args) {
        List<Venda> vendas = new ArrayList<>();
        vendas.add(new Venda("2024-04-22", 150.0, "Produto A"));
        vendas.add(new Venda("2024-04-23", 200.0, "Produto B"));
        vendas.add(new Venda("2024-04-24", 180.0, "Produto C"));

        String nomeArquivo = "vendas.csv";

        try (CSVWriter writer = new CSVWriter(new FileWriter(nomeArquivo))) {
            String[] header = {"Data", "Valor", "Produto"};
            writer.writeNext(header);

            for (Venda venda : vendas) {
                String[] linha = {venda.getData(), String.valueOf(venda.getValor()), venda.getProduto()};
                writer.writeNext(linha);
            }

            System.out.println("Vendas exportadas para o arquivo CSV 'vendas.csv' com sucesso.");
        } catch (IOException e) {
            System.out.println("Erro ao exportar as vendas para o arquivo CSV: " + e.getMessage());
        }
    }
}
