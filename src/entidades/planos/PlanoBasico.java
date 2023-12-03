package entidades.planos;


/**
 * A classe PlanoBasico representa um plano básico de academia.
 * Oferece acesso apenas academia
 * O preço do plano é calculado com base na duração escolhida e o preço mensal do plano
 * Essa classe estende a classe abstrata {@link PlanoAcademia}.
 */
public class PlanoBasico extends PlanoAcademia {
    /**
     *  Cria um novo objeto PlanoBasico com as opções de acesso especificadas,
     *  de forma a especificar os serviços padrão do plano básico
     * @param acessoAcademia Indica se o plano contempla acesso a um instrutor
     * @param acessoInstrutor Indica se o plano contempla acesso a aulas de Zumba e Pilates
     * @param acessoZumbaPilates O preço do plano de academia
     */
    public PlanoBasico(boolean acessoAcademia, boolean acessoInstrutor, boolean acessoZumbaPilates) {
        super(acessoAcademia, acessoInstrutor, acessoZumbaPilates);
        setAcessoAcademia(true);
        setAcessoInstrutor(false);
        setAcessoZumbaPilates(false);
    }
    /**
     * Calcula o preço do plano de academia com base na duração escolhida,
     * que é multiplicado em meses pelo preço mensal do básico básico
     */
    @Override
    public void calcularPreco() {
        if (getDuracaoEscolhida() == DURACAO_UM_MES) {
            setPreco(PRECO_MENSAL_BASICO * DURACAO_UM_MES);
        } else if (getDuracaoEscolhida() == DURACAO_UM_SEMESTRE) {
            setPreco(PRECO_MENSAL_BASICO * DURACAO_UM_SEMESTRE);
        } else {
            setPreco(PRECO_MENSAL_BASICO * DURACAO_UM_ANO);
        }
    }
    /**
     * Retorna representação em string de um objeto do tipo PlanoBasico
     * @return Representação em string de um objeto do tipo PlanoBasico
     */
    @Override
    public String toString() {
        return "PlanoBasico{} " + super.toString();
    }
}
