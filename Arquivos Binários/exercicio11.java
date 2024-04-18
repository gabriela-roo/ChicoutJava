import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

class Pessoa implements Serializable {
    private String nome;
    private int idade;

    public Pessoa(String nome, int idade) {
        this.nome = nome;
        this.idade = idade;
    }

    public String getNome() {
        return nome;
    }

    public int getIdade() {
        return idade;
    }
}

public class SerializacaoPessoa {
    public static void main(String[] args) {
        Pessoa pessoa = new Pessoa("João", 30);

        try {
            FileOutputStream fileOut = new FileOutputStream("pessoa.dat");
            ObjectOutputStream objectOut = new ObjectOutputStream(fileOut);
            objectOut.writeObject(pessoa);
            objectOut.close();
            fileOut.close();
            System.out.println("Objeto Pessoa serializado em pessoa.dat");
        } catch (Exception e) {
            System.out.println("Erro ao serializar objeto: " + e.getMessage());
        }
    }
}
