package Example;

import java.io.DataOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketTimeoutException;
import java.text.SimpleDateFormat;
import java.util.Date;

/*TcpIpServer3*/
public class NetworkEx9 {
    public static void main(String[] args) {
        ServerSocket serverSocket = null;

        try {
            serverSocket = new ServerSocket(7777);
            System.out.println(getTime() + "서버가 준비되었습니다.");
        } catch (IOException e) {
            e.printStackTrace();
        }

        while (true) {
            try {
                // 서버소켓
                System.out.println(getTime() + "연결 요청을 기다립니다.");

                // 요청대기시간 5초 설정
                // 5초동안 접속요청 없으면 SocketTimeoutException 발생
                serverSocket.setSoTimeout(5*1000);
                Socket socket = serverSocket.accept();
                System.out.println(getTime() + socket.getInetAddress() + "로부터 연결요청이 들어왔습니다.");

                // 소켓의 출력 스트림 얻는다
                OutputStream out = socket.getOutputStream();
                DataOutputStream dos = new DataOutputStream(out);

                // 원격 소켓에 데이터 보내기
                dos.writeUTF("[Notice] Test Message1 from Server");
                System.out.println(getTime() + "데이터를 전송했습니다.");

                // 스트림과 소켓 닫기
                dos.close();
                socket.close();
            } catch (SocketTimeoutException e) {
                System.out.println("지정된 시간동안 접속 요청이 없어서 서버를 종료합니다.");
                System.exit(0);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    static String getTime() {
        SimpleDateFormat f = new SimpleDateFormat("[hh:mm:ss]");
        return f.format(new Date());
    }
}
