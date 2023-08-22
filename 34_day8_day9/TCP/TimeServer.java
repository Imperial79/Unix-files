package TCP;

import java.io.DataOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Date;

public class TimeServer {
    public static void main(String[] args) {
        try {

            ServerSocket ss = new ServerSocket(2000);
            Socket soc = ss.accept();

            DataOutputStream out = new DataOutputStream(soc.getOutputStream());

            out.writeBytes("Server Date: " + (new Date()).toString());

            out.close();
            soc.close();
            ss.close();

        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
