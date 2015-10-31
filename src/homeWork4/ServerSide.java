package homeWork4;

import java.io.*;
import java.net.Socket;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Dima on 28.10.2015.
 */
public class ServerSide implements Runnable {
    private Socket source;
    private Thread thread;
    private ChatServer server;
    private Socket destination;
    private BufferedReader in;
    private PrintWriter out;
    private HashMap<String,Socket> clientList;
    private String[] parsedMessage;

    public ServerSide(Socket source){
        this.source = source;
        try {
            in = new BufferedReader(new InputStreamReader(source.getInputStream()));
            //out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(source.getOutputStream()))/*destination.getOutputStream()))*/,true);
        }catch (IOException e){
            System.out.println("UNABLE TO CONNECT");
            e.printStackTrace();
        }
    }

    @Override
    public void run() {
        String message = "";
        try {
            while (true){
                message = in.readLine();
                parsedMessage = message.split("/");
                System.out.println("MESSAGE");
                for (int i = 0; i < parsedMessage.length; i++) {
                    System.out.print(parsedMessage[i] + "/");
                }

                System.out.println("CLIENTS");
                for(Map.Entry<String,Socket> client : clientList.entrySet()){
                    System.out.println(client.getKey()+" "+client.getValue());
                }

                out = new PrintWriter(
                        new BufferedWriter(
                                new OutputStreamWriter(
                                        clientList.get(parsedMessage[1]).getOutputStream()
                                )
                        )/*destination.getOutputStream()))*/,true
                );
                //out.println(message);
            }
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    public void updateClientList(HashMap<String,Socket> clientList){
        this.clientList = clientList;
    }
}
