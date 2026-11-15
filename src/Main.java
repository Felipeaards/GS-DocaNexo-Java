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
        transportadora01.registrarMotorista(motorista02);
        transportadora01.setQuantidadeMotoristas(19);
        transportadora01.registrarMotorista(motorista02);
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



    }
}
