package Example;

public class ExceptionEx9 {
    public static void main(String[] args) {
        try {
            Exception e = new Exception("고의로 발생");
            throw e;
//            throw new Exception("고의로 발생"); // 위의 두 줄을 한 줄로 쓸 수 있다
        } catch (Exception e) {
            System.out.println("에러 메시지: " + e.getMessage());
            e.printStackTrace();
        }
        System.out.println("프로그램 정상 종료되었음");
    }
}
