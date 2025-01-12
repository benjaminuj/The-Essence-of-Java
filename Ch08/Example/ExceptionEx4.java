package Example;

public class ExceptionEx4 {
    public static void main(String[] args) {
        System.out.println(1); // 실행됨
        System.out.println(2); // 실행됨
        try {
            System.out.println(3); // 실행됨
            System.out.println(4); // 실행됨
        } catch (Exception e)  {
            System.out.println(5); // 실행되지 않음
        }
        System.out.println(6); // 실행됨
    }
}
