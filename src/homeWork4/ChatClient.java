package homeWork4;

import java.io.*;
import java.net.Socket;
import java.util.Scanner;
import java.util.WeakHashMap;

/**
 * Created by Dima on 27.10.2015.
 */
public class ChatClient {

    static  String  host = "127.0.0.1";
    static  int     port = 8080;
    static BufferedReader in;
    static PrintWriter out;
    static Socket socket;
    static String message;
    static Scanner scanner;

    public static void main(String[] args) {
        try {
            socket = new Socket(host,port);
            in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(socket.getOutputStream())),true);

            scanner = new Scanner(System.in);

            //my nick
            message = scanner.next();

            Thread inputMessages = new Thread(
                    new Runnable() {
                        @Override
                        public void run() {
                            while (true){
                                try {
                                    message = in.readLine();
                                    if (message.equals("bye")) {
                                        break;
                                    }
                                    System.out.println(message);
                                }catch (IOException e){
                                    e.printStackTrace();
                                }
                            }
                        }
                    }
            );
            inputMessages.start();


            while ((message.equals("bye")) == false){
                out.println(message);
                message = scanner.next();
            }



        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
