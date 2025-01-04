package Example;

import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.ConnectException;
import java.net.Socket;

/*TcpIpClient1*/
public class NetworkEx7 {
    public static void main(String[] args) {
        try {
            String serverIp = "127.0.0.1";

            System.out.println("서버에 연결중입니다. 서버 IP: " + serverIp);
            // 연결하려는 서버의 IP와 포트번호로 소켓생성하면 자동으로 서버에 연결 요청
            // 서버와 연결 실패하면, ConnectException 발생
            Socket socket = new Socket(serverIp, 7777);

            // 소켓 입력스트림 얻기
            InputStream in = socket.getInputStream();
            DataInputStream dis = new DataInputStream(in);

            // 소켓으로부터 받은 데이터 출력
            System.out.println("서버로부터 받은 메시지: " + dis.readUTF());
            System.out.println("연결을 종료합니다.");

            // 스트림과 소켓 닫기
            dis.close();
            socket.close();
            System.out.println("연결이 종료되었습니다.");
        } catch (ConnectException ce) {
            ce.printStackTrace();
        } catch (IOException ie) {
            ie.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
