import java.util.ArrayList;
import java.util.Date;

public abstract class Conta implements IConta {
    private String numeroConta;
    protected double saldo;
    private ArrayList<String> extrato;
    private Cliente cliente;

    public Conta(String numeroConta, Cliente cliente) {
        this.numeroConta = numeroConta;
        this.saldo = 0.0;
        this.cliente = cliente;
        this.extrato = new ArrayList<>();
        registrarOperacao("Conta criada com saldo inicial de R$ 0,00");
    }

    @Override
    public void depositar(double valor) {
        if (valor > 0) {
            saldo += valor;
            registrarOperacao("Deposito de R$ " + valor);
        } else {
            System.out.println("Valor de deposito invalido.");
        }
    }

    @Override
    public void sacar(double valor) {
        if (valor > 0 && saldo >= valor) {
            saldo -= valor;
            registrarOperacao("Saque de R$ " + valor);
        } else {
            System.out.println("Saldo insuficiente ou valor de saque invalido.");
        }
    }

    @Override
    public void transferir(IConta destino, double valor) {
        if (valor > 0 && saldo >= valor) {
            this.sacar(valor);
            destino.depositar(valor);
            registrarOperacao("Transferencia de R$ " + valor + " para a conta " + ((Conta) destino).getNumeroConta());
            ((Conta) destino).registrarOperacao("Transferencia de R$ " + valor + " recebida da conta " + this.numeroConta);
        } else {
            System.out.println("Saldo insuficiente ou valor de transferencia invalido.");
        }
    }

    @Override
    public void imprimirExtrato() {
        System.out.println("Extrato da conta " + numeroConta + " - Cliente: " + cliente.getNomeCompleto());
        for (String operacao : extrato) {
            System.out.println(operacao);
        }
        System.out.println("Saldo atual: R$ " + saldo);
    }

    protected void registrarOperacao(String operacao) {
        String registro = new Date() + " - " + operacao;
        extrato.add(registro);
    }

    public String getNumeroConta() {
        return numeroConta;
    }

    public double getSaldo() {
        return saldo;
    }

    public Cliente getCliente() {
        return cliente;
    }
}
