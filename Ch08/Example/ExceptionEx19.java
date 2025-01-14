package Example;

public class ExceptionEx19 {
    public static void main(String[] args) {
        method1();
        System.out.println("method1()의 수행을 마치고 main메서드로 돌아왔습니다."); // 실행
    }

    static void method1() {
        try {
            System.out.println("method1()이 호출되었습니다."); // 실행
            return; // 현재 실행중인 메서드 종료
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            System.out.println("method1()의 finally 블럭이 실행되었습니다."); // 실행
        }
        System.out.println("try-catch문을 빠져나옴"); // Unreachable statement 컴파일 에러는 발생하지 않으나, 실행 x
    }
}