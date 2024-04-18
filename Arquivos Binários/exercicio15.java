import java.io.*;

public class CopiarArquivoBinario {
    public static void main(String[] args) {
        String arquivoOriginal = "arquivo_grande.bin";
        String arquivoCopia = "copia_arquivo_grande.bin";

        try (BufferedInputStream in = new BufferedInputStream(new FileInputStream(arquivoOriginal));
             BufferedOutputStream out = new BufferedOutputStream(new FileOutputStream(arquivoCopia))) {

            byte[] buffer = new byte[1024]; // buffer de 1KB
            int bytesLidos;

            while ((bytesLidos = in.read(buffer)) != -1) {
                out.write(buffer, 0, bytesLidos);
            }

            System.out.println("Arquivo copiado com sucesso para " + arquivoCopia);
        } catch (IOException e) {
            System.out.println("Erro ao copiar o arquivo: " + e.getMessage());
        }
    }
}
