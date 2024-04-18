import java.io.*;

class Funcionario {
    private String nome;
    private int idade;
    private String cargo;

    public Funcionario(String nome, int idade, String cargo) {
        this.nome = nome;
        this.idade = idade;
        this.cargo = cargo;
    }

    public String getNome() {
        return nome;
    }

    public int getIdade() {
        return idade;
    }

    public String getCargo() {
        return cargo;
    }

    public void salvar(RandomAccessFile file) throws IOException {
        file.writeUTF(nome);
        file.writeInt(idade);
        file.writeUTF(cargo);
    }

    public static Funcionario ler(RandomAccessFile file) throws IOException {
        String nome = file.readUTF();
        int idade = file.readInt();
        String cargo = file.readUTF();
        return new Funcionario(nome, idade, cargo);
    }

    @Override
    public String toString() {
        return "Nome: " + nome + ", Idade: " + idade + ", Cargo: " + cargo;
    }
}

public class GerenciamentoFuncionarios {
    public static void main(String[] args) {
        String nomeArquivo = "funcionarios.bin";

        try (RandomAccessFile file = new RandomAccessFile(nomeArquivo, "rw")) {
            // Adicionar funcionários ao arquivo
            Funcionario funcionario1 = new Funcionario("João", 30, "Analista");
            Funcionario funcionario2 = new Funcionario("Maria", 25, "Programador");

            funcionario1.salvar(file);
            funcionario2.salvar(file);

            // Ler e exibir funcionários do arquivo
            file.seek(0); // Voltar para o início do arquivo
            System.out.println("Funcionários no arquivo:");
            while (file.getFilePointer() < file.length()) {
                Funcionario funcionario = Funcionario.ler(file);
                System.out.println(funcionario);
            }

            // Atualizar funcionário no arquivo
            file.seek(0); // Voltar para o início do arquivo
            Funcionario funcionarioAtualizado = new Funcionario("Pedro", 35, "Gerente");
            funcionarioAtualizado.salvar(file);

            // Excluir funcionário do arquivo
            file.seek(0); // Voltar para o início do arquivo
            Funcionario funcionarioExcluido = Funcionario.ler(file); // Ler o primeiro funcionário
            file.setLength(file.length() - 34); // Excluir o primeiro registro (34 bytes: 2 UTF + 4 Int)

            // Exibir funcionários após exclusão
            file.seek(0); // Voltar para o início do arquivo
            System.out.println("Funcionários após exclusão:");
            while (file.getFilePointer() < file.length()) {
                Funcionario funcionario = Funcionario.ler(file);
                System.out.println(funcionario);
            }
        } catch (IOException e) {
            System.out.println("Erro ao manipular arquivo: " + e.getMessage());
        }
    }
}
