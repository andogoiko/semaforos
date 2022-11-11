package clases;

import clases.Lock;
import clases.Semaforo;

public class Parking {

    private final int NUM_PLAZAS = 5;
    private int plazasLibres = NUM_PLAZAS;

    Semaforo semaforo = new Semaforo(NUM_PLAZAS);
    Lock lock = new Lock();

    public void entrar(String modeloCarro){
        semaforo.adquirir();
        lock.adquirir();
        plazasLibres--;

        System.out.printf("ENTRA el coche: %s, quedan %d plazas.\n", modeloCarro, plazasLibres);

        lock.liberar();
    }

    public void salir(String modeloCarro){
        lock.adquirir();
        plazasLibres++;
        lock.liberar();

        System.out.printf("SALE el coche: %s, quedan %d plazas.\n", modeloCarro, plazasLibres);

        semaforo.liberar();
    }

}
