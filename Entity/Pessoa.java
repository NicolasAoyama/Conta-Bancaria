package Entity;

import java.util.Scanner;

public class Pessoa {
    private String nome;
    private double dinheiro;

    public Pessoa(String nome, double dinheiro) {
        this.nome = nome;
        this.dinheiro = dinheiro;
    }
    public void adicionarDinheiro(double valor) {
        this.dinheiro += valor;
    }
    public void retirarDinheiro(double valor) {
        if (valor <= this.dinheiro) {
            this.dinheiro -= valor;
        } else {
            System.out.println("Saldo insuficiente.");
        }
    }
    public void exibirInformacoes() {
        System.out.println("Nome: " + nome);
        System.out.println("Dinheiro: R$" + dinheiro);
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
            System.out.println("4. Exibir informações");
            System.out.println("5. Sair do programa");
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
                    if (cliente != null) {
                        cliente.exibirInformacoes();
                    } else {
                        System.out.println("Crie uma pessoa primeiro (Opção 1).");
                    }
                    break;
                case 5:
                    System.out.println("Saindo do programa...");
                    break;
                default:
                    System.out.println("Opção inválida. Digite um número válido.");
            }
        } while (opcao != 5);
        scanner.close();
    }
}
