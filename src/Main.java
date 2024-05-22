public class Main {
    public static void main(String[] args) {
        Cliente cliente1 = new Cliente("Joao", "Silva");
        Cliente cliente2 = new Cliente("Maria", "Oliveira");

        IConta contaCorrente = new ContaCorrente("12345-6", cliente1);
        IConta contaPoupanca = new ContaPoupanca("65432-1", cliente2);

        contaCorrente.depositar(1000);
        contaCorrente.sacar(250);
        contaCorrente.transferir(contaPoupanca, 500);

        contaCorrente.imprimirExtrato();
        System.out.println();
        contaPoupanca.imprimirExtrato();
    }
}
