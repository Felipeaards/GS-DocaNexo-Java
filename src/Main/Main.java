
package Main;

import docanexo.centroDeDistribuicao.CentroDistribuicao;
import docanexo.centroDeDistribuicao.Doca;
import docanexo.centroDeDistribuicao.Galpao;
import docanexo.transportadora.Caminhao;
import docanexo.transportadora.Motorista;
import docanexo.transportadora.Transportadora;

public class Main {

    public static void main(String[] args) {

        // =====================================================
        // 1. TESTES DA CLASSE MOTORISTA
        // =====================================================

        System.out.println("---------------------------------------------------------");
        System.out.println("TESTE MOTORISTA");

        // Criação de um motorista e exibição de suas informações
        Motorista motorista01 = new Motorista("José", "123321", "1234545", "C", "(11) 94002-8922");
        motorista01.exibirInfos();


        // =====================================================
        // 2. TESTES DA CLASSE CAMINHAO
        // =====================================================

        System.out.println("---------------------------------------------------------");
        System.out.println("TESTE CAMINHÃO");

        // Teste de caminhão sem categoria de carga definida
        Caminhao caminhaoSemCarga = new Caminhao("Teste", "TESTE", "Marca", 2020, 10000);
        caminhaoSemCarga.calcularTempoDescarga();

        // Teste com categoria de carga não reconhecida
        caminhaoSemCarga.setCargaTipo("Especial");
        caminhaoSemCarga.calcularTempoDescarga();

        // Criação do caminhão principal utilizado nos testes
        Caminhao caminhao01 = new Caminhao("Jumbo", "123Placa", "Chevrollet", 2005, 4000);

        // Teste de classificação de carga leve e cálculo do tempo de descarga
        caminhao01.calcularFaixaCarga(1700);
        caminhao01.calcularTempoDescarga();
        // Teste de carga acima da capacidade inicial do caminhão
        caminhao01.calcularFaixaCarga(6000);
        caminhao01.calcularTempoDescarga();
        // Teste de classificação de carga média
        caminhao01.calcularFaixaCarga(3002);
        caminhao01.calcularTempoDescarga();
        // Teste com peso negativo
        caminhao01.calcularFaixaCarga(-5000);
        caminhao01.calcularTempoDescarga();
        // Novo teste com carga leve
        caminhao01.calcularFaixaCarga(200);
        caminhao01.calcularTempoDescarga();
        // Teste com carga média
        caminhao01.calcularFaixaCarga(4000);
        caminhao01.calcularTempoDescarga();
        // Aumento da capacidade do caminhão
        caminhao01.setCapacidadeCarga(55000);
        caminhao01.calcularTempoDescarga();

        // Teste com uma carga média maior
        caminhao01.calcularFaixaCarga(9000);
        caminhao01.calcularTempoDescarga();
        // Teste de classificação de carga pesada
        caminhao01.calcularFaixaCarga(40000);
        caminhao01.calcularTempoDescarga();
        // Esvaziamento da carga e teste com valor zero
        caminhao01.esvaziarCarga();
        caminhao01.calcularFaixaCarga(0);
        caminhao01.calcularTempoDescarga();
        // Nova classificação de carga pesada para os testes seguintes
        caminhao01.calcularFaixaCarga(40000);


        // =====================================================
        // 3. TESTES DA CLASSE TRANSPORTADORA
        // =====================================================

        System.out.println("---------------------------------------------------------");
        System.out.println("TESTE TRANSPORTADORA");

        // Criação da transportadora, de um caminhão e de seu motorista
        Transportadora transportadora01 = new Transportadora(1, "Transportes LTDA", "TransLTDA", "12.345.678/0001-90", "(11) 3333-4444", "contato@transltda.com", "RNTRC12345");
        Caminhao caminhao02 = new Caminhao("Jumbro", "123PLC", "Fiat", 1999, 50000);
        Motorista motorista02 = new Motorista("Raimundo", "123123", "1234544", "C", "(11) 94003-8933");

        // Exibição inicial das informações do motorista
        motorista02.exibirInfos();

        // Registro do caminhão e do motorista na transportadora
        transportadora01.registrarCaminhao(caminhao02);
        transportadora01.registrarMotorista(motorista02);

        // Associação entre o motorista e o caminhão
        transportadora01.associarMotoristaCaminhao(motorista02, caminhao02);

        // Exibição das informações após a associação
        motorista02.exibirInfos();
        System.out.println("---------------------------------------------------------");
        System.out.println("Motorista associado ao caminhão de placa " + caminhao02.getPlaca() + ": " + caminhao02.getMotorista().getNome());

        // Teste do limite máximo de motoristas cadastrados
        transportadora01.setQuantidadeMotoristas(20);
        transportadora01.registrarMotorista(motorista01);

        // Retorno da quantidade para testar o cadastro na última posição
        transportadora01.setQuantidadeMotoristas(19);
        transportadora01.registrarMotorista(motorista01);

        // Nova tentativa de cadastro com o array cheio
        transportadora01.registrarMotorista(motorista02);

        // Testes de associação e desassociação entre motorista e caminhão
        transportadora01.associarMotoristaCaminhao(motorista02, caminhao02);
        transportadora01.associarMotoristaCaminhao(null, caminhao02);
        transportadora01.associarMotoristaCaminhao(motorista02, null);

        // Teste de desassociação válida e tentativa de repetir a operação
        transportadora01.desassociarMotoristaCaminhao(caminhao02, motorista02);
        transportadora01.desassociarMotoristaCaminhao(caminhao02, motorista02);

        // Nova tentativa de associação com referência nula e depois associação válida
        transportadora01.associarMotoristaCaminhao(motorista02, null);
        transportadora01.associarMotoristaCaminhao(motorista02, caminhao02);

        // Testes de desassociação com referências nulas
        transportadora01.desassociarMotoristaCaminhao(caminhao02, null);
        transportadora01.desassociarMotoristaCaminhao(null, motorista02);

        // Teste de desassociação com um motorista diferente do associado
        Motorista motoristaErrado = new Motorista("Outro Motorista", "999999", "999999", "C", "(11) 99999-9999");
        transportadora01.desassociarMotoristaCaminhao(caminhao02, motoristaErrado);

        // Testes de registro com referências nulas
        transportadora01.registrarCaminhao(null);
        transportadora01.registrarMotorista(null);

        // Teste do limite de caminhões utilizando um array com apenas uma posição
        Transportadora transportadoraTeste = new Transportadora(2, "Transportadora Teste", "Teste", "00.000.000/0001-00", "(11) 0000-0000", "teste@email.com", "RNTRC000");
        transportadoraTeste.setCaminhoes(new Caminhao[1]);

        // Primeiro registro aceito e segundo registro rejeitado
        transportadoraTeste.registrarCaminhao(caminhao01);
        transportadoraTeste.registrarCaminhao(caminhao02);


        // =====================================================
        // 4. TESTES DA CLASSE DOCA
        // =====================================================

        System.out.println("---------------------------------------------------------");
        System.out.println("TESTE DOCA");

        // Criação de uma doca com capacidade para 90.000 kg
        Doca doca01 = new Doca(1, 90000, "Leve");
        // Teste inicial sem carga classificada no caminhão
        System.out.println(doca01.verificarCompatibilidade(caminhao01));
        // Teste de rejeição de carga média por uma doca leve
        caminhao01.calcularFaixaCarga(10000);
        System.out.println(doca01.verificarCompatibilidade(caminhao01));
        // Alteração da categoria máxima da doca para Média
        doca01.setCategoriaMaximaCarga("Média");
        caminhao01.calcularFaixaCarga(10000);
        System.out.println(doca01.verificarCompatibilidade(caminhao01));
        // Teste de aceitação de carga média
        caminhao01.calcularFaixaCarga(4000);
        System.out.println(doca01.verificarCompatibilidade(caminhao01));
        // Alteração da categoria máxima da doca para Pesada
        doca01.setCategoriaMaximaCarga("Pesada");
        caminhao01.calcularFaixaCarga(10000);
        System.out.println(doca01.verificarCompatibilidade(caminhao01));
        // Teste de doca leve recebendo carga leve
        Doca docaLeve = new Doca(112, 5000, "Leve");
        caminhao01.calcularFaixaCarga(2000);
        System.out.println("Doca leve + carga leve: " + docaLeve.verificarCompatibilidade(caminhao01));
        // Teste de rejeição de carga média por uma doca leve
        caminhao01.calcularFaixaCarga(4000);//
        System.out.println("Doca leve + carga média: " + docaLeve.verificarCompatibilidade(caminhao01));

        // Teste de doca média recebendo carga leve
        Doca docaMedia = new Doca(113, 5000, "Média");
        caminhao01.calcularFaixaCarga(2000);
        System.out.println("Doca média + carga leve: " + docaMedia.verificarCompatibilidade(caminhao01));
        // Teste de rejeição por capacidade em kg insuficiente
        Doca docaCapacidadeLimitada = new Doca(114, 5000, "Pesada");
        caminhao01.calcularFaixaCarga(6000);
        System.out.println("Doca com capacidade insuficiente: " + docaCapacidadeLimitada.verificarCompatibilidade(caminhao01));
        // Teste de compatibilidade com caminhão nulo
        System.out.println("---------------------------------------------------------");
        System.out.println("Caminhão nulo: " + doca01.verificarCompatibilidade(null));
        // Teste do cálculo do tempo total de espera
        doca01.setTempoRestanteDescargaMin(20);
        doca01.setTempoEsperaEstimadoMin(35);
        System.out.println("---------------------------------------------------------");
        System.out.println("Tempo total de espera: " + doca01.calcularTempoEsperaTotal());


        // =====================================================
        // 5. TESTES DA CLASSE GALPAO
        // =====================================================

        System.out.println("---------------------------------------------------------");
        System.out.println("TESTE GALPAO");

        // Criação do primeiro galpão e adição da primeira doca
        Galpao galpao01 = new Galpao(1, "Galpão 1", "Centro de Distribuição Alberto", "Disponível");
        galpao01.adicionarDoca(doca01);

        // Segunda doca: compatível com o caminhão e com espera de 15 minutos
        Doca doca02 = new Doca(2, 15000, "Média");
        doca02.setStatusDoca("Ocupada");
        doca02.setTempoRestanteDescargaMin(10);
        doca02.setTempoEsperaEstimadoMin(5);
        galpao01.adicionarDoca(doca02);

        // Terceira doca: menor espera, mas incompatível com a carga média
        Doca doca03 = new Doca(3, 15000, "Leve");
        doca03.setTempoRestanteDescargaMin(1);
        galpao01.adicionarDoca(doca03);

        // Teste de recomendação da melhor doca do galpão
        System.out.println("---------------------------------------------------------");
        System.out.println("TESTE DE RECOMENDACAO DE DOCA");
        System.out.println("Doca recomendada pelo galpão: " + galpao01.recomendarDoca(caminhao01).getNumeracao());

        // Teste de recomendação com caminhão nulo
        System.out.println("---------------------------------------------------------");
        System.out.println("TESTE DE CAMINHAO NULO NO GALPAO");
        System.out.println("Resultado: " + galpao01.recomendarDoca(null));

        // Criação de um galpão que não possui doca compatível
        Galpao galpaoSemDocaCompativel = new Galpao(124, "Galpão sem doca compatível", "Unidade de teste", "Disponível");
        Doca docaSomenteLeve = new Doca(119, 15000, "Leve");
        galpaoSemDocaCompativel.adicionarDoca(docaSomenteLeve);

        // Teste de recomendação sem doca compatível
        System.out.println("---------------------------------------------------------");
        System.out.println("TESTE DE GALPAO SEM DOCA COMPATIVEL");
        System.out.println("Resultado: " + galpaoSemDocaCompativel.recomendarDoca(caminhao01));

        // Teste de registro de doca nula
        System.out.println("---------------------------------------------------------");
        System.out.println("TESTE DE REGISTRO DE DOCA NULA");
        galpao01.adicionarDoca(null);


        // =====================================================
        // 6. TESTES DA CLASSE CENTRODISTRIBUICAO
        // =====================================================

        System.out.println("---------------------------------------------------------");
        System.out.println("TESTE CENTRO DE DISTRIBUICAO");

        // Criação do Centro de Distribuição
        CentroDistribuicao centro01 = new CentroDistribuicao(1, "CD Principal", "12.345.678/0001-90", "Rua das Docas, 100", "São Paulo");

        // Criação do segundo galpão e de uma doca com espera de 8 minutos
        Galpao galpao02 = new Galpao(2, "Galpão 2", "Centro de Distribuição Alberto", "Disponível");
        Doca doca04 = new Doca(4, 15000, "Média");
        doca04.setStatusDoca("Ocupada");
        doca04.setTempoRestanteDescargaMin(2);
        doca04.setTempoEsperaEstimadoMin(6);
        galpao02.adicionarDoca(doca04);

        // Criação de um terceiro galpão em manutenção
        Galpao galpao03 = new Galpao(3, "Galpão em manutenção", "Centro de Distribuição Alberto", "Manutenção");

        // Adição de uma doca compatível ao galpão em manutenção
        Doca doca05 = new Doca(5, 15000, "Pesada");
        galpao03.adicionarDoca(doca05);

        // Registro dos três galpões no Centro de Distribuição
        centro01.registrarGalpao(galpao01);
        centro01.registrarGalpao(galpao02);
        centro01.registrarGalpao(galpao03);

        // Teste de recomendação do melhor galpão e de sua doca
        System.out.println("---------------------------------------------------------");
        System.out.println("TESTE DE RECOMENDACAO DE GALPAO");
        centro01.recomendarGalpao(caminhao01);
        // Teste de recomendação com caminhão nulo
        System.out.println("---------------------------------------------------------");
        System.out.println("TESTE DE CAMINHAO NULO NO CENTRO");
        centro01.recomendarGalpao(null);
        // Criação de um Centro de Distribuição sem galpões operacionais
        CentroDistribuicao centroSemOpcao = new CentroDistribuicao(2, "CD sem galpao operacional", "00.000.000/0001-00", "Rua Teste, 200", "São Paulo");
        // Registro do galpão que está em manutenção
        centroSemOpcao.registrarGalpao(galpao03);
        // Teste de recomendação quando nenhum galpão está disponível
        System.out.println("---------------------------------------------------------");
        System.out.println("TESTE DE CENTRO SEM GALPAO DISPONIVEL");
        centroSemOpcao.recomendarGalpao(caminhao01);

        // Teste de registro de galpão nulo
        System.out.println("---------------------------------------------------------");
        System.out.println("TESTE DE REGISTRO DE GALPAO NULO");
        centro01.registrarGalpao(null);

    }
}
