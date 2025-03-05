public class ThreadEx20 {
}

class ThreadEx20_1 extends Thread {
    final static int MAX_MEMORY = 1000;
    int usedMemory = 0;

    public void run() {
        while (true) {
            try {
                Thread.sleep(10*1000);
            } catch (InterruptedException e) {
                System.out.println("Awaken by interrupt().");
            }
        }
    }

}
