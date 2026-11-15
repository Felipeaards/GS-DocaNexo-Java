
public class Caminhao {
    private String modelo;
    private String placa;
    private String marca;
    private int anoFabricacao;
    private Motorista motorista;
    private String cargaTipo;
    private double cargaKG;
    private double capacidadeCarga;

    public Caminhao(String modelo, String placa, String marca,
                    int anoFabricacao, double capacidadeCarga) {
        this.modelo = modelo;
        this.placa = placa;
        this.marca = marca;
        this.anoFabricacao = anoFabricacao;
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

    public Motorista getMotorista() {
        return motorista;
    }

    public void setMotorista(Motorista motorista) {
        this.motorista = motorista;
    }

    public String getCargaTipo() {
        return cargaTipo;
    }

    public void setCargaTipo(String cargaTipo) {
        System.out.println("Tipo de carga classificado como " + cargaTipo);
        this.cargaTipo = cargaTipo;
    }

    public double getCargaKG() {
        return cargaKG;
    }

    public boolean setCargaKG(double cargaKG) {
        if (cargaKG < 0) {
            System.out.println("O valor de carga não pode ser menor que zero.");
            return false;
        } else if (cargaKG > getCapacidadeCarga()) {
            System.out.println("---------------------------------------------------------");
            System.out.println("O valor informado ultrapassa a capacidade máxima do caminhão.");
            return false;
        } else {
            this.cargaKG = cargaKG;
            System.out.println("---------------------------------------------------------");
            System.out.println("Carga atual ajustada para " + cargaKG);
            return true;
        }
    }

    public double getCapacidadeCarga() {
        return capacidadeCarga;
    }

    public void setCapacidadeCarga(double capacidadeCarga) {
        this.capacidadeCarga = capacidadeCarga;
    }

    public void calcularFaixaCarga(double cargaKG) {
        if (cargaKG > 0 && cargaKG <= 3000) {
            if (setCargaKG(cargaKG)) {
                setCargaTipo("Leve");
            }
        } else if (cargaKG > 3000 && cargaKG <= 14000) {
            if (setCargaKG(cargaKG)) {
                setCargaTipo("Média");
            }
        } else if (cargaKG > 14000) {
            if (setCargaKG(cargaKG)) {
                setCargaTipo("Pesada");
            }
        } else {
            System.out.println("---------------------------------------------------------");
            System.out.println("O valor de carga precisa ser maior que zero.");
        }
    }

    public double calcularTempoDescarga() {
        System.out.println("---------------------------------------------------------");
        System.out.println("Calculando tempo de descarga.....");
        double tempo = 0;
        if (getCargaTipo() == null) {
            System.out.println("O tipo de carga ainda não foi definido, favor calcular primeiro.");
            return 0;
        }
        switch (getCargaTipo()) {
            case "Leve":
                tempo = 2 * (getCargaKG() / 1000.0);
                break;
            case "Média":
                tempo = 4 * (getCargaKG() / 1000.0);
                break;
            case "Pesada":
                tempo = 6 * (getCargaKG() / 1000.0);
                break;
            case "Vazio":
                System.out.println("O caminhão está vazio. Não há tempo de descarga.");
                break;
            default:
                System.out.println("O tipo de carga não foi reconhecido.");
                break;
        }
        if (tempo > 0) {
            System.out.printf("O tempo de descarga do caminhão de placa %s é de %.2f minutos.%n",getPlaca(), tempo);
        }
        return tempo;
    }

    public void esvaziarCarga() {
        System.out.println("---------------------------------------------------------");
        setCargaKG(0);
        setCargaTipo("Vazio");
        System.out.println("Carga do caminhão esvaziada!");
    }
}
