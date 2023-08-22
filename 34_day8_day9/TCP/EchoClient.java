package TCP;

import java.io.*;
import java.net.Socket;
import java.util.Scanner;

public class EchoClient {
    public static void main(String[] args) {

        try {
            System.out.println("Client Started ... ");
            Socket soc = new Socket("127.0.0.1", 1000);
            // localhost = 127.0.0.1

            System.out.println(soc.getInetAddress() + " connected to port " + soc.getPort());

            Scanner sc = new Scanner(System.in);

            System.out.println("Enter a String: ");
            String str = sc.nextLine();

            PrintWriter out = new PrintWriter(soc.getOutputStream(), true);

            out.println(str);

            // read the data sent by server
            BufferedReader in = new BufferedReader(new InputStreamReader(soc.getInputStream()));

            System.out.println(in.readLine());

            in.close();
            soc.close();
            sc.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
