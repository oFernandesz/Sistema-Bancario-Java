public class Conta {
    private int number;
    private String name;
    private double balance;
    private int password;

    public Conta(int number, String name, int password){
        this.number = number;
        this.name = name;
        this.balance = 100;
        this.password = password;
    }

    public String getName(){
        return this.name;
    }

    public int getNumber(){
        return this.number;
    }

    public double getBalance(){
        return this.balance;
    }

    void getInfos(){
        System.out.println("Numero da conta - "+number);
        System.out.println("Titular - "+name);
        System.out.println("Saldo atual R$"+balance);
    }

    void depositar(double valor){
        this.balance = this.balance + valor;
        System.out.println("Deposito de R$"+valor+" Realizado com Sucesso!!!");
    }

    void sacar(double valor){
        if(valor <= 0 || valor > this.balance ){
            System.out.println("Valor invalido para saque");
            System.out.println("Seu saldo atual é de R$"+this.balance);
        }else{
            balance = balance - valor;
        }
    }

    void transação(double valor, Conta destino){
        if(valor <= 0 || valor > this.balance){
            System.out.println("Transferencia invalida!");
        }else{
            this.balance = this.balance - valor;
            destino.balance = destino.balance + valor;
            System.out.println("Transferencia realizada com sucesso! ");

        }
    }

    public boolean validarSenha(int senhaInformada){
        return this.password == senhaInformada;
    }




}
