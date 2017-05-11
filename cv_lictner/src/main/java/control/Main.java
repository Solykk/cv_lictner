package control;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import model.Chat;
import service.ViewProperties;
import view.ChatWindow;

/**
 * Created by Solyk on 28.04.2017.
 */
public class Main extends Application{

    private final ViewProperties PROPERTIES = new ViewProperties();

    public static Stage stageForChat;
    private Group chatWindow;
    private double xOffsetChatWin;
    private double yOffsetChatWin;

    public static Stage stageForChat4;
    private Group chatWindow4;
    private double xOffsetChatWin4;
    private double yOffsetChatWin4;

    public static Stage stageForChat5;
    private Group chatWindow5;
    private double xOffsetChatWin5;
    private double yOffsetChatWin5;

    public static Stage stageForChat6;
    private Group chatWindow6;
    private double xOffsetChatWin6;
    private double yOffsetChatWin6;

    public static Stage stageForChat7;
    private Group chatWindow7;
    private double xOffsetChatWin7;
    private double yOffsetChatWin7;


    @Override
    public void start(Stage stage) throws Exception {
        Button button = new Button("3333");
        button.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                stageForChat = new Stage();
                stageForChat.initStyle(StageStyle.TRANSPARENT);

                chatWindow = new ChatWindow(PROPERTIES).createGroup();

                chatWindow.getChildren().get(11).setOnMousePressed(event1 -> {
                    xOffsetChatWin = event1.getSceneX();
                    yOffsetChatWin = event1.getSceneY();
                });

                chatWindow.getChildren().get(11).setOnMouseDragged(event12 -> {
                    stageForChat.setX(event12.getScreenX() - xOffsetChatWin);
                    stageForChat.setY(event12.getScreenY() - yOffsetChatWin);
                });

                Scene scene = new Scene(chatWindow, 420, 370);
                scene.setFill(Color.TRANSPARENT);
                scene.getStylesheets().add("styles.css");

                stageForChat.setScene(scene);

                stageForChat.setX(300);
                stageForChat.setY(300);

                stageForChat.setOpacity(1);
                stageForChat.show();

                Chat chat = new Chat(chatWindow, stageForChat, 3333);
                Thread thread1 = new Thread(chat);
                thread1.start();
            }
        });

        Button button1 = new Button("3334");
        button1.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                stageForChat4 = new Stage();
                stageForChat4.initStyle(StageStyle.TRANSPARENT);

                chatWindow4 = new ChatWindow(PROPERTIES).createGroup();

                chatWindow4.getChildren().get(11).setOnMousePressed(event1 -> {
                    xOffsetChatWin4 = event1.getSceneX();
                    yOffsetChatWin4 = event1.getSceneY();
                });

                chatWindow4.getChildren().get(11).setOnMouseDragged(event12 -> {
                    stageForChat4.setX(event12.getScreenX() - xOffsetChatWin4);
                    stageForChat4.setY(event12.getScreenY() - yOffsetChatWin4);
                });

                Scene scene = new Scene(chatWindow4, 420, 370);
                scene.setFill(Color.TRANSPARENT);
                scene.getStylesheets().add("styles.css");

                stageForChat4.setScene(scene);

                stageForChat4.setX(300);
                stageForChat4.setY(300);

                stageForChat4.setOpacity(1);
                stageForChat4.show();

                Chat chat = new Chat(chatWindow4, stageForChat4, 3334);
                Thread thread1 = new Thread(chat);
                thread1.start();
            }
        });

        Button button2 = new Button("3335");
        button2.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                stageForChat5 = new Stage();
                stageForChat5.initStyle(StageStyle.TRANSPARENT);

                chatWindow5 = new ChatWindow(PROPERTIES).createGroup();

                chatWindow5.getChildren().get(11).setOnMousePressed(event1 -> {
                    xOffsetChatWin5 = event1.getSceneX();
                    yOffsetChatWin5 = event1.getSceneY();
                });

                chatWindow5.getChildren().get(11).setOnMouseDragged(event12 -> {
                    stageForChat5.setX(event12.getScreenX() - xOffsetChatWin5);
                    stageForChat5.setY(event12.getScreenY() - yOffsetChatWin5);
                });

                Scene scene = new Scene(chatWindow5, 420, 370);
                scene.setFill(Color.TRANSPARENT);
                scene.getStylesheets().add("styles.css");

                stageForChat5.setScene(scene);

                stageForChat5.setX(300);
                stageForChat5.setY(300);

                stageForChat5.setOpacity(1);
                stageForChat5.show();

                Chat chat = new Chat(chatWindow5, stageForChat5, 3335);
                Thread thread1 = new Thread(chat);
                thread1.start();
            }
        });

        Button button3 = new Button("3336");
        button3.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                stageForChat6 = new Stage();
                stageForChat6.initStyle(StageStyle.TRANSPARENT);

                chatWindow6 = new ChatWindow(PROPERTIES).createGroup();

                chatWindow6.getChildren().get(11).setOnMousePressed(event1 -> {
                    xOffsetChatWin6 = event1.getSceneX();
                    yOffsetChatWin6 = event1.getSceneY();
                });

                chatWindow6.getChildren().get(11).setOnMouseDragged(event12 -> {
                    stageForChat6.setX(event12.getScreenX() - xOffsetChatWin6);
                    stageForChat6.setY(event12.getScreenY() - yOffsetChatWin6);
                });

                Scene scene = new Scene(chatWindow6, 420, 370);
                scene.setFill(Color.TRANSPARENT);
                scene.getStylesheets().add("styles.css");

                stageForChat6.setScene(scene);

                stageForChat6.setX(300);
                stageForChat6.setY(300);

                stageForChat6.setOpacity(1);
                stageForChat6.show();

                Chat chat = new Chat(chatWindow6, stageForChat6, 3336);
                Thread thread1 = new Thread(chat);
                thread1.start();
            }
        });

        Button button4 = new Button("3337");
        button4.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                stageForChat7 = new Stage();
                stageForChat7.initStyle(StageStyle.TRANSPARENT);

                chatWindow7 = new ChatWindow(PROPERTIES).createGroup();

                chatWindow7.getChildren().get(11).setOnMousePressed(event1 -> {
                    xOffsetChatWin7 = event1.getSceneX();
                    yOffsetChatWin7 = event1.getSceneY();
                });

                chatWindow7.getChildren().get(11).setOnMouseDragged(event12 -> {
                    stageForChat7.setX(event12.getScreenX() - xOffsetChatWin7);
                    stageForChat7.setY(event12.getScreenY() - yOffsetChatWin7);
                });

                Scene scene = new Scene(chatWindow7, 420, 370);
                scene.setFill(Color.TRANSPARENT);
                scene.getStylesheets().add("styles.css");

                stageForChat7.setScene(scene);

                stageForChat7.setX(300);
                stageForChat7.setY(300);

                stageForChat7.setOpacity(1);
                stageForChat7.show();

                Chat chat = new Chat(chatWindow7, stageForChat7, 3337);
                Thread thread1 = new Thread(chat);
                thread1.start();
            }
        });

        Pane pane = new Pane();
        pane.getChildren().addAll(button, button1, button2, button3, button4);
        Scene scene = new Scene(pane, 150, 150);
        stage.setTitle("control.Main");

        stage.setScene(scene);
        stage.show();

    }

    public static void main(String[] args) {
        launch();
    }
}
