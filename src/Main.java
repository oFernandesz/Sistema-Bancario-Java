import java.util.Scanner;

void main(){

    Banco banco = new Banco();
    Scanner sc = new Scanner(System.in);

    int ticket = 0;

    while (ticket == 0) {
        System.out.println("\n==== Bem-vindo ao Banco ====");
        System.out.println("1 - Criar conta");
        System.out.println("2 - Acessar conta");
        System.out.println("3 - Buscar contas");
        System.out.println("4 - Sair");
        System.out.print("Insira a opção desejada: ");


        int option;

        try {
            option = sc.nextInt();
            sc.nextLine();
        } catch (java.util.InputMismatchException e) {
            System.out.println("Erro: digite apenas números.");
            sc.nextLine();
            continue;
        }

        switch (option) {

            case 1:
                System.out.print("Insira o nome do titular: ");
                String nome = sc.nextLine();
                System.out.print("Insira a senha da conta (*apenas dígitos): ");
                int senha;
                try {
                    senha = sc.nextInt();
                    sc.nextLine();
                } catch (java.util.InputMismatchException e) {
                    System.out.println("Erro: digite apenas números.");
                    sc.nextLine();
                    continue;
                }

                boolean criada = banco.CriarConta(nome, senha);


                if (criada) {
                    System.out.println("Sua conta foi criada com sucesso!");


                } else {
                    System.out.println("Não foi possível criar sua conta.");
                }

                break;

            case 2:
                System.out.println("=== Login ===");
                System.out.println("Numero da conta: ");
                int numAcess;
                try {
                    numAcess = sc.nextInt();
                    sc.nextLine();
                } catch (java.util.InputMismatchException e) {
                    System.out.println("Erro: digite apenas números.");
                    sc.nextLine();
                    continue;
                }
                System.out.println("Insira a senha: ");
                int senhaAcess;
                try {
                    senhaAcess = sc.nextInt();
                    sc.nextLine();
                } catch (java.util.InputMismatchException e) {
                    System.out.println("Erro: digite apenas números.");
                    sc.nextLine();
                    continue;
                }
                if(banco.buscarConta(numAcess) != null){
                    Conta conta = banco.buscarConta(numAcess);
                    if(conta.validarSenha(senhaAcess)){
                        int ticketAcount = 0;
                        while(ticketAcount == 0){
                            System.out.println("=== Bem Vindo, "+conta.getName()+" ===");
                            System.out.println("1 - Ver conta");
                            System.out.println("2 - Realizar Transação");
                            System.out.println("3 - Depositar");
                            System.out.println("4 - Saque");
                            System.out.println("5 - Sair da conta");
                            System.out.print("Insira a opção que deseja: ");
                            int acountOption;
                            try {
                                acountOption = sc.nextInt();
                                sc.nextLine();
                            } catch (java.util.InputMismatchException e) {
                                System.out.println("Erro: Opção invalida.");
                                sc.nextLine();
                                continue;
                            }
                            switch (acountOption){
                                case 1:
                                    conta.getInfos();
                                    break;


                                case 2:
                                    System.out.println("=== Transação ===");

                                    System.out.println("Insira o numero da conta a transferir: ");
                                    int numDestino;
                                    try {
                                        numDestino = sc.nextInt();
                                        sc.nextLine();
                                    } catch (java.util.InputMismatchException e) {
                                        System.out.println("Erro: Valor invalido");
                                        sc.nextLine();
                                        continue;
                                    }
                                    Conta destino = banco.buscarConta(numDestino);
                                    if(destino != null){
                                        System.out.println("Conta a transferir: "+destino.getName());
                                    } else{
                                        System.out.println("Conta não encontrada! ");
                                        break;
                                    }
                                    if(conta.getBalance() == 0){
                                        System.out.println("Saldo insuficiente para efetuar pagamento!");
                                        break;
                                    }else{
                                        System.out.println("Saldo disponivel: R$"+conta.getBalance());
                                        System.out.println("Insira o valor a transferir: ");
                                        double valorTransferir;
                                        try {
                                            valorTransferir = sc.nextDouble();
                                            sc.nextLine();
                                        } catch (java.util.InputMismatchException e) {
                                            System.out.println("Erro: Valor invalido.");
                                            sc.nextLine();
                                            continue;
                                        }
                                        conta.transação(valorTransferir, destino);
                                        break;


                                    }


                                case 3:
                                    System.out.println(" === Deposito ===");
                                    System.out.println("Insira o valor que deseja depositar: ");
                                    double valorDeposito;
                                    try{
                                        valorDeposito = sc.nextDouble();
                                        sc.nextLine();
                                    } catch (java.util.InputMismatchException e) {
                                        System.out.println("Erro: Valor invalido.");
                                        sc.nextLine();
                                        continue;
                                    }
                                    if(valorDeposito > 0){
                                        conta.depositar(valorDeposito);

                                    }else{
                                        System.out.println("Valor invalido!");
                                    }

                                    break;


                                case 4:
                                    System.out.println(" === Saque === ");
                                    System.out.println("Insira o valor que deseja sacar: ");
                                    double valorSaque;
                                    try{
                                        valorSaque = sc.nextDouble();
                                        sc.nextLine();
                                    } catch (java.util.InputMismatchException e) {
                                        System.out.println("Erro: Valor invalido.");
                                        sc.nextLine();
                                        continue;
                                    }
                                    conta.sacar(valorSaque);
                                    break;


                                case 5:
                                    ticketAcount = 1;
                                    break;
                            }
                        }
                    } else{
                        System.out.println("Senha incorreta!");
                        break;
                    }
                }else{
                    System.out.println("Não foi possivel localizar esta conta! ");
                    break;
                }
                break;


            case 3:
                banco.getContas();
                break;

            case 4:
                ticket = 1;
                System.out.println("Obrigado por utilizar nosso banco!");
                break;

            default:
                System.out.println("Opção inválida. Tente novamente.");
                break;
        }
    }

    sc.close();
}

