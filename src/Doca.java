public class Doca {
    private int numeracao;
    private double capacidadeKG;
    private String categoriaMaximaCarga;
    private String statusDoca;
    private int nivelMovimento;
    private int tamanhoFila;
    private double tempoRestanteDescargaMin;
    private double tempoEsperaEstimadoMin;

    public Doca(int numeracao, double capacidadeKG, String categoriaMaximaCarga) {
        this.numeracao = numeracao;
        this.capacidadeKG = capacidadeKG;
        this.categoriaMaximaCarga = categoriaMaximaCarga;
        this.statusDoca = "Disponível";
        this.nivelMovimento = 0;
        this.tamanhoFila = 0;
        this.tempoRestanteDescargaMin = 0.0;
        this.tempoEsperaEstimadoMin = 0.0;
    }

    public int getNumeracao() {
        return numeracao;
    }

    public void setNumeracao(int numeracao) {
        this.numeracao = numeracao;
    }

    public double getCapacidadeKG() {
        return capacidadeKG;
    }

    public void setCapacidadeKG(double capacidadeKG) {
        this.capacidadeKG = capacidadeKG;
    }

    public String getStatusDoca() {
        return statusDoca;
    }

    public void setStatusDoca(String statusDoca) {
        this.statusDoca = statusDoca;
    }

    public int getNivelMovimento() {
        return nivelMovimento;
    }

    public void setNivelMovimento(int nivelMovimento) {
        this.nivelMovimento = nivelMovimento;
    }

    public int getTamanhoFila() {
        return tamanhoFila;
    }

    public double getTempoRestanteDescargaMin() {
        return tempoRestanteDescargaMin;
    }

    public void setTempoRestanteDescargaMin(double tempoRestanteDescargaMin) {
        this.tempoRestanteDescargaMin = tempoRestanteDescargaMin;
    }

    public double getTempoEsperaEstimadoMin() {
        return tempoEsperaEstimadoMin;
    }

    public void setTempoEsperaEstimadoMin(double tempoEsperaEstimadoMin) {
        this.tempoEsperaEstimadoMin = tempoEsperaEstimadoMin;
    }

    public String getCategoriaMaximaCarga() {
        return categoriaMaximaCarga;
    }

    public void setCategoriaMaximaCarga(String categoriaMaximaCarga) {
        this.categoriaMaximaCarga = categoriaMaximaCarga;
    }

    public void setTamanhoFila(int tamanhoFila) {
        this.tamanhoFila = tamanhoFila;
    }

    public boolean verificarCompatibilidade(Caminhao caminhao) {
        if (caminhao == null) {
            return false;
        }
        if (categoriaMaximaCarga == null || caminhao.getCargaTipo() == null) {
            return false;
        }
        if (!caminhao.getCargaTipo().equalsIgnoreCase("Leve") &&
                !caminhao.getCargaTipo().equalsIgnoreCase("Média") &&
                !caminhao.getCargaTipo().equalsIgnoreCase("Pesada")) {
            return false;
        }
        if (caminhao.getCargaKG() <= 0) {
            return false;
        }
        if (caminhao.getCargaKG() > capacidadeKG) {
            return false;
        }
        if (categoriaMaximaCarga.equalsIgnoreCase("Pesada")) {
            return true;
        }
        else if (categoriaMaximaCarga.equalsIgnoreCase("Média")) {
            return caminhao.getCargaTipo().equalsIgnoreCase("Média") || caminhao.getCargaTipo().equalsIgnoreCase("Leve");
        }

        else if (categoriaMaximaCarga.equalsIgnoreCase("Leve")) {
            return caminhao.getCargaTipo().equalsIgnoreCase("Leve");
        }

        return false;
    }

    public double calcularTempoEsperaTotal(){
        return getTempoEsperaEstimadoMin() + getTempoRestanteDescargaMin();
    }
}
