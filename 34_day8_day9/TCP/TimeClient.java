package TCP;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.InetAddress;
import java.net.Socket;

public class TimeClient {
    public static void main(String[] args) {
        try {

            Socket soc = new Socket(InetAddress.getLocalHost(), 2000);

            BufferedReader in = new BufferedReader(new InputStreamReader(soc.getInputStream()));

            System.out.println(in.readLine());

        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
