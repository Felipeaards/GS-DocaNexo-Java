package docanexo.transportadora;

public class Motorista {
    private String nome;
    private String cpf;
    private String cnh;
    private String categoriaCNH;
    private String telefone;
    private boolean temCaminhao;

    public Motorista(String nome, String cpf, String cnh,
                     String categoriaCNH, String telefone) {
        this.nome = nome;
        this.cpf = cpf;
        this.cnh = cnh;
        this.categoriaCNH = categoriaCNH;
        this.telefone = telefone;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getCnh() {
        return cnh;
    }

    public void setCnh(String cnh) {
        this.cnh = cnh;
    }

    public String getCategoriaCNH() {
        return categoriaCNH;
    }

    public void setCategoriaCNH(String categoriaCNH) {
        this.categoriaCNH = categoriaCNH;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public boolean getTemCaminhao() {
        return temCaminhao;
    }

    public void setTemCaminhao(boolean temCaminhao) {
        this.temCaminhao = temCaminhao;
    }

    public void exibirInfos() {
        System.out.println("---------------------------------------------------------");
        System.out.println("Relatório de dados do motorista");
        System.out.println("Nome: " + getNome());
        System.out.println("CPF: " + getCpf());
        System.out.println("CNH: " + getCnh());
        System.out.println("Categoria da CNH: " + getCategoriaCNH());
        System.out.println("Telefone: " + getTelefone());
        System.out.println("Tem caminhão associado? " + getTemCaminhao());
    }
}
