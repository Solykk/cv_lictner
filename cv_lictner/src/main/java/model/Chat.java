package model;

import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.control.TextArea;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.scene.shape.Polygon;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.UnknownHostException;
import java.nio.ByteBuffer;
import java.nio.channels.AsynchronousCloseException;
import java.nio.channels.ClosedChannelException;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;

/**
 * Created by Solyk on 08.05.2017.
 */
public class Chat implements ChatProperties, Runnable{
    private SocketChannel clientChannel;
    private int listenPort;
    private String myIpAddress;
    private ByteBuffer buffOutput = ByteBuffer.allocate(BuffSize);
    private ByteBuffer buffInput = ByteBuffer.allocate(BuffSize);

    private Group chatWindow;
    private Stage stageForChat;
    private TextArea input;
    private TextArea output;
    private Polygon sendButton;

    private boolean runWhileController;

    private int sendReceiveStat = -1;
    private ServerSocketChannel serverSocketChannel;

    public Chat(Group group, Stage stageForChat, int port) {
        this.listenPort = port;
        this.chatWindow = group;
        this.runWhileController = true;
        this.stageForChat = stageForChat;
        this.input = (TextArea) chatWindow.getChildren().get(9);
        this.output = (TextArea)chatWindow.getChildren().get(10);
        this.sendButton = (Polygon) chatWindow.getChildren().get(14);

        try {
            serverSocketChannel = ServerSocketChannel.open();
        }
        catch (IOException e) {
            e.printStackTrace();
        }

        init();
    }

    private void init() {

        try {
            InetAddress ip = InetAddress.getLocalHost();
            this.myIpAddress = ip.getHostAddress();
            System.out.println(myIpAddress);
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }

        chatWindow.getChildren().get(12).setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                disconnect();
                runWhileController = false;
                chatWindow = null;
                stageForChat.close();
            }
        });

        chatWindow.getChildren().get(14).setOnMouseClicked(new EventHandler<MouseEvent>(){
            @Override
            public void handle(MouseEvent event) {
                sendMessage(clientChannel, input.getText(), true);
                input.clear();
            }
        });
    }

    private void boundListener() {
        System.out.println("BOUND_LISTENER");
        try {
            if (serverSocketChannel.socket().isBound()) {
                serverSocketChannel.socket().close();
                serverSocketChannel.close();
            }
            serverSocketChannel = ServerSocketChannel.open();
            serverSocketChannel.socket().bind(new InetSocketAddress(myIpAddress, listenPort));
            serverSocketChannel.configureBlocking(false);
        }
        catch (IOException e) {
            e.printStackTrace();
        }
     }

    private void process() throws IOException, InterruptedException {

        if (clientChannel == null) {
            System.out.println("ProcessChannel_NULL");
            connect();
        }

        if (clientChannel != null) {
            System.out.println("ProcessChannel_NOT_NULL");
            readChannel(clientChannel);
            return;
        }
    }

    private void connect() throws IOException, InterruptedException {
        try{
            if (serverSocketChannel == null){
                System.out.println("serverSocket_NULL");
                try {
                    serverSocketChannel = ServerSocketChannel.open();
                }
                catch (IOException e) {
                    e.printStackTrace();
                }
                boundListener();
            }

            clientChannel = serverSocketChannel.accept();
            Thread.sleep(SleepTime);

            if (clientChannel != null) {
                System.out.println("ConnectChannel_NOT_NULL");
                sendMessage(clientChannel, "ONLINE".toUpperCase() + "\n", false);
            }
                sendButton.setFill(Color.rgb(127,255,0));
                System.out.println(clientChannel.toString());

        } catch (Exception e){
            System.out.println("ConnectFAil");
            throw new InterruptedException();
        }
    }

    private int readChannel(SocketChannel ch) throws IOException {

        int readBytesNum = 0;
        if (!ch.isOpen() || ch.socket().isClosed() || !ch.socket().isBound() ) {
            return readBytesNum;
        }

        try {
            while ((readBytesNum = ch.read(buffInput)) > 0) {
                String receivedMessage = buffToString(buffInput, readBytesNum);

                System.out.println(receivedMessage.toUpperCase());

                if (receivedMessage.equals(DisconnectMessage)){
                    disconnect();
                } else {
                    if (!receivedMessage.equals(DisconnectMessage)) {
                        output.setStyle("-fx-text-fill: white");
                        output.appendText("\n" + (sendReceiveStat != 0 ? "\tHR:\n" : "") +  receivedMessage);
                        setSendReceiveStat(0);
                    } else {
                        output.setStyle("-fx-text-fill: white");
                        output.appendText(DisconnectMessage);
                        disconnect();
                    }
                }
                buffInput.clear();
            }
        } catch (ClosedChannelException e) {
            e.printStackTrace();
            disconnect();
        }
        return readBytesNum;
    }

    @Override
    public void run() {
        System.out.println("Thread run");
        boundListener();
        while (runWhileController) {
            try {
                System.out.println("Before Process");
                Thread.sleep(1000);
                process();
                System.out.println("After Process");
            } catch (Exception e) {
                sendButton.setFill(Color.rgb(255, 40, 0));
                setSendReceiveStat(-1);
                clientChannel = null;
                System.out.println(e.getMessage() + " ------ " + e.toString());
            }
        }
        disconnect();
        System.out.println("Run complete");
    }

    private void disconnect() {
        try {
            if (clientChannel != null && clientChannel.isOpen()) {
                sendMessage(clientChannel, DisconnectMessage, false);
                System.out.println("clientChannel.close();");
                clientChannel.close();
            }
            if (serverSocketChannel != null && serverSocketChannel.isOpen()) {
                System.out.println("serverSocketChannel.close();");
                serverSocketChannel.close();
            }
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        finally {
            clientChannel = null;
            serverSocketChannel = null;
        }
    }

    private void sendMessage(SocketChannel channel, String message, boolean verbose) {

        if (channel == null || message == null) {
            return;
        }

        buffOutput.clear();
        buffOutput.put(message.getBytes());
        buffOutput.flip();

        try {
            while (buffOutput.hasRemaining()) {
                channel.write(buffOutput);
                if (verbose) {
                    output.setStyle("-fx-text-fill: white");
                    output.appendText((sendReceiveStat != 1 ? "\n\tYOU:" : "") + "\t\n" +
                            buffToString(buffOutput, buffOutput.limit()));
                    setSendReceiveStat(1);
                }
            }

            buffOutput.flip();
        }
        catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public void setSendReceiveStat(int sendReceiveStat) {
        this.sendReceiveStat = sendReceiveStat;
    }

}
