package homeWork4;

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

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Random;

/**
 * Created by Dima on 29.10.2015.
 */
public class FXChatClient extends Application{

    static Socket socket;
    static BufferedReader in;
    static PrintWriter out;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {

        Random random = new Random();
        int port = random.nextInt(60000);
        int connectionPort = 8080;
        String ip = "127.0.0.1";
        GridPane grid = new GridPane();
        grid.setAlignment(Pos.CENTER);
        Button sendMessage = new Button("Send");
        Button login = new Button("Login");
        Button connect = new Button("Connect");
        TextField inetIP = new TextField();
        inetIP.setText(ip);
        TextField localPort = new TextField();
        TextField myNick = new TextField();
        myNick.setText("My nickname");
        TextField nickToTalk = new TextField();
        nickToTalk.setText("Talk to nickname");
        localPort.setText(Integer.toString(port));
        //TextField remotePort = new TextField();
        //remotePort.setText("Remote port");
        TextArea chatWindow = new TextArea();
        chatWindow.setPrefSize(800, 300);
        chatWindow.setEditable(false);
        chatWindow.setText("Hello\r\n");
        TextField message = new TextField();




        grid.setHgap(1);
        grid.setVgap(1);
        grid.setPadding(new Insets(1, 1, 1, 1));

        grid.add(inetIP, 0, 0);
        grid.add(localPort,1,0);
        //grid.add(remotePort,2,0);
        grid.add(login, 2, 0);
        grid.add(connect, 3, 0);
        grid.add(myNick,0,1);
        grid.add(nickToTalk,1,1);
        grid.add(chatWindow, 0, 2,4,1);
        grid.add(message,0,3,3,1);
        grid.add(sendMessage, 3, 3);
        Scene scene = new Scene(grid, 510, 500);
        primaryStage.setScene(scene);

        Task<Void> clientSide = new Task<Void>() {
            @Override
            protected Void call() throws Exception {
                //Run client side
                chatWindow.setText(chatWindow.getText() + "Connecting...\r\n");
                try {
                    socket = new Socket(inetIP.getText(),connectionPort);
                    in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                    out = new PrintWriter(socket.getOutputStream(),true);
                }catch (IOException e){
                    System.out.println("connect.addEventHandler");
                    e.printStackTrace();
                }
                chatWindow.setText(chatWindow.getText() + "Successfully connected to the server\r\n");
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

        sendMessage.addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                System.out.println("Send message");
                chatWindow.setText(chatWindow.getText() + message.getText() + "\r\n");
                out.println(myNick.getText() + "/" + nickToTalk.getText() + "/" + message.getText() + "\r\n");
                System.out.println("client: " + message.getText());
                message.setText("");
            }
        });


        connect.addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                System.out.println("Connect clicked");
                Thread client = new Thread(clientSide);
                client.start();
            }
        });

        primaryStage.show();
    }
}
