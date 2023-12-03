package entidades.planos;

public abstract class PlanoAcademia {
    /**
     * Indica se o plano contempla acesso à academia
     */
    private boolean acessoAcademia;
    /**
     * Indica se o plano contempla acesso a um instrutor
     */
    private boolean acessoInstrutor;
    /**
     *  Indica se o plano contempla acesso a aulas de Zumba e Pilates
     */
    private boolean acessoZumbaPilates;
    /**
     *  O preço do plano de academia
     */
    private double preco;
    /**
     * Através de um inteiro pode "apontar" para uma constante que define a duração escolhida para o plano de academia
     */
    private int duracaoEscolhida;
    /**
     * Duração do plano correspondendo a um mês
     */
    public static final int DURACAO_UM_MES = 1;
    /**
     * Duração do plano correspondendo a um semestre em meses
     */
    public static final int DURACAO_UM_SEMESTRE = 6;
    /**
     * Duração do plano correspondendo a um ano em meses
     */
    public static final int DURACAO_UM_ANO = 12;
    /**
     * Preço mensal do plano básico da academia
     */
    public static final double PRECO_MENSAL_BASICO = 70;
    /**
     * Preço mensal do plano intermediário da academia
     */
    public static final double PRECO_MENSAL_INTERMEDIARIO = 100;
    /**
     * Preço mensal do plano premium da academia
     */
    public static final double PRECO_MENSAL_PREMIUM = 120;

    /**
     * Construtor padrão (sem argumentos) explícito de um objeto PlanoAcademia.
     * Cria-o sem especificar seus atributos
     */
    public PlanoAcademia(){

    }

    /**
     * Cria um objeto PlanoAcademia especificando os parâmetros:
     * @param acessoAcademia Indica se o plano contempla acesso à academia
     * @param acessoInstrutor Indica se o plano contempla acesso a um instrutor
     * @param acessoZumbaPilates Indica se o plano contempla acesso a aulas de Zumba e Pilates
     */
    public PlanoAcademia(boolean acessoAcademia, boolean acessoInstrutor, boolean acessoZumbaPilates) {
        this.acessoAcademia = acessoAcademia;
        this.acessoInstrutor = acessoInstrutor;
        this.acessoZumbaPilates = acessoZumbaPilates;
    }

    /**
     * Verifica se há acesso à academia
     * @return Verdadeiro se há acesso à academia
     */
    public boolean isAcessoAcademia() {
        return acessoAcademia;
    }

    /**
     * Define se há acesso à academia
     * @param acessoAcademia Indica se o plano contempla acesso à academia
     */
    public void setAcessoAcademia(boolean acessoAcademia) {
        this.acessoAcademia = acessoAcademia;
    }

    /**
     * Verifica se há acesso ao Instrutor
     * @return Verdadeiro se há acesso ao Instrutor
     */
    public boolean isAcessoInstrutor() {
        return acessoInstrutor;
    }

    /**
     * Define se há acesso ao instrutor
     * @param acessoInstrutor Indica se o plano contempla acesso a um instrutor
     */
    public void setAcessoInstrutor(boolean acessoInstrutor) {
        this.acessoInstrutor = acessoInstrutor;
    }

    /**
     * Verifica se há acesso as aulas de Zumba e Pilates
     * @return Verdadeiro se o plano contempla acesso a aulas de Zumba e Pilates
     */
    public boolean isAcessoZumbaPilates() {
        return acessoZumbaPilates;
    }

    /**
     * Define se há acesso as aulas de Zumba e Pilates
     * @param acessoZumbaPilates Indica se o plano contempla acesso a aulas de Zumba e Pilates
     */
    public void setAcessoZumbaPilates(boolean acessoZumbaPilates) {
        this.acessoZumbaPilates = acessoZumbaPilates;
    }

    /**
     * Verifica o valor do plano de academia
     * @return O preço do plano de academia
     */
    public double getPreco() {
        return preco;
    }

    /**
     * Define o valor do plano de academia
     * @param preco O preço do plano de academia
     */
    public void setPreco(double preco) {
        this.preco = preco;
    }

    /**
     * Verifica o valor inteiro da variável
     * @return
     */
    public int getDuracaoEscolhida() {
        return duracaoEscolhida;
    }

    /**
     * Define um valor inteiro para a variável
     * @param duracaoEscolhida Duração do plano correspondendo a um mês
     */
    public void setDuracaoEscolhida(int duracaoEscolhida) {
        this.duracaoEscolhida = duracaoEscolhida;
    }

    /**
     * Define qual a duração do plano de academia contratado
     * @param opcaoEscolhida Usado para indicar qual a constante de duração escolhida
     */
    public void escolherDuracaoPlanoAcademia(int opcaoEscolhida){
        switch(opcaoEscolhida) {
            case 1 -> {
                setDuracaoEscolhida(DURACAO_UM_MES);
            }
            case 2 -> {
                setDuracaoEscolhida(DURACAO_UM_SEMESTRE);
            }
            case 3 -> {
                setDuracaoEscolhida(DURACAO_UM_ANO);
            }
            default -> {
                System.out.println("Opção inválida");
            }
        }
    }

    /**
     * Calcula o preço do plano de academia e deve ser implementado nas subclasses de PlanoAcademia
     */
    public void calcularPreco(){}

    /**
     * Retorna representação em string de um objeto do tipo PlanoAcademia
     * @return Representação em string de um objeto do tipo PlanoAcademia
     */
    @Override
    public String toString() {
        return
                "\nAcesso a Academia é " + acessoAcademia +
                "\nAcesso ao Instrutor é " + acessoInstrutor +
                "\nAcesso ao Zumba e Pilates é" + acessoZumbaPilates +
                "\nPreço = " + preco +
                '}';
    }
}
