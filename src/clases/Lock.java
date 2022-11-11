package clases;

public class Lock {

    private boolean actividad = false;

    private Object lock = new Object();

    public void adquirir() {

        synchronized (lock){
            while (actividad){
                try {
                    lock.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

            actividad = true;

            lock.notifyAll();
        }
    }

    public void liberar() {

        synchronized (lock){
            while (!actividad){
                try {
                    lock.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

            actividad = false;

            lock.notifyAll();
        }
    }
}
