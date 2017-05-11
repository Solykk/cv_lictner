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

    public static Boolean isChatWindowOn;

    private double xOffsetChatWin;
    private double yOffsetChatWin;
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
                isChatWindowOn = true;

                Chat chat = new Chat(chatWindow, stageForChat, 3333);
                Thread thread1 = new Thread(chat);
                thread1.start();
            }
        });

        Pane pane = new Pane();
        pane.getChildren().add(button);
        Scene scene = new Scene(pane, 400, 400);
        stage.setTitle("control.Main");

        stage.setScene(scene);
        stage.show();

    }

    public static void main(String[] args) {
        launch();
    }
}
