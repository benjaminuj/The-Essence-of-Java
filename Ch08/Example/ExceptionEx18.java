package Example;

public class ExceptionEx18 {
    public static void main(String[] args) {
        try {
            startInstall();
            copyFiles();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            deleteTempFiles(); // 설치에 사용된 임시파일 삭제
        }
    }

    static void startInstall() {
        // 프로그램 설치에 필요한 준비를 하는 코드
    }
    static void copyFiles() {
        // 파일 복사하는 코드
    }
    static void deleteTempFiles() {
        // 임시파일 삭제 코드
    }
}