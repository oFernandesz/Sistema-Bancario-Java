import java.util.Scanner;

void main(){

    Banco banco = new Banco();
    Scanner sc = new Scanner(System.in);

    int ticket = 0;

    while (ticket == 0) {
        System.out.println("\n==== Bem-vindo ao Banco ====");
        System.out.println("1 - Criar conta");

        System.out.println("4 - Buscar contas");
        System.out.println("5 - Sair");
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
                break;

            case 3:
                break;


            case 4:
                banco.getContas();
                break;

            case 5:
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

