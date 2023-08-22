package TCP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class EchoServer {
    public static void main(String[] args) {

        try {
            System.out.println("Waiting...");
            ServerSocket ss = new ServerSocket(1000);

            // waits for a client and when available accepts the request and stores in soc
            Socket soc = ss.accept();
            System.out.println("Connection established ... " + soc.getInetAddress() + " on port " + soc.getPort());

            BufferedReader in = new BufferedReader(new InputStreamReader(soc.getInputStream()));

            String str = in.readLine();

            PrintWriter out = new PrintWriter(soc.getOutputStream(), true);

            out.println("Server: " + str);

            soc.close();
            ss.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}