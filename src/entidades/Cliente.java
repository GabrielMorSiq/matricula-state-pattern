package entidades;

/**
 *  A classe Cliente representa a entidade cliente, que possui nome e CPF como atributos
 */
public class Cliente {
    /**
     * O nome do Cliente
     */
    private String nome;
    /**
     * O CPF do cliente
     */
    private String cpf;

    /**
     * Construtor padrão (sem argumentos) explícito do Cliente
     * Cria um novo cliente sem especificar seus atributos
     */
    public Cliente(){
    }

    /**
     * Construtor que cria um novo cliente especificando seus atributos
     * @param nome O nome do Cliente
     * @param cpf O CPF do cliente
     */
    public Cliente(String nome, String cpf) {
        this.nome = nome;
        this.cpf = cpf;
    }

    /**
     * Obtém e retorna o nome do cliente.
     * @return O nome do cliente
     */
    public String getNome() {
        return nome;
    }

    /**
     * Define o nome do cliente
     * @param nome O nome do cliente
     */
    public void setNome(String nome) {
        this.nome = nome;
    }

    /**
     * Obtém e retorna o CPF do cliente.
     * @return O CPF do cliente
     */
    public String getCpf() {
        return cpf;
    }

    /**
     * Define o nome do cliente
     * @param cpf O cpf do cliente
     */
    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    /**
     * Retorna representação em string de um objeto do tipo Cliente
     * @return Representação em string de um objeto do tipo Cliente
     */
    @Override
    public String toString() {
        return "Nome ='" + nome + '\'' +
                ", CPF = '" + cpf + '\'';
    }
}
