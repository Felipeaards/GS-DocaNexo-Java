public class Main {
    public static void main(String[] args){
        System.out.println("---------------------------------------------------------");
        System.out.println("TESTE CAMINHÃO");
        System.out.println("---------------------------------------------------------");
        //Teste Caminhao
        Caminhao caminhao01 = new Caminhao("Jumbo", "123Placa", "Chevrollet",2005, "123321", 4000);

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


        //Teste Motorista
        System.out.println("---------------------------------------------------------");
        System.out.println("TESTE MOTORISTA");
        Motorista motorista01 = new Motorista("José", "123321", "1234545", "C", "(11) 94002-8922");

        motorista01.verificarPermissaoDescarga();
        motorista01.verificarPermissaoDescarga();
        motorista01.solicitarRedirecionamento();
        motorista01.setPermissaoDescarga(true);
        motorista01.verificarPermissaoDescarga();
        motorista01.realizarDescarga(caminhao01);

        caminhao01.calcularTempoDescarga();
        System.out.println(caminhao01.getCargaKG()+" "+ caminhao01.getCargaTipo());
        caminhao01.calcularFaixaCarga(9000);
        caminhao01.calcularTempoDescarga();




    }
}
