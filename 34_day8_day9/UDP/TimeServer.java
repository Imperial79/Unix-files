package UDP;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.Date;

public class TimeServer {
    public static void main(String[] args) {
        try {
            DatagramSocket ds = new DatagramSocket(1234);
            while (true) {
                System.out.println("Server is Online ..");

                byte rdata[] = new byte[1024];

                DatagramPacket readDP = new DatagramPacket(rdata, rdata.length);

                ds.receive(readDP);

                int port = readDP.getPort();
                InetAddress address = readDP.getAddress();
                Date d = new Date();

                byte data[] = d.toString().getBytes();

                DatagramPacket sendDP = new DatagramPacket(data, data.length, address, port);

                ds.send(sendDP);
                ds.close();
            }

        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
