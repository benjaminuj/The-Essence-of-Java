package Example;

public class ExceptionEx7 {
    public static void main(String[] args) {
        System.out.println(1);
        System.out.println(2);
        try {
            System.out.println(3);
            System.out.println(0/0); // 0으로 나눠서 고의로 ArithmeticException 발생시킴
            System.out.println(4); // 실행되지 않음
        } catch (ArithmeticException ae) { //  ArithmeticException은 해당 catch에서만 처리됨
            if (ae instanceof ArithmeticException) {
                System.out.println("true"); // 실행됨
            }
            System.out.println("ArithmeticException"); // 실행됨
        } catch (Exception e) { // ArithmeticException을 제외한 모든 예외가 여기서 처리됨
            System.out.println("Excetion"); // 실행되지 않음
        }
        System.out.println(6); // 실행됨
    }
}
