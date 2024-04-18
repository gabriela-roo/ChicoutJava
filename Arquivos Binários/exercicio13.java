import java.io.*;
import java.util.ArrayList;
import java.util.List;

class Produto implements Serializable {
    private String nome;
    private double preco;

    public Produto(String nome, double preco) {
        this.nome = nome;
        this.preco = preco;
    }

    public String getNome() {
        return nome;
    }

    public double getPreco() {
        return preco;
    }
}

public class SerializacaoDeserializacaoLista {
    public static void main(String[] args) {
        List<Produto> listaProdutos = new ArrayList<>();
        listaProdutos.add(new Produto("Camisa", 29.99));
        listaProdutos.add(new Produto("Calça", 49.99));
        listaProdutos.add(new Produto("Tênis", 99.99));

        try {
            FileOutputStream fileOut = new FileOutputStream("produtos.dat");
            ObjectOutputStream objectOut = new ObjectOutputStream(fileOut);
            objectOut.writeObject(listaProdutos);
            objectOut.close();
            fileOut.close();
            System.out.println("Lista de produtos serializada em produtos.dat");

            FileInputStream fileIn = new FileInputStream("produtos.dat");
            ObjectInputStream objectIn = new ObjectInputStream(fileIn);
            List<Produto> listaDeserializada = (List<Produto>) objectIn.readObject();
            objectIn.close();
            fileIn.close();

            System.out.println("Produtos deserializados e exibidos:");
            for (Produto produto : listaDeserializada) {
                System.out.println("Nome: " + produto.getNome() + ", Preço: R$" + produto.getPreco());
            }
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Erro ao manipular arquivos: " + e.getMessage());
        }
    }
}
