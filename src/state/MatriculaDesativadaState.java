package state;

import entidades.Matricula;

import java.util.Date;
import java.util.Scanner;
/**
 * Implementação do estado de Matrícula Desativada.
 * Uma matrícula Desativada pode ser ativada, mas não cancelada (prestação de serviço foi concluída).
 * Uma matrícula já Desativada não fará nada ao ser Desativada novamente.
 */
public class MatriculaDesativadaState implements MatriculaState {
    /**
     *Transição para o estado de matrícula ativa
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
        System.out.println("Matrícula antes desativada foi ativada!");
        return new MatriculaAtivaState();
    }

    /**
     * Transição para o estado de matrícula inativa
     * @param matricula Recebe uma matrícula como parâmetro
     * @return Retorna o próprio objeto MatriculaState, já que não há transição
     */
    @Override
    public MatriculaState inativar(Matricula matricula) {
        System.out.println("Ops; Matrícula já está inativa!");
        return this;
    }

    /**
     * Transição para o estado de matrícula cancelada
     * @param matricula Recebe uma matrícula como parâmetro
     * @return Retorna o próprio objeto MatriculaState, já que não há transição
     */
    @Override
    public MatriculaState cancelar(Matricula matricula) {
        System.out.println("Ops; Matrícula inativa não é passível de ser cancelada!");
        return this;
    }
    /**
     * Retorna representação em string do estado da Matrícula
     * @return Representação em string do estado da Matrícula
     */
    @Override
    public String toString() {
        return "Matricula Desativada";
    }
}
