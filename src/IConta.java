public interface IConta {
    void depositar(double valor);
    void sacar(double valor);
    void transferir(IConta destino, double valor);
    void imprimirExtrato();
}

