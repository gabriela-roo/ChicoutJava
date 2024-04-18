import com.opencsv.CSVWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class CriarCSV {
    public static void main(String[] args) {
        String nomeArquivo = "funcionarios.csv";

        try (CSVWriter writer = new CSVWriter(new FileWriter(nomeArquivo))) {
            Scanner scanner = new Scanner(System.in);

            System.out.println("Digite os detalhes dos funcionários (nome, cargo, salário):");
            System.out.println("Para encerrar, digite 'fim'.");

            String[] header = {"Nome", "Cargo", "Salário"};
            writer.writeNext(header);

            String[] funcionario;
            while (true) {
                System.out.print("Funcionário (ou 'fim' para encerrar): ");
                String entrada = scanner.nextLine();
                if (entrada.equalsIgnoreCase("fim")) {
                    break;
                }

                funcionario = entrada.split(",");
                if (funcionario.length != 3) {
                    System.out.println("Formato inválido. Use o formato 'nome,cargo,salário'.");
                    continue;
                }

                writer.writeNext(funcionario);
            }

            System.out.println("Arquivo CSV 'funcionarios.csv' criado com sucesso!");
        } catch (IOException e) {
            System.out.println("Erro ao criar o arquivo CSV: " + e.getMessage());
        }
    }
}
