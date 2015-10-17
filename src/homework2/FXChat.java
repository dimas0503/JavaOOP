package homework2;

import javafx.application.Application;
import javafx.concurrent.Task;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Random;

/**
 * Created by Dima on 13.10.2015.
 */
public class FXChat extends Application {
    private static int port;
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {

        Random random = new Random();
        port = random.nextInt(60000);
        GridPane grid = new GridPane();
        grid.setAlignment(Pos.CENTER);
        Button sendMessage = new Button("Send");
        Button connect = new Button("Connect");
        TextField inetIP = new TextField();
        inetIP.setText("127.0.0.1"/*"IP adress"*/);
        TextField localPort = new TextField();
        localPort.setText(Integer.toString(port));
        TextField remotePort = new TextField();
        remotePort.setText("Remote port");
        TextArea chatWindow = new TextArea();
        chatWindow.setPrefSize(800, 300);
        chatWindow.setEditable(false);
        chatWindow.setText("Hello\r\n");
        TextField message = new TextField();

        Task<Void> server = new Task<Void>() {
            //Random random = new Random();
            //private final int port = 8080; //random.nextInt(60000);
            ServerSocket serverSocket;
            Socket socket;
            BufferedReader in;
            PrintWriter out;
            @Override
            protected Void call() throws Exception {
                serverSocket = new ServerSocket(port);
                socket = serverSocket.accept();
                in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                out = new PrintWriter(socket.getOutputStream(),true);
                System.out.println(port);
                //remotePort.setText(port);

                sendMessage.addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>() {
                    @Override
                    public void handle(MouseEvent event) {
                        chatWindow.setText(chatWindow.getText() + message.getText() + "\r\n");
                        out.println(message.getText());
                        System.out.println("Server OS: " + message.getText());
                        message.setText("");
                        //printWriter.flush();
                    }
                });

                while (true) {
                    String message = in.readLine();
                    if (message.equals("bye")) {
                        break;
                    }
                    chatWindow.setText(chatWindow.getText() + message + "\r\n");
                    System.out.println(message);
                }

                //socket.close();
                return null;
            }
        };


        Task<Void> clientSide = new Task<Void>() {
            Socket socket;
            BufferedReader in;
            PrintWriter out;
            @Override
            protected Void call() throws Exception {
                //Run client side
                chatWindow.setText(chatWindow.getText() + "Connecting...\r\n");
                try {
                    socket = new Socket(inetIP.getText(),Integer.parseInt(remotePort.getText()));
                    in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                    out = new PrintWriter(socket.getOutputStream(),true);
                }catch (IOException e){
                    System.out.println("connect.addEventHandler");
                    e.printStackTrace();
                }

                sendMessage.addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>() {
                    @Override
                    public void handle(MouseEvent event) {
                        chatWindow.setText(chatWindow.getText() + message.getText() + "\r\n");
                        out.println(message.getText());
                        System.out.println("client: " + message.getText());
                        message.setText("");
                    }
                });

                while (true) {
                    String message = in.readLine();
                    if (message.equals("bye")) {
                        break;
                    }
                    chatWindow.setText(chatWindow.getText() + message + "\r\n");
                    System.out.println(message);
                }


                return null;
            }
        };

        connect.addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                Thread client = new Thread(clientSide);
                client.start();
            }
        });

        Thread th = new Thread(server);
        th.start();

/*
        //TODO create handler for ENTER while typing the message
        message.addEventHandler(KeyEvent.KEY_PRESSED, new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent event) {
                if (event.getCode().getName().contains("Enter")){
                    chatWindow.setText(chatWindow.getText() + message.getText() + "\r\n");
                    printWriter.println(message.getText());
                    message.setText("");
                }
            }
        });
*/

        grid.setHgap(1);
        grid.setVgap(1);
        grid.setPadding(new Insets(1, 1, 1, 1));

        grid.add(inetIP, 0, 0);
        grid.add(localPort,1,0);
        grid.add(remotePort,2,0);
        grid.add(connect, 3, 0);
        grid.add(chatWindow, 0, 1,4,1);
        grid.add(message,0,2,3,1);
        grid.add(sendMessage,3,2);
        Scene scene = new Scene(grid, 510, 500);
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
