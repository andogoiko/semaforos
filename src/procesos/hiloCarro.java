package procesos;

import clases.Parking;

import java.util.Random;

import static java.lang.Thread.sleep;

public class hiloCarro implements Runnable{

    private Parking plaza;
    private String modeloCarro;

    public hiloCarro(Parking plaza, String modeloCarro){
        this.plaza = plaza;
        this.modeloCarro = modeloCarro;
    }

    @Override
    public void run(){
        Random ran = new Random();

        try {
            plaza.entrar(modeloCarro);

            int tiempoAparcado = (ran.nextInt(11 - 5) + 5) * 1000;

            sleep(tiempoAparcado);

            plaza.salir(modeloCarro);

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
