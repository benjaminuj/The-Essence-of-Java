package Example;

import java.io.DataOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.text.SimpleDateFormat;
import java.util.Date;

/*TcpIpServer4*/
public class NetworkEx10 implements Runnable {
    ServerSocket serverSocket;
    Thread[] threadArr;

    public static void main(String[] args) {
        NetworkEx10 server = new NetworkEx10(5);
        server.start();
    }

    public NetworkEx10(int num) {
        try {
            serverSocket = new ServerSocket(7777);
            System.out.println(getTime() + "서버가 준비되었습니다.");

            threadArr = new Thread[num];
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void start() {
        // 여러개 쓰레드 생성해 클라이언트 요청 동시에 처리하도록 함
        for (int i =0; i < threadArr.length; i++) {
            threadArr[i] = new Thread(this);
            threadArr[i].start();
        }
    }
    public void run() {
        while (true) {
            try {
                System.out.println(getTime() + "가 연결요청을 기다립니다.");

                Socket socket = serverSocket.accept();
                System.out.println(getTime()+ socket.getInetAddress() + "로부터 연결요청이 들어왔습니다");

                // 소켓 출력스트림 얻기
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
        String name = Thread.currentThread().getName();
        SimpleDateFormat f = new SimpleDateFormat("[hh:mm:ss]");
        return f.format(new Date()) + name;
    }
}
