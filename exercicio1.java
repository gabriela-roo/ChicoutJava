
package estudo.provajava;
import java.io.*;

public class App{
    public static void main(String[] args) {
    
                String nomeArquivo = "meuarquivo.txt";
                String mensagem = "Olá, mundo!";
        
                try (BufferedWriter bw = new BufferedWriter(new FileWriter(nomeArquivo))) {
                    bw.write(mensagem);
                    System.out.println("Arquivo criado com sucesso.");
                } catch (IOException e) {
                    System.err.println("Erro ao criar o arquivo: " + e.getMessage());
                }
            }
        }
        
