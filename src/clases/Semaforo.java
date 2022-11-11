package clases;

public class Semaforo {

    private int limite;
    private int contador = 0;

    private Object lock = new Object();

    public Semaforo(int limite) {
        this.limite = limite;
    }

    public void adquirir() {
        synchronized (lock){
            while (contador >= limite){
                try {
                    lock.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

            contador++;

            lock.notifyAll();
        }
    }

    public void liberar() {

        synchronized (lock){
            while (contador <= 0){
                try {
                    lock.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

            contador--;

            lock.notifyAll();
        }

    }
}
