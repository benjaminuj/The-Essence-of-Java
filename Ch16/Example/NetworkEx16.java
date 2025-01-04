package Example;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.text.SimpleDateFormat;
import java.util.Date;

/*UdpServer*/
public class NetworkEx16 {
    public void start() throws IOException {
        // 7777포트 사용하는 소켓 생성
        DatagramSocket socket = new DatagramSocket(7777);
        DatagramPacket inPacket, outPacket;

        byte[] inMsg = new byte[10];
        byte[] outMsg;

        while (true) {
            // 데이터 수신 패킷 생성
            inPacket = new DatagramPacket(inMsg, inMsg.length);

            // 패킷 통해 데이터 수신
            socket.receive(inPacket); // receive()을 호출하면, 소켓은 해당 포트로 들어오는 데이터를 기다린다

            // 수신 패킷으로부터 client의 IP주소와 Port 획득
            InetAddress address = inPacket.getAddress();
            int port = inPacket.getPort();

            // 서버의 현재 시간을 시분초 형태로 반환
            SimpleDateFormat sdf = new SimpleDateFormat("[hh:mm:ss]");
            String time = sdf.format(new Date());
            outMsg = time.getBytes();

            // 패킷 생성해 client에게 전송
            outPacket = new DatagramPacket(outMsg, outMsg.length, address, port);
            socket.send(outPacket);
        }
    }
    public static void main(String[] args) {
        try {
            new NetworkEx16().start();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}