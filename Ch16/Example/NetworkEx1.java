package Example;

import java.net.*;
import java.util.Arrays;

public class NetworkEx1 {
    public static void main(String[] args) {
        InetAddress ip = null;
        InetAddress[] ipArr = null;

        try {
            ip = InetAddress.getByName("www.naver.com");
            System.out.println("getHostName() :" + ip.getHostName());
            System.out.println("getHostAddress() :" + ip.getHostAddress());
            System.out.println("toString() :" + ip.toString());

            byte[] ipAddr = ip.getAddress();
            System.out.println("getAddress() :" + Arrays.toString(ipAddr)); // 음수 출력되는 이유: Java에서 byte타입은 -128~127 나타내기 때문에, 부호비트를 두고 부호비트가 1이면 2의보수 활용해 음수로 해석

            String result = "";
            for (int i=0; i<ipAddr.length; i++) {
                result += (ipAddr[i] < 0) ? ipAddr[i] + 256 : ipAddr[i]; // 8bit의 음수값을 원래 값으로 복원하려면 256을 더하고 하위 8bit를 취한다
                result += ".";
            }
            System.out.println("getAddress()+256 :" + result);
            System.out.println();
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }

        try {
            ipArr = InetAddress.getAllByName("www.naver.com");

            for (int i=0; i<ipArr.length; i++) {
                System.out.println("ipArr[" + i+ "] :" + ipArr[i]);
            }
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
    }
}
