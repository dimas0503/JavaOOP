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
    private BufferedReader in;
    private HashMap<String,Socket> clientList;

    public ServerSide(Socket source, HashMap<String,Socket> clientList){
        this.source = source;
        this.clientList = clientList;
        try {
            in = new BufferedReader(new InputStreamReader(source.getInputStream()));
            new PrintWriter(new BufferedWriter(new OutputStreamWriter(source.getOutputStream())),true).println("Type your nickname");
            System.out.println("Waiting for nickname");
            String[] message = in.readLine().split("/");
            clientList.put(message[0],source);
            System.out.println("Client was added:");
        }catch (IOException e){
            System.out.println("UNABLE TO CONNECT");
            e.printStackTrace();
        }
    }

    @Override
    public void run() {
        String[] message;
        try {
            while (true){
                System.out.println("Waiting for message");
                message = in.readLine().split("/");
                System.out.println("Message received");
                System.out.println("MESSAGE");
                for (int i = 0; i < message.length; i++) {
                    System.out.print(message[i] + "/");
                }

                System.out.println("CLIENTS");
                for(Map.Entry<String,Socket> client : clientList.entrySet()){
                    System.out.println(client.getKey()+" "+client.getValue());
                }

                if ( (message.length >1) && (clientList.get(message[1]) != null)){
                    System.out.println("Sending message");
                    new PrintWriter(
                            new BufferedWriter(
                                    new OutputStreamWriter(
                                            clientList.get(message[1]).getOutputStream()
                                    )
                            ),true
                    ).println(message[2]);
/*
                    String[] recepientsList = message[1].split(";");
                    for (int i = 0; i < recepientsList.length-1; i++) {
                        System.out.println("Send to:" + recepientsList[i]);
                    }
*/
                }
            }
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
