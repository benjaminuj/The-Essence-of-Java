package Example;

public class ThreadEx9 {
    public static void main(String[] args) {
        ThreadGroup main = Thread.currentThread().getThreadGroup();
        ThreadGroup grp1 = new ThreadGroup("Group1");
        ThreadGroup grp2 = new ThreadGroup("Group2");

        ThreadGroup subGrp1 = new ThreadGroup(grp1, "SubGroup1");

        grp1.setMaxPriority(3);

        Runnable r = new Runnable() {
            public void run() {
                try {
                    Thread.sleep(1000); // 쓰레드 그룹에 대한 정보 출력도 전에 쓰레드 종료되는 것 방지
                } catch (InterruptedException e) {}
            }
        };

        new Thread(grp1, r, "th1").start();
        new Thread(subGrp1, r ,"th2").start();
        new Thread(grp2, r, "th3").start();

        System.out.println(">>List of ThreadGroup : " +main.getName() + ", Active ThreadGroup: " + main.activeGroupCount() + ", Active Thraed: " + main.activeCount());
        main.list();
    }
}
