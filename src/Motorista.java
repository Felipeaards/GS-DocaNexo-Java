public class Motorista {
    private String nome;
    private String cpf;
    private String cnh;
    private String categoriaCNH;
    private String telefone;
    private boolean permissaoDescarga;

    public Motorista(String nome, String cpf, String cnh, String categoriaCNH, String telefone) {
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

    public boolean getPermissaoDescarga() {
        return permissaoDescarga;
    }

    public void setPermissaoDescarga(boolean permissaoDescarga) {
        this.permissaoDescarga = permissaoDescarga;
    }

    public boolean realizarDescarga(Caminhao caminhao){
        if(verificarPermissaoDescarga()){
            System.out.println("---------------------------------------------------------");
            System.out.println("Realizando descarga......");
            caminhao.setCargaKG(0);
            caminhao.setCargaTipo("vazio");
            System.out.println("Carga descarregada com sucesso!");
            return true;
        } else{
            System.out.println("---------------------------------------------------------");
            System.out.println("Não é possível realizar a descarga: não foi recebida autorização");
            return false;
        }
    }

    public boolean verificarPermissaoDescarga(){
        if(permissaoDescarga){
            System.out.println("---------------------------------------------------------");
            System.out.println("O motorista está autorizado a descarregar a carga");
            return true;
        } else{
            System.out.println("---------------------------------------------------------");
            System.out.println("O motorista ainda não foi autorizado a realizar a descarga, favor aguarde na fila");
            //chamar função para exibir o tempo de espera aproximado
            return false;
        }
    }

    public void solicitarRedirecionamento(){
        System.out.println("---------------------------------------------------------");
        System.out.println("Solicitando redirecionamento a Transportadora...........");
        //Adicionar comunicação com a Transportadora aqui depois
    }

}
