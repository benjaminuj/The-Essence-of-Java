package Example;

public class ExceptionEx6 {
    public static void main(String[] args) {
        System.out.println(1); // 실행됨
        System.out.println(2); // 실행됨
        try {
            System.out.println(3); // 실행됨
            System.out.println(0/0); // 0으로 나눠서 고의로 ArithmeticException 발생시킴
            System.out.println(4); // 실행되지 않음
        } catch (Exception e)  {
            System.out.println(5); // 실행됨
        }
        System.out.println(6); // 실행됨
    }
}
