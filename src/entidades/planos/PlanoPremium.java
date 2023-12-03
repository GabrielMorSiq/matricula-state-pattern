package entidades.planos;
/**
 * A classe PlanoPremium representa um plano intermediário de academia.
 * Oferece acesso à academia, instrutor físico, aulas de zumba e pilates
 * O preço do plano é calculado com base na duração escolhida e o preço mensal do plano
 * Essa classe estende a classe abstrata {@link PlanoAcademia}.
 */
public class PlanoPremium extends PlanoAcademia {
    /**
     *  Cria um novo objeto PlanoPremium com as opções de acesso especificadas,
     *  de forma a especificar os serviços padrão do plano premium
     * @param acessoAcademia Indica se o plano contempla acesso a um instrutor
     * @param acessoInstrutor Indica se o plano contempla acesso a aulas de Zumba e Pilates
     * @param acessoZumbaPilates O preço do plano de academia
     */
    public PlanoPremium(boolean acessoAcademia, boolean acessoInstrutor, boolean acessoZumbaPilates) {
        super(acessoAcademia, acessoInstrutor, acessoZumbaPilates);
        setAcessoAcademia(true);
        setAcessoInstrutor(true);
        setAcessoZumbaPilates(true);
    }
    /**
     * Calcula o preço do plano de academia com base na duração escolhida,
     * que é multiplicado em meses pelo preço mensal do básico premium
     */
    @Override
    public void calcularPreco() {
        if (getDuracaoEscolhida() == DURACAO_UM_MES) {
            setPreco(PRECO_MENSAL_PREMIUM * DURACAO_UM_MES);
        } else if (getDuracaoEscolhida() == DURACAO_UM_SEMESTRE) {
            setPreco(PRECO_MENSAL_PREMIUM * DURACAO_UM_SEMESTRE);
        } else {
            setPreco(PRECO_MENSAL_PREMIUM * DURACAO_UM_ANO);
        }
    }
    /**
     * Retorna representação em string de um objeto do tipo PlanoPremium
     * @return Representação em string de um objeto do tipo PlanoPremium
     */
    @Override
    public String toString() {
        return "PlanoPremium{} " + super.toString();
    }
}
