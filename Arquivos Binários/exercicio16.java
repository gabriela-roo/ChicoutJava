import java.io.FileInputStream;
import java.io.IOException;

public class LerPrimeirosBytes {
    public static void main(String[] args) {
        String nomeArquivo = "arquivo.bin";
        byte[] buffer = new byte[100];

        try (FileInputStream fileInput = new FileInputStream(nomeArquivo)) {
            int bytesLidos = fileInput.read(buffer, 0, 100);
            if (bytesLidos > 0) {
                System.out.println("Primeiros 100 bytes do arquivo:");
               
