public class Galpao {
    private int numero;
    private String identificacao;
    private String localizacao;
    private String statusFuncionamento;
    private int capacidadeTotal;
    private Doca[] docas;
    private int quantidadeDocas;

    public Galpao(int numero, String identificacao, String localizacao, String statusFuncionamento, int capacidadeTotal) {
        this.numero = numero;
        this.identificacao = identificacao;
        this.localizacao = localizacao;
        this.statusFuncionamento = statusFuncionamento;
        this.capacidadeTotal = capacidadeTotal;
        this.docas = new Doca[10];
        this.quantidadeDocas = 0;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public String getIdentificacao() {
        return identificacao;
    }

    public void setIdentificacao(String identificacao) {
        this.identificacao = identificacao;
    }

    public String getLocalizacao() {
        return localizacao;
    }

    public void setLocalizacao(String localizacao) {
        this.localizacao = localizacao;
    }

    public String getStatusFuncionamento() {
        return statusFuncionamento;
    }

    public void setStatusFuncionamento(String statusFuncionamento) {
        this.statusFuncionamento = statusFuncionamento;
    }

    public int getCapacidadeTotal() {
        return capacidadeTotal;
    }

    public void setCapacidadeTotal(int capacidadeTotal) {
        this.capacidadeTotal = capacidadeTotal;
    }

    public Doca[] getDocas() {
        return docas;
    }

    public int getQuantidadeDocas() {
        return quantidadeDocas;
    }
}
