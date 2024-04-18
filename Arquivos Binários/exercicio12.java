import java.io.FileInputStream;
import java.io.ObjectInputStream;
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

public class DeserializacaoPessoa {
    public static void main(String[] args) {
        try {
            FileInputStream fileIn = new FileInputStream("pessoa.dat");
            ObjectInputStream objectIn = new ObjectInputStream(fileIn);
            Pessoa pessoa = (Pessoa) objectIn.readObject();
            objectIn.close();
            fileIn.close();

            System.out.println("Detalhes da pessoa:");
            System.out.println("Nome: " + pessoa.getNome());
            System.out.println("Idade: " + pessoa.getIdade());
        } catch (Exception e) {
            System.out.println("Erro ao deserializar objeto: " + e.getMessage());
        }
    }
}
