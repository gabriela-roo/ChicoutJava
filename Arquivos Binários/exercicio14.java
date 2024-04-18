import java.io.*;

class ContaBancaria implements Serializable {
    private String titular;
    private double saldo;

    public ContaBancaria(String titular, double saldo) {
        this.titular = titular;
        this.saldo = saldo;
    }

    public String getTitular() {
        return titular;
    }

    public double getSaldo() {
        return saldo;
    }

    public void depositar(double valor) {
        saldo += valor;
    }

    public void sacar(double valor) {
        saldo -= valor;
    }
}

public class AtualizarConta {
    public static void main(String[] args) {
        try {
            FileInputStream fileIn = new FileInputStream("conta.dat");
            ObjectInputStream objectIn = new ObjectInputStream(fileIn);
            ContaBancaria conta = (ContaBancaria) objectIn.readObject();
            objectIn.close();
            fileIn.close();

            System.out.println("Saldo atual: R$" + conta.getSaldo());
            conta.depositar(100); // Exemplo de atualização do saldo (aumentar em R$100)
            System.out.println("Novo saldo: R$" + conta.getSaldo());

            FileOutputStream fileOut = new FileOutputStream("conta.dat");
            ObjectOutputStream objectOut = new ObjectOutputStream(fileOut);
            objectOut.writeObject(conta);
