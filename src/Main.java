public class Main {
    public static void main(String[] args){
        //Teste Motorista
        System.out.println("---------------------------------------------------------");
        System.out.println("TESTE MOTORISTA");
        Motorista motorista01 = new Motorista("José", "123321", "1234545", "C", "(11) 94002-8922");
        motorista01.exibirInfos();




        System.out.println("---------------------------------------------------------");
        System.out.println("TESTE CAMINHÃO");
        //Teste Caminhao
        Caminhao caminhaoSemCarga = new Caminhao("Teste", "TESTE", "Marca", 2020, 10000);
        // Caminhão sem categoria definida
        caminhaoSemCarga.calcularTempoDescarga();
        // Categoria não reconhecida
        caminhaoSemCarga.setCargaTipo("Especial");
        caminhaoSemCarga.calcularTempoDescarga();


        Caminhao caminhao01 = new Caminhao("Jumbo", "123Placa", "Chevrollet",2005, 4000);

        caminhao01.calcularFaixaCarga(1700);
        caminhao01.calcularTempoDescarga();
        caminhao01.calcularFaixaCarga(6000);
        caminhao01.calcularTempoDescarga();
        caminhao01.calcularFaixaCarga(3002);
        caminhao01.calcularTempoDescarga();
        caminhao01.calcularFaixaCarga(-5000);
        caminhao01.calcularTempoDescarga();
        caminhao01.calcularFaixaCarga(200);
        caminhao01.calcularTempoDescarga();
        caminhao01.calcularFaixaCarga(4000);
        caminhao01.calcularTempoDescarga();
        caminhao01.setCapacidadeCarga(55000);
        caminhao01.calcularTempoDescarga();
        caminhao01.calcularFaixaCarga(9000);
        caminhao01.calcularTempoDescarga();
        caminhao01.calcularFaixaCarga(40000);
        caminhao01.calcularTempoDescarga();
        caminhao01.esvaziarCarga();
        caminhao01.calcularFaixaCarga(0);
        caminhao01.calcularTempoDescarga();
        caminhao01.calcularFaixaCarga(40000);




        //Teste Transportadora
        Transportadora transportadora01 = new Transportadora(1,"Transportes LTDA", "TransLTDA","12.345.678/0001-90","(11) 3333-4444","contato@transltda.com","RNTRC12345");

        Caminhao caminhao02 = new Caminhao("Jumbro", "123PLC", "Fiat", 1999, 50000);
        Motorista motorista02 = new Motorista("Raimundo", "123123", "1234544","C","(11) 94003-8933");
        motorista02.exibirInfos();

        transportadora01.registrarCaminhao(caminhao02);
        transportadora01.registrarMotorista(motorista02);
        transportadora01.associarMotoristaCaminhao(motorista02, caminhao02);
        motorista02.exibirInfos();
        System.out.println("---------------------------------------------------------");
        System.out.println("Motorista associado ao caminhao de placa "+caminhao02.getPlaca()+": "+caminhao02.getMotorista().getNome());

        transportadora01.setQuantidadeMotoristas(20);
        transportadora01.registrarMotorista(motorista01);
        transportadora01.setQuantidadeMotoristas(19);
        transportadora01.registrarMotorista(motorista01);
        transportadora01.registrarMotorista(motorista02);

        transportadora01.associarMotoristaCaminhao(motorista02, caminhao02);
        transportadora01.associarMotoristaCaminhao(null, caminhao02);
        transportadora01.associarMotoristaCaminhao(motorista02, null);
        transportadora01.desassociarMotoristaCaminhao(caminhao02, motorista02);
        transportadora01.desassociarMotoristaCaminhao(caminhao02, motorista02);
        transportadora01.associarMotoristaCaminhao(motorista02, null);
        transportadora01.associarMotoristaCaminhao(motorista02, caminhao02);
        transportadora01.desassociarMotoristaCaminhao(caminhao02, null);
        transportadora01.desassociarMotoristaCaminhao(null, motorista02);

        Motorista motoristaErrado = new Motorista("Outro Motorista", "999999","999999","C","(11) 99999-9999");

        transportadora01.desassociarMotoristaCaminhao(caminhao02, motoristaErrado);

        System.out.println("AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA");
        // Tentativas de registro com referências nulas
        transportadora01.registrarCaminhao(null);
        transportadora01.registrarMotorista(null);

        // Teste do limite de caminhões
        Transportadora transportadoraTeste = new Transportadora(2,"Transportadora Teste", "Teste", "00.000.000/0001-00","(11) 0000-0000", "teste@email.com", "RNTRC000");
        transportadoraTeste.setCaminhoes(new Caminhao[1]);
        transportadoraTeste.registrarCaminhao(caminhao01);
        transportadoraTeste.registrarCaminhao(caminhao02);


        //Teste Doca
        System.out.println("Teste Docaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa");
        Doca doca01 = new Doca(111, 90000, "Leve");
        System.out.println(doca01.verificarCompatibilidade(caminhao01));
        caminhao01.calcularFaixaCarga(10000);
        System.out.println(doca01.verificarCompatibilidade(caminhao01));
        doca01.setCategoriaMaximaCarga("Média");
        caminhao01.calcularFaixaCarga(10000);
        System.out.println(doca01.verificarCompatibilidade(caminhao01));
        caminhao01.calcularFaixaCarga(4000);
        System.out.println(doca01.verificarCompatibilidade(caminhao01));
        doca01.setCategoriaMaximaCarga("Pesada");
        caminhao01.calcularFaixaCarga(10000);
        System.out.println(doca01.verificarCompatibilidade(caminhao01));
        System.out.println("AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA");
        // Doca leve recebendo carga leve
        Doca docaLeve = new Doca(112, 5000, "Leve");
        caminhao01.calcularFaixaCarga(2000);
        System.out.println("Doca leve + carga leve: "+docaLeve.verificarCompatibilidade(caminhao01));
        // Doca leve rejeitando carga média
        caminhao01.calcularFaixaCarga(4000);
        System.out.println("Doca leve + carga média: "+docaLeve.verificarCompatibilidade(caminhao01));
        // Doca média recebendo carga leve
        Doca docaMedia = new Doca(113, 5000, "Média");
        caminhao01.calcularFaixaCarga(2000);
        System.out.println("Doca média + carga leve: "+docaMedia.verificarCompatibilidade(caminhao01));

        // Doca rejeitando caminhão acima da capacidade em kg
        Doca docaCapacidadeLimitada = new Doca(114, 5000,"Pesada");
        caminhao01.calcularFaixaCarga(6000);
        System.out.println("Doca com capacidade insuficiente: "+docaCapacidadeLimitada.verificarCompatibilidade(caminhao01));

        // Caminhão nulo
        System.out.println("---------------------------------------------------------");
        System.out.println("Caminhão nulo: "+doca01.verificarCompatibilidade(null));

        // Teste do cálculo de espera total
        doca01.setTempoRestanteDescargaMin(20);
        doca01.setTempoEsperaEstimadoMin(35);

        System.out.println("---------------------------------------------------------");
        System.out.println("Tempo total de espera: "+doca01.calcularTempoEsperaTotal());

    }
}
