package Example;

public class ThreadEx3 {
    public static void main(String[] args) {
        ThreadEx3_1 t1 = new ThreadEx3_1();
        t1.run(); // start()가 아닌 run() 호출로 쓰레드 새로 생성x
    }
}

class ThreadEx3_1 extends Thread {
    public void run() {
        throwException();
    }

    public void throwException() {
        try {
            throw new Exception();
        } catch (Exception e) {
            e.printStackTrace(); // (bottom) main -> run -> throwException (top)
        }
    }
}
