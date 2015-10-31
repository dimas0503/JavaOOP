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
                socket = serverSocket.accept();

                in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()))/*destination.getOutputStream()))*/,true);


                //waiting for connected person nick
                nickname = in.readLine();
                parsedMessage = nickname.split("/");
                System.out.println("NICK");
                System.out.println(parsedMessage[0]);

                //adding this nick to the list of available contacts
                clientList.put(parsedMessage[0],socket);

                clientThreads.add(new ServerSide(socket));
                System.out.println(clientThreads.size());
                Thread thread = new Thread(clientThreads.get(clientThreads.size()-1));
                thread.start();

                //updating client list
                for(ServerSide client : clientThreads){
                    client.updateClientList(clientList);
                }

/*
                String[] names = nickname.split("/");
                System.out.println(names[0]);
                System.out.println(names[1]);


                // waiting for second person nick
                //nickname = in.readLine();

                //searching second person nick in list of available contacts
                Socket destination = null;
                if (names.length > 1){
                    destination =  clientList.get(names[1]);
                }
*/
            }

        } catch (IOException e) {
            System.out.println("Error while launching the server ");
            e.printStackTrace();
        }
    }

    public static Socket getNickName(String  nickname){
        Socket socket = clientList.get(nickname);
        return socket;
    }
}
