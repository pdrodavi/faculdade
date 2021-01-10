package questao04;

public class Conta {

    private static int numero;
    private static String titular;
    private static double saldo;
    private static double limiteCredito;

    public Conta(int numero, String titular, double saldo, double limiteCredito) {
        Conta.numero = numero;
        Conta.titular = titular;
        Conta.saldo = saldo;
        Conta.limiteCredito = limiteCredito;
    }

    public static boolean sacar(Conta c, double valor) {
        if (valor > Conta.saldo) {
            System.out.println("Conta com saldo insuficiente!");
            System.out.println("Saldo: " + Conta.saldo);
            System.out.println("Valor tentado sacar: " + valor);
            return false;
        } else {
            System.out.println("Saldo: R$" + saldo);
            Conta.saldo -= valor;
            System.out.println("R$"+ valor + " foi debitado da sua conta!");
            System.out.println("Saldo pós-saque: R$" + saldo);
        }
        return true;
    }
    
    public static boolean depositar(Conta c, double valor) {
        if(valor < 0){
            System.out.println("Não é possível depositar valor negativo!");
            System.out.println("Valor tentado depositar: R$" + valor);
            return false;
        } else {
            System.out.println("Saldo: R$ " + saldo);
            System.out.println("Depósito efetuado com sucesso!");
            saldo += valor;
            System.out.println("Saldo pós-depósito: R$ " + saldo);
        }
        return true;
    }

    public static boolean transferir(Conta c1, Conta c2, double valor) {

        if (valor > 0) {
            boolean retirou = Conta.sacar(c1,valor);
            if (retirou == false) {
                return false;
            } else {
                if (c2 != null) {
                    Conta.depositar(c2, valor);
                    return true;
                } else {
                    System.err.println("Valor de Conta Corrente 2 nulo!");
                    return false;
                }
            }
        } else {
            System.out.println("Valor abaixo de zero");
            return false;
        }

    }

    public static boolean comprarNoCredito(double valor) {
        
        if(valor <= limiteCredito){
            System.out.println("Limite de Crédito: " + limiteCredito);
            System.out.println("Compra efetuada com sucesso no valor de R$"+valor);
            limiteCredito -= valor;
            System.out.println("Limite de Crédito Pós-compra: " + limiteCredito);
        } else {
            System.out.println("Você não tem limite suficiente de crédito!");
            System.out.println("Seu limite: " + limiteCredito);
            System.out.println("Valor da tentativa de compra: R$ " + valor);
            return false;
        }
        return true;
    }

    public static int getNumero() {
        return numero;
    }

    public static void setNumero(int numero) {
        Conta.numero = numero;
    }

    public static String getTitular() {
        return titular;
    }

    public static void setTitular(String titular) {
        Conta.titular = titular;
    }

    public static double getSaldo() {
        return saldo;
    }

    public static void setSaldo(double saldo) {
        Conta.saldo = saldo;
    }

    public static double getLimiteCredito() {
        return limiteCredito;
    }

    public static void setLimiteCredito(double limiteCredito) {
        Conta.limiteCredito = limiteCredito;
    }
    
    
}
