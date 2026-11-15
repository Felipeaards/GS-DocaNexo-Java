public class CentroDistribuicao {
    private int id;
    private String nome;
    private String cnpj;
    private String endereco;
    private String cidade;
    private Galpao[] galpoes;
    private int quantidadeGalpoes;

    public CentroDistribuicao(int id, String nome, String cnpj, String endereco, String cidade) {
        this.id = id;
        this.nome = nome;
        this.cnpj = cnpj;
        this.endereco = endereco;
        this.cidade = cidade;
        this.galpoes = new Galpao[10];
        this.quantidadeGalpoes = 0;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public Galpao[] getGalpoes() {
        return galpoes;
    }

    public void setGalpoes(Galpao[] galpoes) {
        this.galpoes = galpoes;
    }

    public int getQuantidadeGalpoes() {
        return quantidadeGalpoes;
    }

    public void setQuantidadeGalpoes(int quantidadeGalpoes) {
        this.quantidadeGalpoes = quantidadeGalpoes;
    }
}
