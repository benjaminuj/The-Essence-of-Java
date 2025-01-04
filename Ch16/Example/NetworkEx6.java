package Example;

import java.io.DataOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.text.SimpleDateFormat;
import java.util.Date;

/*TcpIpServer*/
public class NetworkEx6 {
    public static void main(String[] args) {
        ServerSocket serverSocket = null;

        try {
            // 서버소켓을 생성해 7777포트와 결합
            serverSocket = new ServerSocket(7777);
            System.out.println(getTime()+"서버가 준비되었습니다.");
        } catch (IOException e) {
            e.printStackTrace();
        }

        while(true) {
            try {
                System.out.println(getTime()+"연결요청을 기다립니다.");

                // 서버소켓은 클라이언트 연결요청이 올 때까지 실행을 멈추고 계속 기다린다.
                // 클라이언트 연결요청이 오면 클라이언트 소켓과 통신할 새로운 소켓을 생성한다.
                Socket socket = serverSocket.accept();
                System.out.println(getTime()+ socket.getInetAddress()+"로부터 연결요청이 들어왔습니다."); // socket.getInetAddress(): 연결된 상대방의 IP 주소를 반환

                // 소켓의 출력 스트림을 얻는다
                OutputStream out = socket.getOutputStream();
                DataOutputStream dos = new DataOutputStream(out);

                // 원격 소켓에 데이터 보낸다
                dos.writeUTF("[Notice] Test Message1 from Server");
                System.out.println(getTime()+"데이터를 전송했습니다.");

                //스트림과 소켓 닫는다
                dos.close();
                socket.close();
                // OutputStream out 을 명시적으로 닫지않는 이유: DataOutputStream을 닫으면 내부적으로 사용하는 하위 스트림(OutputStream out)도 함께 닫히기 때문
                // 만약 out.close()를 명시적으로 호출한다면, 이미 닫힌 스트림을 다시 닫으려 하여 IOException이 발생할 수 있으므로 이를 피해야 한다.
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
