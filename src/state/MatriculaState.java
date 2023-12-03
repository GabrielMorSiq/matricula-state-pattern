package state;

import entidades.Matricula;

/**
 * Interface que recebe solicitações do contexto do padrão State,
 * Definindo os estados possíveis e métodos para transição de estados de uma Matrícula.
 * Se uma classe representa um estado, essa classe deve implementar essa interface.
 */
public interface MatriculaState {

    /**
     * Método abstrato responsável por definir estado atual da matrícula como ativo
     * @param matricula Recebe uma matrícula como parâmetro
     * @return Retorna um novo estado ativo do objeto caso seja possível a mudança de estado interno do objeto
     */
    MatriculaState ativar(Matricula matricula);

    /**
     * Método abstrato responsável por desativar uma matrícula
     * @param matricula Recebe uma matrícula como parâmetro
     * @return Retorna um novo estado ativo do objeto caso seja possível a mudança de estado interno do objeto
     */
    MatriculaState inativar(Matricula matricula);

    /**
     * Método abstrato responsável por cancelar uma matrícula
     * @param matricula Recebe uma matrícula como parâmetro
     * @return Retorna um novo estado ativo do objeto caso seja possível a mudança de estado interno do objeto
     */
    MatriculaState cancelar(Matricula matricula);
}
