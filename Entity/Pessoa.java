package Entity;

import java.util.Scanner;

public class Pessoa {
    private String nome;
    private double dinheiro;
    private double investimento;

    public Pessoa(String nome, double dinheiro) {
        this.nome = nome;
        this.dinheiro = dinheiro;
    }
    public void adicionarDinheiro(double valor) {
        this.dinheiro += valor;
        limparTela();
    }
    public void retirarDinheiro(double valor) {
        if (valor <= this.dinheiro) {
            this.dinheiro -= valor;
            limparTela();
        } else {
            System.out.println("Saldo insuficiente.");
        }
    }
    public void Investir(double valorDeDeposito) {
        investimento += valorDeDeposito;
        limparTela();
        System.out.println("investimento de R$"+valorDeDeposito+" foi adicionado");
    }
    public void rendimento(){
        investimento=investimento+(investimento*0.05);
    }
    public void exibirInformacoes() {
        limparTela();
        System.out.println("Nome: " + nome);
        System.out.println("Dinheiro: R$" + dinheiro);
        System.out.printf("Dinheiro investido: R$ %.2f%n", investimento);
    }
    public static void limparTela() {
        for (int i = 0; i < 50; i++) {
            System.out.println();
        }
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String nomeCliente;
        double dinheiroCliente;

        Pessoa cliente = null;
        int opcao;
        do {
            System.out.println("\n===== Menu =====");
            System.out.println("1. Criar nova pessoa");
            System.out.println("2. Adicionar dinheiro");
            System.out.println("3. Retirar dinheiro");
            System.out.println("4. Investimento");
            System.out.println("5. Exibir informações");
            System.out.println("6. Sair do programa");
            System.out.print("Escolha a opção desejada: ");
            opcao = scanner.nextInt();

            switch (opcao) {
                case 1:

                    scanner.nextLine();
                    System.out.print("Digite o nome do cliente: ");
                    nomeCliente = scanner.nextLine();
                    System.out.print("Digite o dinheiro do cliente: ");
                    dinheiroCliente = scanner.nextDouble();
                    cliente = new Pessoa(nomeCliente, dinheiroCliente);
                    cliente.limparTela();
                    System.out.print("Cliente Criado, para obter as informacoes tecle 5");
                    break;
                case 2:
                    if (cliente != null) {
                        System.out.print("Digite o valor a ser adicionado: ");
                        double valorAdicionar = scanner.nextDouble();
                        cliente.adicionarDinheiro(valorAdicionar);
                    } else {
                        System.out.println("Crie uma pessoa primeiro (Opção 1).");
                    }
                    break;
                case 3:
                    if (cliente != null) {
                        System.out.print("Digite o valor a ser retirado: ");
                        double valorRetirar = scanner.nextDouble();
                        cliente.retirarDinheiro(valorRetirar);
                    } else {
                        System.out.println("Crie uma pessoa primeiro (Opção 1).");
                    }
                    break;
                case 4:
                    System.out.println("Digite o valor que voce deseja investir: ");
                    double valorAdicionar = scanner.nextDouble();
                    cliente.Investir(valorAdicionar);

                    break;
                case 5:
                    if (cliente != null) {
                        cliente.exibirInformacoes();
                    } else {
                        System.out.println("Crie uma pessoa primeiro (Opção 1).");
                    }
                    break;
                case 6:
                    System.out.println("Saindo do programa...");
                    break;
                default:
                    System.out.println("Opção inválida. Digite um número válido.");
            }
            cliente.rendimento();
        } while (opcao != 6);
        scanner.close();
    }
}
