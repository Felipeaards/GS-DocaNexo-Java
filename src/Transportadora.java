
public class Transportadora {
    private int id;
    private String razaoSocial;
    private String nomeFantasia;
    private String cnpj;
    private String telefone;
    private String email;
    private String rntrc;
    private Motorista[] motoristas;
    private Caminhao[] caminhoes;
    private int quantidadeCaminhoes = 0;
    private int quantidadeMotoristas = 0;

    public Transportadora(int id, String razaoSocial, String nomeFantasia, String cnpj, String telefone, String email, String rntrc) {
        this.id = id;
        this.razaoSocial = razaoSocial;
        this.nomeFantasia = nomeFantasia;
        this.cnpj = cnpj;
        this.telefone = telefone;
        this.email = email;
        this.rntrc = rntrc;
        this.motoristas = new Motorista[20];
        this.caminhoes = new Caminhao[20];
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getRazaoSocial() {
        return razaoSocial;
    }

    public void setRazaoSocial(String razaoSocial) {
        this.razaoSocial = razaoSocial;
    }

    public String getNomeFantasia() {
        return nomeFantasia;
    }

    public void setNomeFantasia(String nomeFantasia) {
        this.nomeFantasia = nomeFantasia;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getRntrc() {
        return rntrc;
    }

    public void setRntrc(String rntrc) {
        this.rntrc = rntrc;
    }

    public Motorista[] getMotoristas() {
        return motoristas;
    }

    public void setMotoristas(Motorista[] motoristas) {
        this.motoristas = motoristas;
    }

    public Caminhao[] getCaminhoes() {
        return caminhoes;
    }

    public void setCaminhoes(Caminhao[] caminhoes) {
        this.caminhoes = caminhoes;
    }

    public int getQuantidadeCaminhoes() {
        return quantidadeCaminhoes;
    }

    public void setQuantidadeCaminhoes(int quantidadeCaminhoes) {
        this.quantidadeCaminhoes = quantidadeCaminhoes;
    }

    public int getQuantidadeMotoristas() {
        return quantidadeMotoristas;
    }

    public void setQuantidadeMotoristas(int quantidadeMotoristas) {
        this.quantidadeMotoristas = quantidadeMotoristas;
    }

    public boolean registrarCaminhao(Caminhao caminhao) {
        if (caminhao == null) {
            System.out.println("---------------------------------------------------------");
            System.out.println("Não é possível registrar um caminhão vazio.");
            return false;
        }
        if (quantidadeCaminhoes >= caminhoes.length) {
            System.out.println("---------------------------------------------------------");
            System.out.println("Limite de caminhões atingido.");
            return false;
        }
        caminhoes[quantidadeCaminhoes] = caminhao;
        quantidadeCaminhoes++;
        System.out.println("---------------------------------------------------------");
        System.out.println("Caminhão registrado com sucesso!");
        return true;
    }

    public boolean registrarMotorista(Motorista motorista) {
        if (motorista == null) {
            System.out.println("---------------------------------------------------------");
            System.out.println("Não é possível registrar um motorista vazio.");
            return false;
        }
        if (quantidadeMotoristas >= motoristas.length) {
            System.out.println("---------------------------------------------------------");
            System.out.println("Limite de motoristas atingido.");
            return false;
        }
        motoristas[quantidadeMotoristas] = motorista;
        quantidadeMotoristas++;
        System.out.println("---------------------------------------------------------");
        System.out.println("Motorista registrado com sucesso!");
        return true;
    }

    public boolean associarMotoristaCaminhao(Motorista motorista, Caminhao caminhao) {
        if (motorista == null || caminhao == null) {
            System.out.println("---------------------------------------------------------");
            System.out.println("O motorista ou o caminhão não podem estar vazios.");
            return false;
        }
        if (motorista.getTemCaminhao() || caminhao.getMotorista() != null) {
            System.out.println("---------------------------------------------------------");
            System.out.println("O motorista ou o caminhão já possui uma associação.");
            return false;
        }
        caminhao.setMotorista(motorista);
        motorista.setTemCaminhao(true);
        System.out.println("---------------------------------------------------------");
        System.out.println("Motorista "+motorista.getNome()+" adicionado ao caminhão.");
        return true;
    }

    public boolean desassociarMotoristaCaminhao(Caminhao caminhao, Motorista motorista) {
        if (caminhao == null || motorista == null) {
            System.out.println("---------------------------------------------------------");
            System.out.println("O motorista ou o caminhão não podem estar vazios.");
            return false;
        }
        if (caminhao.getMotorista() != motorista) {
            System.out.println("---------------------------------------------------------");
            System.out.println("Esse motorista não está associado a esse caminhão.");
            return false;
        }
        caminhao.setMotorista(null);
        motorista.setTemCaminhao(false);
        System.out.println("---------------------------------------------------------");
        System.out.println("O motorista "+motorista.getNome()+" foi desvinculado do caminhão.");
        return true;
    }
}
