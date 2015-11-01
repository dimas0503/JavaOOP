package homeWork4;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.InetSocketAddress;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.HashMap;

/**
 * Created by Dima on 01.11.2015.
 */
public class ChatServer1 {

    static int port = 8080;
    static ServerSocketChannel serverSocketChannel;
    static SocketChannel socketChannel;
    static HashMap<String,SocketChannel> clientList;
    static BufferedReader in;
    public static void main(String[] args) {
        try {
            serverSocketChannel = ServerSocketChannel.open();
            serverSocketChannel.socket().bind(new InetSocketAddress(port));
            clientList = new HashMap<>();
            Thread waitingForClient = new Thread(
                    new Runnable() {
                        @Override
                        public void run() {
                            BufferedReader in;
                            try {
                                while (true){
                                    socketChannel = serverSocketChannel.accept();
                                    in = new BufferedReader(new InputStreamReader(socketChannel.socket().getInputStream()));
                                    String[] parsedMessage = in.readLine().split("/");
                                    clientList.put(parsedMessage[0],socketChannel);
                                }
                            }catch (IOException e){
                                System.out.println("ERROR WHILE STARTING CLIENT LISTENING THREAD");
                                e.printStackTrace();
                            }finally {
                                try {
                                    socketChannel.close();
                                }catch (IOException e){
                                    //NTD
                                }
                            }

                        }
                    }
            );
            waitingForClient.start();

            while (true){
                //socketChannel.write();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                socketChannel.close();
                serverSocketChannel.close();
            }catch (IOException e){
                //NTD
            }

        }
    }
}
