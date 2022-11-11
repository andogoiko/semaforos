import clases.Parking;
import procesos.hiloCarro;

import java.util.ArrayList;

public class Main {

    public static void main (String[] args) throws InterruptedException {

        Parking aparcamiento = new Parking();

        System.out.println("Inicia una nueva jornada y filas de ocches llegan a usar tu aparcamiento");

        ArrayList<Thread> clientesAparcamiento = new ArrayList<>();

        for (int i = 0; i < 100; i++){
            clientesAparcamiento.add(new Thread(new hiloCarro(aparcamiento, "coche" + i)));
        }

        for (Thread plazza: clientesAparcamiento) {

            plazza.start();
        }

        for (int i = 0; i < clientesAparcamiento.size(); i++){
            clientesAparcamiento.get(i).join();
        }


    }
}
