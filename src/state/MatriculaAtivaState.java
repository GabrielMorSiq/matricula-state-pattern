package state;

import entidades.Matricula;
import entidades.planos.PlanoSemServicos;

import java.util.Date;

/**
 * Implementação do estado de matrícula ativa.
 * Uma matrícula ativa pode ser cancelada ou inativada.
 * Uma matrícula já ativa não fará nada ao ser ativada novamente. Nesse sentido, outras ações também seriam possíveis,
 * como ativar alguma condição de ativação especial ou se lançar exceção.
 */
public class MatriculaAtivaState implements MatriculaState {
    /**
     * Transição para o estado de matrícula ativa
     * @param matricula Recebe uma matrícula como parâmetro
     * @return Retorna o próprio objeto MatriculaState, já que matrícula já está ativa; não há transição
     */
    @Override
    public MatriculaState ativar(Matricula matricula) {
        System.out.println("Ops; Matrícula já está ativada");
        return this;
    }

    /**
     * Transição para o estado de matrícula inativa
     * @param matricula Recebe uma matrícula como parâmetro
     * @return Caso a matrícula já não esteja desativada ou o tempo de prestação de serviços não tenha vencido,
     * faz-se a transição de estado de ativa para inativa
     */
    @Override
    public MatriculaState inativar(Matricula matricula) {

        if(matricula.getClass().getSimpleName().equals("MatriculaDesativadaState")){
            System.out.println("Matrícula já está desativada!");
            return this;
        }else if (matricula.getFimInscricao().before(new Date())) { // verifica se a data de fim é anterior à data atual
            matricula.setPlanoEscolhido(new PlanoSemServicos());
            System.out.println("Matrícula ativada foi inativada! Tempo de prestação de serviços acabou!");
            return new MatriculaDesativadaState();
        }else{
            System.out.println("O fim do período de prestação de serviços não venceu. " +
                    "\nTalvez o que você deseja é cancelar a matrícula?");
        }
        return this;
    }

    /**
     * Transição para o estado de matrícula cancelada
     * @param matricula Recebe uma matrícula como parâmetro
     * @return Faz a transição de estado de ativa para cancelada
     */
    @Override
    public MatriculaState cancelar(Matricula matricula) {
        matricula.setPlanoEscolhido(new PlanoSemServicos());
        matricula.setFimInscricao(new Date(0));
        System.out.println("Matrícula ativada foi cancelada!");
        return new MatriculaCanceladaState();
    }

    /**
     * Retorna representação em string do estado da Matrícula
     * @return Representação em string do estado da Matrícula
     */
    @Override
    public String toString() {
        return "Matricula Ativa";
    }
}
