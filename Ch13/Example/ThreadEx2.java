package Example;

public class ThreadEx2 {
    public static void main(String[] args) {
        ThreadEx2_1 t1 = new ThreadEx2_1();
        t1.start(); // main 쓰레드는 `t1.start()` 이후 더 이상 실행할 코드가 없으므로 즉시 종료
    }
}

class ThreadEx2_1 extends Thread {
    public void run() {
        throwException();
    }

    public void throwException() {
        try {
            throw new Exception();
        } catch (Exception e) {
            // 예외 발생 당시 call stack 출력. 이때 main쓰레드는 이미 종료된 상태이므로 ThreadEx2_1 쓰레드의 call stack만 보인다
            e.printStackTrace(); // (bottom) run -> throwException (top)
        }
    }
}
