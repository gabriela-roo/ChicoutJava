import com.opencsv.CSVReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Funcionario {
    private String nome;
    private String cargo;
    private double salario;

    public Funcionario(String nome, String cargo, double salario) {
        this.nome = nome;
        this.cargo = cargo;
        this.salario = salario;
    }

    public String getNome() {
        return nome;
    }

    public String getCargo() {
        return cargo;
    }

    public double getSalario() {
        return salario;
    }

    @Override
    public String toString() {
        return "Nome: " + nome + ", Cargo: " + cargo + ", Salário: R$" + salario;
    }
}

public class FiltrarFuncionariosCSV {
    public static void main(String[] args) {
        String nomeArquivo = "funcionarios.csv";

        try (CSVReader reader = new CSVReader(new FileReader(nomeArquivo))) {
            List<Funcionario> funcionarios = new ArrayList<>();
            String[] linha;

            // Ler e armazenar os funcionários do arquivo CSV
            while ((linha = reader.readNext()) != null) {
                String nome = linha[0];
                String cargo = linha[1];
                double salario = Double.parseDouble(linha[2]);
                Funcionario funcionario = new Funcionario(nome, cargo, salario);
                funcionarios.add(funcionario);
            }

            // Solicitar ao usuário o critério de filtro
            Scanner scanner = new Scanner(System.in);
            System.out.println("Filtrar funcionários por:");
            System.out.println("1. Cargo");
            System.out.println("2. Salário mínimo");

            System.out.print("Escolha a opção (1 ou 2): ");
            int opcao = scanner.nextInt();
            scanner.nextLine(); // Limpar o buffer após ler o int

            switch (opcao) {
                case 1:
                    System.out.print("Digite o cargo para filtrar: ");
                    String cargoFiltro = scanner.nextLine();
                    filtrarPorCargo(funcionarios, cargoFiltro);
                    break;
                case 2:
                    System.out.print("Digite o salário mínimo para filtrar: ");
                    double salarioMinimo = scanner.nextDouble();
                    scanner.nextLine(); // Limpar o buffer após ler o double
                    filtrarPorSalario(funcionarios, salarioMinimo);
                    break;
                default:
                    System.out.println("Opção inválida.");
            }

        } catch (IOException e) {
            System.out.println("Erro ao ler o arquivo CSV: " + e.getMessage());
        }
    }

    public static void filtrarPorCargo(List<Funcionario> funcionarios, String cargoFiltro) {
        System.out.println("Funcionários com cargo '" + cargoFiltro + "':");
        for (Funcionario funcionario : funcionarios) {
            if (funcionario.getCargo().equalsIgnoreCase(cargoFiltro)) {
                System.out.println(funcionario);
            }
        }
    }

    public static void filtrarPorSalario(List<Funcionario> funcionarios, double salarioMinimo) {
        System.out.println("Funcionários com salário mínimo de R$" + salarioMinimo + ":");
        for (Funcionario funcionario : funcionarios) {
            if (funcionario.getSalario() >= salarioMinimo) {
                System.out.println(funcionario);
            }
        }
    }
}
