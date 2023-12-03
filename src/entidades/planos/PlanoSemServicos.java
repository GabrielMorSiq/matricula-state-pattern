package entidades.planos;
/**
 * A classe PlanoSemServicos representa um plano que não oferece acesso serviços da academia.
 * É o plano ativo para matrículas canceladas ou vencidas
 * Essa classe estende a classe abstrata {@link PlanoAcademia}.
 */
public class PlanoSemServicos extends PlanoAcademia {
    /**
     * Construtor padrão explícito da classe que define por padrão a ausência de prestação de serviços
     */
    public PlanoSemServicos() {
        super(false, false, false);
        setPreco(0);
    }

    /**
     * Define o preço cobrado para matrículas não ativas como zero
     */

    @Override
    public void calcularPreco() {
        setPreco(0.0);
    }

    /**
     * Retorna representação em string de um objeto do tipo PlanoSemServicos
     * @return Representação em string de um objeto do tipo PlanoSemServicos
     */
    @Override
    public String toString() {
        return "PlanoSemServicos{} " + super.toString();
    }
}

