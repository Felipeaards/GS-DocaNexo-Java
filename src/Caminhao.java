public class Caminhao {
    private String modelo;
    private String placa;
    private String marca;
    private int anoFabricacao;
    private String cpfMotorista;
    private String cargaTipo;
    private double cargaKG;
    private double capacidadeCarga;

    public Caminhao(String modelo, String placa, String marca, int anoFabricacao, String cpfMotorista, double capacidadeCarga) {
        this.modelo = modelo;
        this.placa = placa;
        this.marca = marca;
        this.anoFabricacao = anoFabricacao;
        this.cpfMotorista = cpfMotorista;
        this.capacidadeCarga = capacidadeCarga;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public int getAnoFabricacao() {
        return anoFabricacao;
    }

    public void setAnoFabricacao(int anoFabricacao) {
        this.anoFabricacao = anoFabricacao;
    }

    public String getCpfMotorista() {
        return cpfMotorista;
    }

    public void setCpfMotorista(String cpfMotorista) {
        this.cpfMotorista = cpfMotorista;
    }

    public String getCargaTipo() {
        return cargaTipo;
    }

    public void setCargaTipo(String cargaTipo) {
        System.out.println("Tipo de carga classificado como "+ cargaTipo);
        this.cargaTipo = cargaTipo;
    }

    public double getCargaKG() {
        return cargaKG;
    }

    public boolean setCargaKG(double cargaKG) {
        if(cargaKG < 0 ) {
            System.out.println("O valor de carga não pode ser menor que zero");
            return false;
        }else if(getCapacidadeCarga() < cargaKG){
            System.out.println("---------------------------------------------------------");
            System.out.println("O valor informado atinge ou ultrapassa a capacidade máxima do caminhão");
            return false;
        } else {
            this.cargaKG = cargaKG;
            System.out.println("---------------------------------------------------------");
            System.out.println("Carga atual ajustada para "+cargaKG);
            return true;
        }
    }

    public double getCapacidadeCarga() {
        return capacidadeCarga;
    }

    public void setCapacidadeCarga(double capacidadeCarga) {
        this.capacidadeCarga = capacidadeCarga;
    }

    public void calcularFaixaCarga(double cargaKG){
        if (cargaKG > 0 && cargaKG <= 3000){
            if(setCargaKG(cargaKG)){
                setCargaTipo("Leve");
            }
        } else if(cargaKG > 3000 && cargaKG <= 14000){
            if(setCargaKG(cargaKG)){
                setCargaTipo("Média");
            }
        } else if(cargaKG > 14000){
            if(setCargaKG(cargaKG)){
            setCargaTipo("Pesada");
            }
        } else{
            System.out.println("---------------------------------------------------------");
            System.out.println("O valor de carga precisa ser maior que zero");
        }
    }

    public double calcularTempoDescarga(){//Chamar Doca aqui dentro quando ela estiver pronta, para armazenar o tempo
        System.out.println("---------------------------------------------------------");
        System.out.println("Calculando tempo de descarga.....");
        double tempo = 0;
        switch(getCargaTipo()){
            case ("Leve"):
                tempo = 2 * (getCargaKG() / 1000);
                System.out.printf("O tempo de descarga do caminhão de placa %s é de %.2f minutos.%n", getPlaca(), tempo);
                break;
            case ("Média"):
                tempo = 4 * (getCargaKG() / 1000);
                System.out.printf("O tempo de descarga do caminhão de placa %s é de %.2f minutos.%n", getPlaca(), tempo);
                break;
            case ("Pesada"):
                tempo = 6 * (getCargaKG() / 1000);
                System.out.printf("O tempo de descarga do caminhão de placa %s é de %.2f minutos.%n", getPlaca(), tempo);
                break;
            default:
                System.out.println("O tipo de carga ainda não foi definido, favor calcular primeiro");
                break;
        }
        return tempo;
    }



}
