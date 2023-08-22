package UDP;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class EchoServer {
    public static void main(String[] args) {

        try {
            DatagramSocket ds = new DatagramSocket(2000);

            byte b1[] = new byte[1024];
            DatagramPacket dp1 = new DatagramPacket(b1, b1.length);

            ds.receive(dp1);
            String str = new String(dp1.getData());

            int num = Integer.parseInt(str.trim());
            int result = num * num;

            // now send result to client
            InetAddress ia = InetAddress.getLocalHost();
            byte b2[] = String.valueOf(result).getBytes();

            DatagramPacket dp2 = new DatagramPacket(b2, b2.length, ia, dp1.getPort());

            ds.send(dp2);

            ds.close();

        } catch (Exception e) {

            e.printStackTrace();
        }

    }
}
