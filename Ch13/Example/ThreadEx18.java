package Example;

public class ThreadEx18 {
}

class ThreadEx18_1 implements Runnable {
    boolean suspended = false;
    boolean stopped = false;

    Thread th;

    ThreadEx18_1(String name) {
        th = new Thread(this, name);
    }
    public void run() {
        String name = th.getName();

        while (!stopped) {
            if (!suspended) {
                System.out.println(name);

                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    System.out.println(name + " - interrupted");
                }
            } else {
                Thread.yield();
            }
        }
        System.out.println(name + " - stopped");
    }
}

