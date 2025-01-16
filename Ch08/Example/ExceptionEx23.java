package Example;

public class ExceptionEx23 {
    public static void main(String[] args) {
        try {
            install();
        } catch (InstallException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    static void install() throws InstallException {
        try {
            startInstall();
            copyFiles();
        } catch (SpaceException1 se) {
            InstallException ie = new InstallException("설치 중 예외 발생");
            ie.initCause(se);
            throw ie;
        } catch (MemoryException1 me) {
            InstallException ie = new InstallException("설치 중 예외 발생");
            ie.initCause(me);
            throw ie;
        } finally {
            deleteTempFiles();
        }
    }

    static void startInstall() throws SpaceException1, MemoryException1 {
        if (!enoughSpace()) { // 충분한 설치 공간 없으면...
            throw new SpaceException1("설치할 공간이 부족합니다.");
        }
        if (!enoughMemory()) { // 충분한 메모리가 없으면...
            throw new MemoryException1("메모리가 부족합니다.");
        }
    }
    static void copyFiles() {
        // 파일 복사하는 코드
    }
    static void deleteTempFiles() {
        // 임시파일 삭제 코드
    }

    static boolean enoughSpace() {
        return false;
    }

    static boolean enoughMemory() {
        return true;
    }
}

class InstallException extends Exception {
    InstallException(String msg) {
        super(msg);
    }
}

class SpaceException1 extends Exception {
    SpaceException1(String msg) {
        super(msg);
    }
}

class MemoryException1 extends Exception {
    MemoryException1(String msg) {
        super(msg);
    }
}
