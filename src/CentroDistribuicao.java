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

    public boolean registrarGalpao(Galpao galpao) {
        if (galpao == null) {
            System.out.println("---------------------------------------------------------");
            System.out.println("Não é possível registrar um galpão vazio.");
            return false;
        }
        if (quantidadeGalpoes >= galpoes.length) {
            System.out.println("---------------------------------------------------------");
            System.out.println("Limite de galpões atingido.");
            return false;
        }
        galpoes[quantidadeGalpoes] = galpao;
        quantidadeGalpoes++;
        System.out.println("---------------------------------------------------------");
        System.out.println("Galpão registrado com sucesso!");
        return true;
    }

    public Galpao recomendarGalpao(Caminhao caminhao) {
        if (caminhao == null) {
            System.out.println("---------------------------------------------------------");
            System.out.println("Um caminhão válido deve ser informado.");
            return null;
        }
        Galpao melhorGalpao = null;
        // Avalia as docas registradas no galpão
        if (quantidadeGalpoes >= 1) {
            melhorGalpao = avaliarGalpao(galpoes[0], caminhao, melhorGalpao);
        }
        if (quantidadeGalpoes >= 2) {
            melhorGalpao = avaliarGalpao(galpoes[1], caminhao, melhorGalpao);
        }
        if (quantidadeGalpoes >= 3) {
            melhorGalpao = avaliarGalpao(galpoes[2], caminhao, melhorGalpao);
        }
        if (quantidadeGalpoes >= 4) {
            melhorGalpao = avaliarGalpao(galpoes[3], caminhao, melhorGalpao);
        }
        if (quantidadeGalpoes >= 5) {
            melhorGalpao = avaliarGalpao(galpoes[4], caminhao, melhorGalpao);
        }
        if (quantidadeGalpoes >= 6) {
            melhorGalpao = avaliarGalpao(galpoes[5], caminhao, melhorGalpao);
        }
        if (quantidadeGalpoes >= 7) {
            melhorGalpao = avaliarGalpao(galpoes[6], caminhao, melhorGalpao);
        }
        if (quantidadeGalpoes >= 8) {
            melhorGalpao = avaliarGalpao(galpoes[7], caminhao, melhorGalpao);
        }
        if (quantidadeGalpoes >= 9) {
            melhorGalpao = avaliarGalpao(galpoes[8], caminhao, melhorGalpao);
        }
        if (quantidadeGalpoes >= 10) {
            melhorGalpao = avaliarGalpao(galpoes[9], caminhao, melhorGalpao);
        }
        // Verifica se alguma doca foi recomendada
        if (melhorGalpao == null) {
            System.out.println("---------------------------------------------------------");
            System.out.println("Nenhum galpão compatível e disponível foi encontrada.");
            return null;
        }
        System.out.println("---------------------------------------------------------");
        System.out.println("Galpão recomendado: " + melhorGalpao.getIdentificacao());
        System.out.println("Tempo estimado de espera: "+melhorGalpao.calcularTempoEsperaTotal() + " minutos");
        return melhorGalpao;
    }



    private Galpao avaliarGalpao(Galpao galpaoAvaliado, Caminhao caminhao, Galpao melhorGalpao) {
        if (galpaoAvaliado == null) {
            return melhorGalpao;
        }
        if (galpaoAvaliado.getStatusFuncionamento() == null) {
            return melhorGalpao;
        }
        if (!galpaoAvaliado.getStatusFuncionamento().equalsIgnoreCase("Disponível") && !galpaoAvaliado.getStatusFuncionamento().equalsIgnoreCase("Ocupada")) {
            return melhorGalpao;
        }// Verifica se o status é diferente de Disponível e de Ocupada. Se for, devolve a doca anterior
        Doca docaAtual = galpaoAvaliado.recomendarDoca(caminhao);
        if (melhorGalpao == null) {
            return galpaoAvaliado;
        }// Se ainda não existe uma doca recomendada (No caso de ser a primeira doca válida analisáda)
        double tempoAtual = galpaoAvaliado.calcularTempoEsperaTotal();
        double tempoMelhor = melhorGalpao.calcularTempoEsperaTotal();
        if (tempoAtual < tempoMelhor) {
            return galpaoAvaliado;
        }
        return melhorGalpao;
    }


    private Galpao avaliarGalpao(Galpao galpaoAvaliado, Caminhao caminhao, Galpao melhorGalpao) {
        if (galpaoAvaliado == null) {
            return melhorGalpao;
        }
        if (galpaoAvaliado.getStatusFuncionamento() == null) {
            return melhorGalpao;
        }
        if (!galpaoAvaliado.getStatusFuncionamento().equalsIgnoreCase("Disponível") &&
                !galpaoAvaliado.getStatusFuncionamento().equalsIgnoreCase("Ocupada")) {
            return melhorGalpao;
        }
        // Solicita ao galpão a melhor doca para o caminhão
        Doca docaAtual = galpaoAvaliado.recomendarDoca(caminhao);
        // Se o galpão não encontrou uma doca adequada, ele é descartado
        if (docaAtual == null) {
            return melhorGalpao;
        }
        // Se ainda não existe um galpão recomendado
        if (melhorGalpao == null) {
            return galpaoAvaliado;
        }
        // Consulta a doca recomendada pelo melhor galpão anterior
        Doca docaMelhor = melhorGalpao.recomendarDoca(caminhao);
        if (docaMelhor == null) {
            return galpaoAvaliado;
        }
        // Compara os tempos de espera das duas docas
        double tempoAtual = docaAtual.calcularTempoEsperaTotal();
        double tempoMelhor = docaMelhor.calcularTempoEsperaTotal();
        if (tempoAtual < tempoMelhor) {
            return galpaoAvaliado;
        }
        return melhorGalpao;
    }

}
