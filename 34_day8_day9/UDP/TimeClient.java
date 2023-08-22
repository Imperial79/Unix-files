package UDP;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class TimeClient {
    public static void main(String[] args) {
        try {

            System.out.println("Client is on ..");

            DatagramSocket ds = new DatagramSocket();
            InetAddress address = InetAddress.getLocalHost();

            // send data
            byte sData[] = new byte[1024];
            DatagramPacket sendDP = new DatagramPacket(sData, sData.length, address, 1234);

            ds.send(sendDP);

            // Accept data
            byte rData[] = new byte[1024];

            DatagramPacket getDP = new DatagramPacket(rData, rData.length);

            ds.receive(getDP);

            String str = new String(getDP.getData());

            System.out.println("Server date : " + str);

            ds.close();

        } catch (Exception e) {
            // TODO: handle exception
        }
    }
}
