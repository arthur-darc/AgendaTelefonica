import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Agenda {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        List<Contato> agenda = new ArrayList<Contato>();

        while(true){
            mostrarMenu();
            int opcao = scanner.nextInt();
            scanner.nextLine();
            switch (opcao){
                case 1:
                    adicionarContato(agenda, scanner);
                    break;
                case 2:
                    listarContatos(agenda);
                    break;
                case 3:
                    procurarContato(agenda, scanner);
                    break;
                case 4:
                    excluirContato(agenda, scanner);
                    break;
                case 5:
                    return;
                default:
                    printLinha();
                    System.out.println("opção Inválida!");
                    printLinha();
            }
        }
    }

    public static void  procurarContato(List<Contato> agenda, Scanner scanner){
        System.out.println("Digite o nome do contato: ");
        String procurar = scanner.nextLine();

        boolean contatoEncontrado = false;

        for (int i = 0; i < agenda.size(); i++) {
            if(procurar.equals(agenda.get(i).getNome())){
                printLinha();
                System.out.println("Contato encontrado!");
                System.out.println(agenda.get(i).toString());
                printLinha();
                contatoEncontrado = true;
                break;
            }
        }

        if (!contatoEncontrado){
            printLinha();
            System.out.println("Contato não encontrado!");
            printLinha();
        }
    }

    public static void excluirContato(List<Contato> agenda, Scanner scanner) {
        System.out.println("Digite o nome do contato que deseja excluir: ");
        String procurar = scanner.nextLine();

        boolean contatoEncontrado = false;

        for (int i = 0; i < agenda.size(); i++) {
            if (procurar.equals(agenda.get(i).getNome())) {
                agenda.remove(i);
                printLinha();
                System.out.println("Contato apagado!");
                printLinha();
                contatoEncontrado = true;
                break;
            }
        }

        if (!contatoEncontrado){
            printLinha();
            System.out.println("Contato não encontrado!");
            printLinha();
        }
    }

    public static void listarContatos(List<Contato> agenda){

        for (int i = 0; i < agenda.size(); i++) {
            System.out.println("Contatos: " + (1+i));
            System.out.println(agenda.get(i).toString());
            printLinha();
        }
    }

    public  static void  adicionarContato(List<Contato> agenda, Scanner scanner){
        System.out.println("Digite o nome do contato:");
        String nome = scanner.nextLine();

        System.out.println("Digite o telefone do contato:");
        String telefone = scanner.nextLine();

        System.out.println("Digite o e-mail do contato:");
        String email = scanner.nextLine();

        Contato novoContato = new Contato(nome, telefone, email);
        agenda.add(novoContato);

        printLinha();
        System.out.println("Contato adicionado com sucesso!");
        printLinha();
    }

    public  static  void  mostrarMenu(){
        System.out.println("Menu da Agenda de Contatos:");
        System.out.println("[1] Adicionar Contato");
        System.out.println("[2] Listar os Contatos");
        System.out.println("[3] Procurar Contato");
        System.out.println("[4] Excluir Contato");
        System.out.println("[5] Sair");
    }

    public  static  void printLinha(){
        System.out.println("--------------------------------------");
    }
}