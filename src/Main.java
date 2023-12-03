import entidades.Cliente;
import entidades.Matricula;
import entidades.planos.PlanoAcademia;

import java.util.Date;
import java.util.Scanner;

/**
 *
 * @author Gabriel e Erica
 */
public class Main {
    /**
     * Método responsável pela execução do programa,
     * que cadastra três matrículas que podem ter seu estado e comportamento alterados.
     */
    public static void main(String[] args) {
        // Criação do Scanner para obter a entrada do usuário
        Scanner scanner = new Scanner(System.in);

        // Criação de um array vazio de matrícula com 1 posição
        Matricula[] arrayMatriculas = new Matricula[1];

        // Cadastro de matrícula

        // obter nome e cpf do cliente
        System.out.println("\nDigite os dados da matrícula:");
        String nomeCliente = solicitarNomeCliente(scanner);
        String cpfCliente = solicitarCpfCliente(scanner);

        // instanciar novo cliente
        Cliente cliente = instanciarNovoCliente(nomeCliente, cpfCliente);

        // escolher qual plano assinar e duração do plano
        int opcaoEscolhidaPlanoAcademia = obterEscolhaPlanoAcademia(scanner);
        int opcaoEscolhidaPeriodoAcademia = obterOpcaoEscolhidaPeriodoAcademia(scanner);

        // instanciar matrícula e calcular preço do plano
        Matricula matricula = instanciarNovaMatricula(cliente, opcaoEscolhidaPlanoAcademia, opcaoEscolhidaPeriodoAcademia);
        matricula.getPlanoEscolhido().calcularPreco();

        // Armazenamento da matrícula no array
        arrayMatriculas[0] = matricula;

        while(true){

            // imprimir matrículas existentes
            for (int i = 0; i < arrayMatriculas.length; i++){
                System.out.println("" +
                        "\n\n---" +
                        "Matrícula " + i + "\n" + arrayMatriculas[i] + "\n---");
            }

            //solicitar se deseja sair ou qual matrícula editar o estado
            System.out.println("""
                    \nDigite -1 para sair do Sistema,
                    Ou informe o índice da matrícula a ser editada:
                    """);
            int indice = scanner.nextInt();

            if (indice == -1){
                break;
            }

            // imprimir opções disponíveis
            System.out.println("""
                    Selecione:
                    [1] para ativar matrícula
                    [2] para desativar matrícula
                    [3] para cancelar matrícula
                    [4] para exibir serviços disponíveis para essa matrícula atualmente
                    """);
            int escolha = scanner.nextInt();

            // chamar métodos responsáveis pelas opções disponíveis
            switch(escolha){
                case 1 ->{
                    arrayMatriculas[indice].ativar();
                }
                case 2 ->{
                    arrayMatriculas[indice].inativar();
                }
                case 3 ->{
                    arrayMatriculas[indice].cancelar();
                }
                case 4 ->{
                    exibirServicosDisponiveis(arrayMatriculas[indice]);
                }
            }
        }

    }

    private static Cliente instanciarNovoCliente(String nomeCliente, String cpfCliente) {
        Cliente cliente = new Cliente();
        cliente.setNome(nomeCliente);
        cliente.setCpf(cpfCliente);
        return cliente;
    }

    /**
     * Quando solicitado, exibe o status de acesso à serviços, com relação ao plano ativo de uma matrícula.
     * @param arrayMatriculas Recebe uma matrícula armazenada eu um array como parâmetro.
     */
    private static void exibirServicosDisponiveis(Matricula arrayMatriculas) {
        System.out.println("Acesso a Academia é " + arrayMatriculas.getPlanoEscolhido().isAcessoAcademia());
        System.out.println("Acesso a Academia e Instrutor é " + arrayMatriculas.getPlanoEscolhido().isAcessoInstrutor());
        System.out.println("Acesso a Academia, Instrutor, Pilates e Zumba é  é " + arrayMatriculas.getPlanoEscolhido().isAcessoZumbaPilates());
        System.out.println("O plano ativo atualmente é " + arrayMatriculas.getPlanoEscolhido().getClass().getSimpleName());
    }

    /**
     * Método responsável pela instanciação de uma matrícula, durante o seu cadastro.
     * @param cliente Recebe o respectivo cliente associado com a matrícula sendo cadastrada
     * @param opcaoEscolhidaPlanoAcademia  Inteiro que deve indicar qual o plano da academia escolhido
     * @param opcaoEscolhidaPeriodoAcademia Inteiro que deve indicar qual o período de uso desejado do plano da academia
     * @return Retorna a instância de uma matrícula com a maioria dos atributos definidos
     */
    private static Matricula instanciarNovaMatricula(Cliente cliente, int opcaoEscolhidaPlanoAcademia, int opcaoEscolhidaPeriodoAcademia) {
        Matricula matricula = new Matricula();

        matricula.setCliente(cliente);
        matricula.setDataInscricao(new Date());
        matricula.setPlanoEscolhido(matricula.escolherPlanoAcademia(opcaoEscolhidaPlanoAcademia));
        matricula.calcularFimInscricao(opcaoEscolhidaPeriodoAcademia);
        return matricula;
    }

    /**
     * Exibe a mensagem solicitando qual o período desejado para frequentar a academia
     * @param scanner Objeto utilizado para se obter entrada do usuário
     * @return Retorna o número inteiro que indica qual o período para frequentar a academia escolhido
     */
    private static int obterOpcaoEscolhidaPeriodoAcademia(Scanner scanner) {
        System.out.println("Escolha o período de duração desejado: ");
        System.out.println("[1] - 1 mês");
        System.out.println("[2] - 6 meses");
        System.out.println("[3] - 12 meses");
        return scanner.nextInt();
    }

    /**
     * Exibe a mensagem solicitando qual o plano desejado para frequentar a academia
     * @param scanner Objeto utilizado para se obter entrada do usuário
     * @return Retorna o número inteiro que indica qual o plano da academia escolhido
     */
    private static int obterEscolhaPlanoAcademia(Scanner scanner) {
        System.out.println("Escolha o plano desejado:");
        System.out.printf("[1] Plano Básico - R$ %.2f por mês (Academia)%n",
                PlanoAcademia.PRECO_MENSAL_BASICO);
        System.out.printf("[2] Plano Intermediário - R$ %.2f por mês (Academia e instrutor)%n",
                PlanoAcademia.PRECO_MENSAL_INTERMEDIARIO);
        System.out.printf("[3] Plano Premium (R$ %.2f por mês - (Academia, instrutor, zumba e pilates)%n",
                PlanoAcademia.PRECO_MENSAL_PREMIUM);

        return scanner.nextInt();
    }

    /**
     * Método que exibe mensagem solicitando nome do Cliente
     * @param scanner Objeto utilizado para se obter entrada do usuário
     * @return Retorna a entrada do usuário
     */
    private static String solicitarNomeCliente(Scanner scanner) {
        System.out.print("Nome do cliente: ");
        return scanner.nextLine();
    }

    /**
     * Método que exibe mensagem solicitando o CPF do Cliente
     * @param scanner Objeto utilizado para se obter entrada do usuário
     * @return Retorna a entrada do usuário
     */
    private static String solicitarCpfCliente(Scanner scanner) {
        System.out.print("CPF do cliente: ");
        String cpf = scanner.next();
        scanner.nextLine();
        return cpf;
    }
}