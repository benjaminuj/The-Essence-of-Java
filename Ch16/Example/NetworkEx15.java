package Example;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.UnknownHostException;

/*UdpClient*/
public class NetworkEx15 {
    public void start() throws IOException, UnknownHostException{
        DatagramSocket datagramSocket = new DatagramSocket(); // 클라이언트는  DatagramSocket을 생성하면서 자동으로 로컬 포트를 할당받음: 이 포트는 서버가 응답을 보낼 때 사용
        InetAddress serverAddress = InetAddress.getByName("127.0.0.1");

        // 데이터 저장 공간으로 byte 배열 생성
        byte[] msg = new byte[100];

        DatagramPacket outPacket = new DatagramPacket(msg, 1, serverAddress, 7777); // 길이가 1인 이유: 클라이언트가 서버에 유의미한 데이터를 보내는 것이 아니라, 간단히 서버의 응답을 유도하기 위한 최소한의 데이터 전송 목적
        DatagramPacket inPacket = new DatagramPacket(msg, msg.length);

        datagramSocket.send(outPacket); //DatagramPacket 전송
        datagramSocket.receive(inPacket); // DatagramPacket 수신: receive()을 호출하면, 소켓은 해당 포트로 들어오는 데이터를 기다린다

        System.out.println("current server time : " + new String(inPacket.getData()));

        datagramSocket.close();
    }

    public static void main(String[] args) {
        try {
            new NetworkEx15().start();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}