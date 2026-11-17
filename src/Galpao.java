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

    public boolean adicionarDoca(Doca doca) {
        if (doca == null) {
            System.out.println("---------------------------------------------------------");
            System.out.println("Não é possível registrar uma doca vazia.");
            return false;
        }
        if (quantidadeDocas >= docas.length) {
            System.out.println("---------------------------------------------------------");
            System.out.println("Limite de docas atingido.");
            return false;
        }
        docas[quantidadeDocas] = doca;
        quantidadeDocas++;
        System.out.println("---------------------------------------------------------");
        System.out.println("Doca registrada com sucesso!");
        return true;
    }


    public Doca recomendarDoca(Caminhao caminhao) {
        if (caminhao == null) {
            System.out.println("---------------------------------------------------------");
            System.out.println("Um caminhão válido deve ser informado.");
            return null;
        }
        Doca melhorDoca = null;
        // Avalia as docas registradas no galpão
        if (quantidadeDocas >= 1) {
            melhorDoca = avaliarDoca(docas[0], caminhao, melhorDoca);
        }
        if (quantidadeDocas >= 2) {
            melhorDoca = avaliarDoca(docas[1], caminhao, melhorDoca);
        }
        if (quantidadeDocas >= 3) {
            melhorDoca = avaliarDoca(docas[2], caminhao, melhorDoca);
        }
        if (quantidadeDocas >= 4) {
            melhorDoca = avaliarDoca(docas[3], caminhao, melhorDoca);
        }
        if (quantidadeDocas >= 5) {
            melhorDoca = avaliarDoca(docas[4], caminhao, melhorDoca);
        }
        if (quantidadeDocas >= 6) {
            melhorDoca = avaliarDoca(docas[5], caminhao, melhorDoca);
        }
        if (quantidadeDocas >= 7) {
            melhorDoca = avaliarDoca(docas[6], caminhao, melhorDoca);
        }
        if (quantidadeDocas >= 8) {
            melhorDoca = avaliarDoca(docas[7], caminhao, melhorDoca);
        }
        if (quantidadeDocas >= 9) {
            melhorDoca = avaliarDoca(docas[8], caminhao, melhorDoca);
        }
        if (quantidadeDocas >= 10) {
            melhorDoca = avaliarDoca(docas[9], caminhao, melhorDoca);
        }
        // Verifica se alguma doca foi recomendada
        if (melhorDoca == null) {
            System.out.println("---------------------------------------------------------");
            System.out.println("Nenhuma doca compatível e disponível foi encontrada.");
            return null;
        }
        System.out.println("---------------------------------------------------------");
        System.out.println("Doca recomendada: " + melhorDoca.getNumeracao());
        System.out.println("Tempo estimado de espera: "+melhorDoca.calcularTempoEsperaTotal() + " minutos");
        return melhorDoca;
    }



    private Doca avaliarDoca(Doca docaAvaliada, Caminhao caminhao, Doca melhorDoca) {
        if (docaAvaliada == null) {
            return melhorDoca;
        }
        if (docaAvaliada.getStatusDoca() == null) {
            return melhorDoca;
        }
        if (!docaAvaliada.getStatusDoca().equalsIgnoreCase("Disponível") && !docaAvaliada.getStatusDoca().equalsIgnoreCase("Ocupada")) {
            return melhorDoca;
        }// Verifica se o status é diferente de Disponível e de Ocupada. Se for, devolve a doca anterior
        if (!docaAvaliada.verificarCompatibilidade(caminhao)) {
            return melhorDoca;
        }// Verifica se o caminhão pode descarregar naquela doca
        if (melhorDoca == null) {
            return docaAvaliada;
        }// Se ainda não existe uma doca recomendada (No caso de ser a primeira doca válida analisáda)
        double tempoAtual = docaAvaliada.calcularTempoEsperaTotal();
        double tempoMelhor = melhorDoca.calcularTempoEsperaTotal();
        if (tempoAtual < tempoMelhor) {
            return docaAvaliada;
        }
        return melhorDoca;
    }


}
