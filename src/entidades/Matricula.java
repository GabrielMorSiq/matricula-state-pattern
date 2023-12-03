package entidades;

import state.*;
import entidades.planos.PlanoAcademia;
import entidades.planos.PlanoBasico;
import entidades.planos.PlanoIntermediario;
import entidades.planos.PlanoPremium;

import java.util.Calendar;
import java.util.Date;

public class Matricula {
    /**
     * O estado atual da matrícula
     */
    private MatriculaState state;
    /**
     * O cliente correspodnete da matrícula
     */
    private Cliente cliente;
    /**
     * O plano de academia correspondente a matrícula
     */
    private PlanoAcademia planoEscolhido;
    /**
     * Data de ativação da matrícula
     */
    private Date dataInscricao;
    /**
     * Data de vencimento ou do cancelamento da matrícula
     */
    private Date fimInscricao;

    /**
     * Construtor padrão e explícito que cria novas matrículas sem definir seus atributos, com exceção do estado
     * que está setado como ativo por padrão.
     */
    public Matricula(){
        this.state = new MatriculaAtivaState();
    }

    /**
     *  Cria um objeto Matricula com os parâmetros abaixo:
     * @param state O estado atual da matrícula
     * @param cliente O cliente correspodnete da matrícula
     * @param planoEscolhido O plano de academia correspodnete a matrícula
     * @param dataInscricao Data de ativação da matrícula
     */
    public Matricula(MatriculaState state, Cliente cliente, PlanoAcademia planoEscolhido, Date dataInscricao) {
        this.state = new MatriculaAtivaState();
        this.cliente = cliente;
        this.planoEscolhido = planoEscolhido;
        this.dataInscricao = dataInscricao;
    }
    /**
     * Retorna o cliente correspondente da matrícula
     *
     * @return O cliente associado à matrícula.
     */
    public Cliente getCliente() {
        return cliente;
    }

    /**
     * Define o cliente correspondente da matrícula
     * @param cliente  O cliente associado à matrícula.
     */
    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    /**
     * Retorna o plano de academia correspondente a matrícula
     * @return O plano de academia correspondente a matrícula
     */
    public PlanoAcademia getPlanoEscolhido() {
        return planoEscolhido;
    }

    /**
     *
     * @param planoEscolhido O plano de academia correspondente a matrícula
     */
    public void setPlanoEscolhido(PlanoAcademia planoEscolhido) {
        this.planoEscolhido = planoEscolhido;
    }

    /**
     * Consulta e retorna a data de ativação da matrícula
     * @return Data de ativação da matrícula
     */
    public Date getDataInscricao() {
        return dataInscricao;
    }

    /**
     * Define a data de ativação da matrícula
     * @param dataInscricao Data de ativação da matrícula
     */
    public void setDataInscricao(Date dataInscricao) {
        this.dataInscricao = dataInscricao;
    }

    /**
     * Verifica a data de vencimento ou do cancelamento da matrícula
     * @return Data de vencimento ou do cancelamento da matrícula
     */
    public Date getFimInscricao() {
        return fimInscricao;
    }

    /**
     * Define a data de vencimento ou do cancelamento da matrícula
     * @param fimInscricao Data de vencimento ou do cancelamento da matrícula
     */
    public void setFimInscricao(Date fimInscricao) {
        this.fimInscricao = fimInscricao;
    }

    /**
     * Define qual o plano de academia escolhido
     * @param opcaoEscolhida Através de um inteiro se pode indicar a constante que define qual o plano de academia escolhido
     * @return O plano de academia escolhido.
     */
    public PlanoAcademia escolherPlanoAcademia(int opcaoEscolhida){
        switch(opcaoEscolhida){
            case 1 -> {
                setPlanoEscolhido(new PlanoBasico(true, false, false));
            }
            case 2 -> {
                setPlanoEscolhido(new PlanoIntermediario(true, true, false));
            }
            case 3 -> {
                setPlanoEscolhido(new PlanoPremium(true, true, true));
            }
        }

        return planoEscolhido;
    }

    /**
     *  Calcula a data de término da inscrição com base na duração do plano
     * @param duracaoEscolhida Indica qual a opção de duração escolhida
     */
    public void calcularFimInscricao(int duracaoEscolhida){
        Calendar calendario = Calendar.getInstance();
        calendario.setTime(getDataInscricao());

        if(duracaoEscolhida == 1){
            duracaoEscolhida = PlanoAcademia.DURACAO_UM_MES;
        } else if (duracaoEscolhida == 2) {
            duracaoEscolhida = PlanoAcademia.DURACAO_UM_SEMESTRE;
        }else if (duracaoEscolhida == 3) {
            duracaoEscolhida = PlanoAcademia.DURACAO_UM_ANO;
        } else{
            System.out.println("Inválido!");
            return;
        }

        calendario.add(Calendar.MONTH, duracaoEscolhida);
        setFimInscricao(calendario.getTime());
    }
    /**
     * Ativa a matrícula; contexto do state que solicita a alteração do estado da matrícula para ativo,
     * sem se preocupar com a implementação dessa funcionalidade
     */
    public void ativar(){
        state = state.ativar(this);
    }
    /**
     * Desativa a matrícula; contexto do state que solicita a alteração do estado da matrícula para inativa,
     * sem se preocupar com a implementação dessa funcionalidade
     */
    public void inativar(){
        state = state.inativar(this);
    }
    /**
     * Cancela a matrícula; contexto do state que solicita a alteração do estado da matrícula para cancelada,
     * sem se preocupar com a implementação dessa funcionalidade
     */
    public void cancelar(){
        state = state.cancelar(this);
    }
    /**
     * Retorna representação em string de um objeto do tipo Matrícula
     * @return Representação em string de um objeto do tipo Matrícula
     */
    @Override
    public String toString() {
        return cliente +
                "\nPlano Escolhido    = " + planoEscolhido.getClass().getSimpleName() + " R$" + planoEscolhido.getPreco() +
                "\nData de Inscrição  = " + dataInscricao +
                "\nFim da Inscricao   = " + fimInscricao +
                "\nEstado da Matrícula: " + state;
    }
}
