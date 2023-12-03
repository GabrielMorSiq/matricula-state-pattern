package state;

import entidades.Matricula;

import java.util.Date;
import java.util.Scanner;
/**
 * Implementação do estado de Matrícula Cancelada.
 * Uma matrícula Cancelada pode ser ativada, mas não inativada (não há plano com prestação de serviço válido com data de vencimento ativa).
 * Uma matrícula já Cancelada não fará nada ao ser Cancelada novamente.
 */
public class MatriculaCanceladaState implements MatriculaState {
    /**
     * Transição para o estado de matrícula ativa
     * @param matricula Recebe uma matrícula como parâmetro
     * @return Matrícula ativa e com dados de duração de plano atualizados
     */
    @Override
    public MatriculaState ativar(Matricula matricula) {
        matricula.setDataInscricao(new Date());
        Scanner scanner = new Scanner(System.in);
        System.out.println("Escolha o período de duração desejado: ");
        System.out.println("[1] - 1 mês");
        System.out.println("[2] - 6 meses");
        System.out.println("[3] - 12 meses");
        int x = scanner.nextInt();
        matricula.setPlanoEscolhido(matricula.escolherPlanoAcademia(x));
        matricula.calcularFimInscricao(x);
        System.out.println("Matrícula antes cancelada foi ativada!");
        return new MatriculaAtivaState();
    }

    /**
     * Transição para o estado de matrícula inativa
     * @param matricula Recebe uma matrícula como parâmetro
     * @return Retorna o próprio objeto MatriculaState, já que não há transição
     */
    @Override
    public MatriculaState inativar(Matricula matricula) {
        System.out.println("Ops; Matrícula cancelada não pode ser inativada, " +
                "não pôde cumprir o período de prestação de serviço!");
        return this;
    }

    /**
     * Transição para o estado de matrícula cancelada
     * @param matricula Recebe uma matrícula como parâmetro
     * @return Retorna o próprio objeto MatriculaState, já que não há transição
     */
    @Override
    public MatriculaState cancelar(Matricula matricula) {
        System.out.println("Ops; Matrícula já está cancelada!");
        return this;
    }
    /**
     * Retorna representação em string do estado da Matrícula
     * @return Representação em string do estado da Matrícula
     */
    @Override
    public String toString() {
        return "Matricula Cancelada";
    }
}
