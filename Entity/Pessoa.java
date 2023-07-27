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

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getDinheiro() {
        return dinheiro;
    }

    public void setDinheiro(double dinheiro) {
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
    public void Depositar(double valorDeDeposito) {
        dinheiro += valorDeDeposito;
        System.out.println("valor depositado seu saldo bancario agora é de R$"+dinheiro);
    }

    public void Investir(double valorDeDeposito) {
        investimento=investimento+(investimento*0.05);
        investimento += valorDeDeposito;
        System.out.println("investimento de R$"+valorDeDeposito+"foi adicionado");
    }


    public void exibirInformacoes() {
        System.out.println("Nome: " + nome);
        System.out.println("Dinheiro: R$" + dinheiro);
    }

    public static void main(String[] args) {


        Scanner scanner = new Scanner(System.in);
        System.out.print("Digite o nome do cliente: ");
        String nomeCliente = scanner.nextLine();
        System.out.println("Nome do cliente: " + nomeCliente);
        scanner.close();

    }
}
