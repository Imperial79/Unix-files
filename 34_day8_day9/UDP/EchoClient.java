package UDP;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class EchoClient {
    public static void main(String[] args) {
        try {

            DatagramSocket ds = new DatagramSocket();
            int i = 8;
            // convert data into bytes
            byte b[] = String.valueOf(i).getBytes();

            // get localhost address by using InetAdress class
            InetAddress ia = InetAddress.getLocalHost();

            DatagramPacket dp = new DatagramPacket(b, b.length, ia, 2000);
            ds.send(dp);

            // Accept data

            byte b2[] = new byte[1024];
            DatagramPacket dp2 = new DatagramPacket(b2, b2.length);
            ds.receive(dp2);

            String str = new String(dp2.getData());

            System.out.println("Server: " + str);

            ds.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
