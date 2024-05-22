public class ContaCorrente extends Conta {
    public ContaCorrente(String numeroConta, Cliente cliente) {
        super(numeroConta, cliente);
        registrarOperacao("Conta Corrente criada para " + cliente.getNomeCompleto());
    }

}
