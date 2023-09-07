import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class ContaTeste {

    public List<Conta> contas = new LinkedList<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ContaTeste gerenciar = new ContaTeste();
        int opcao = 0;
        do {
            System.out.println("Menu Principal");
            System.out.println("1. Cadastrar");
            System.out.println("2. Depositar");
            System.out.println("3. Sacar");
            System.out.println("4. Consultar por número");
            System.out.println("5. Consultar todas as contas");
            System.out.println("9. Encerrar");
            System.out.println("Digite sua opcao: ");
            opcao = Integer.parseInt(sc.nextLine());
            int indice = 0;
            switch (opcao) {
                case 1 -> gerenciar.execCadastrar();
                case 2 -> {
                    System.out.println("Informe o número da conta que deseja depositar: ");
                    indice = Integer.parseInt(sc.nextLine());
                    System.out.println("Qual valor deseja depositar?");
                    int valor = Integer.parseInt(sc.nextLine());
                    gerenciar.execDepositar(indice - 1, valor);
                }
                case 3 -> {
                    System.out.println("Informe o número da conta que deseja efetuar o saque:");
                    indice = Integer.parseInt(sc.nextLine());
                    System.out.println("Qual valor deseja sacar?");
                    int valor = Integer.parseInt(sc.nextLine());
                    gerenciar.execSacar(indice - 1, valor);
                }
                case 4 -> {
                    System.out.println("Informe o número da conta que deseja consultar:");
                    indice = Integer.parseInt(sc.nextLine());
                    gerenciar.execConsultarIndex(indice - 1);
                }
                case 5 -> gerenciar.execConultarTudo();
                case 9 -> System.out.println("Sessão encerrada!");
                default -> System.out.println("Opcao invalida");
            }
        } while (opcao != 9);
    }

    public void execCadastrar() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Digite o número da conta: ");
        int nuc = Integer.parseInt(sc.nextLine());
        System.out.println("Digite o nome da agência: ");
        String noa = sc.nextLine();
        System.out.println("Digite o nome do cliente: ");
        String noc = sc.nextLine();
        Conta novaConta = new Conta(nuc, noa, noc);
        contas.add(novaConta);
    }


    public void execConsultarIndex(int indice) {
        System.out.println(contas.get(indice));
    }

    public void execConultarTudo() {
        for (Conta conta : contas) {
            System.out.println(conta);
        }
    }

    public void execSacar(int indice, int valor) {
        contas.get(indice).sacar(valor);
    }

    public void execDepositar(int indice, int valor) {
        contas.get(indice).depositar(valor);
    }
}
