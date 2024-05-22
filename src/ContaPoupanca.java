public class ContaPoupanca extends Conta {
    public ContaPoupanca(String numeroConta, Cliente cliente) {
        super(numeroConta, cliente);
        registrarOperacao("Conta Poupanca criada para " + cliente.getNomeCompleto());
    }

}
