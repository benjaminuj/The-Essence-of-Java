package Example;

import java.io.DataOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.text.SimpleDateFormat;
import java.util.Date;

/*TcpIpServer2*/
public class NetworkEx8 {
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
                Socket socket = serverSocket.accept();
                System.out.println(getTime() + socket.getInetAddress() + "로부터 연결요청이 들어왔습니다.");

                System.out.println("getPort():" + socket.getPort()); // 상대편 소켓이 사용하는 포트. 클라이언트 프로그램이 사용하는 포트는 사용가능한 임의의 포트 선택됨
                System.out.println("getLocalPort(): " + socket.getLocalPort()); // 소켓 자신이 사용하는 포트

                // 소켓의 출력 스트림 얻는다
                OutputStream out = socket.getOutputStream();
                DataOutputStream dos = new DataOutputStream(out);

                // 원격 소켓에 데이터 보내기
                dos.writeUTF("[Notice] Test Message1 from Server");
                System.out.println(getTime() + "데이터를 전송했습니다.");

                // 스트림과 소켓 닫기
                dos.close();
                socket.close();
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