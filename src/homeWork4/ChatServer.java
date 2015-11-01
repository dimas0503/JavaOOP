package homeWork4;

import homeWork4.ServerSide;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by Dima on 27.10.2015.
 */
public class ChatServer{
    static int port = 8080;
    static BufferedReader in;
    static PrintWriter out;
    static Socket socket;
    static HashMap<String,Socket> clientList;
    static ArrayList<ServerSide> clientThreads;
    static String[] parsedMessage;

    public static void main(String[] args){
        clientList = new HashMap<>();
        String nickname;
        //Waiting for the client
        try {
            ServerSocket serverSocket = new ServerSocket(port);

            clientThreads = new ArrayList<>();
            while (true) {

                //waiting for client connection
                System.out.println("waiting for client connection");
                socket = serverSocket.accept();

                Thread thread = new Thread(new ServerSide(socket,clientList));
                thread.start();
            }

        } catch (IOException e) {
            System.out.println("Error while launching the server ");
            e.printStackTrace();
        }
    }
}
