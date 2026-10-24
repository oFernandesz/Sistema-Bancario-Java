import java.util.ArrayList;

public class Banco {
    private ArrayList<Conta> contas;

    public Banco(){
        this.contas = new ArrayList<>();
    }

    public Boolean CriarConta(String name, int password){
        int num = contas.size() + 1;
        Conta novaConta = new Conta(num, name, password);
        contas.add(novaConta);
        System.out.println("Numero da conta - "+novaConta.getNumber());

    return true;
    }

    void getContas(){
        for(int i = 0;i < contas.size(); i++){
            System.out.println("Conta - "+contas.get(i).getNumber()+ " - "+contas.get(i).getName());
        }
    }

    public Conta buscarConta(int numero){
        for(int i = 0; i < contas.size(); i++){
            if(contas.get(i).getNumber() == numero) {
                return contas.get(i);
            }
        }
        return null;
    }
}


