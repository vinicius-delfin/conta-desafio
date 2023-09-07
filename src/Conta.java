public class Conta {
    private int numeroConta;
    private String nomeAgencia;
    private double saldo;
    private String nomeCliente;

    Conta(int numeroConta, String nomeAgencia, String nomeCliente) {
        this.numeroConta = numeroConta;
        this.nomeAgencia = nomeAgencia;
        this.nomeCliente = nomeCliente;
    }

    public void depositar(int valor) {
        saldo += valor;
    }

    public boolean sacar(int valor) {
        if(valor > saldo) {
            System.out.println("Saldo insuficiente!");
            return false;
        }
        saldo -= valor;
        System.out.println("Saque efetuado com sucesso!");
        return true;
    }

    @Override
    public String toString() {
        return "-------------------------------------------------" +
                "\nNúmero da conta: " + numeroConta + "\nNome da agência: " + nomeAgencia + "\nNome do cliente: "
                + nomeCliente + "\nSaldo: " + saldo +
                "\n-------------------------------------------------";
    }

}
