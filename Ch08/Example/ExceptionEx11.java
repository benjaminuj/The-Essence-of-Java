package Example;

public class ExceptionEx11 {
    public static void main(String[] args) {
        throw new RuntimeException(); // RuntimeException 고의로 발생. 컴파일 성공적으로 됨. 그러나 실행시 RuntimeException발생해 비정상적 종료
    }
}