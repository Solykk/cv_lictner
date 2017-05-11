package service;

import javafx.scene.control.TextArea;
import javafx.scene.effect.BoxBlur;
import javafx.scene.effect.Glow;
import javafx.scene.paint.Color;
import javafx.scene.shape.Polygon;
import javafx.scene.shape.Polyline;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import javafx.scene.text.TextFlow;

/**
 * Created by Solyk on 03.05.2017.
 */
public class ViewProperties {

    public Polyline getPolylineBoxBlur(Polyline polyline) {
        polyline.setStroke(Color.WHITE);
        polyline.setStrokeWidth(1);
        polyline.setEffect(new BoxBlur(2,2,1));
        return polyline;
    }

    public Polyline getPolylineGlow(Polyline polyline) {
        polyline.setStroke(Color.WHITE);
        polyline.setStrokeWidth(1);
        polyline.setEffect(new Glow(1));
        return polyline;
    }

    public Polygon getBasicLayer(Polygon polygon) {
        polygon.setFill(Color.WHITE);
        polygon.setOpacity(0.2);
        polygon.setEffect(new BoxBlur(5,5,2));
        return polygon;
    }

    public Polygon getBodyLayer(Polygon polygon, Color color) {
        if(color != null){
            polygon.setFill(color);
        }
        polygon.setOpacity(0.85);
        return polygon;
    }

    public Polygon getAdjustmentLayer(Polygon polygon) {
        polygon.setFill(Color.WHITE);
        polygon.setOpacity(0.1);
        polygon.setEffect(new BoxBlur(1,1,2));
        return polygon;
    }

    public Text getTextProperties(String text, int size) {
        Text result = new Text();
        result.setFont(new Font("Book Antiqua", size));
        result.setFill(Color.WHITE);
        result.setTextAlignment(TextAlignment.JUSTIFY);
        result.setText(text);
        result.setEffect(new Glow(0.75));
        return result;
    }

    public TextFlow getTextFlowForNodeWin(Text text){
        TextFlow result = new TextFlow(text);
        result.setLayoutX(633);
        result.setLayoutY(370);
        result.setTextAlignment(TextAlignment.CENTER);
        result.setPrefSize(100,20);
        return result;
    }

    public TextFlow getTextFlowForCVWinHead(Text text){
        TextFlow result = new TextFlow(text);
        result.setLayoutX(188);
        result.setLayoutY(12);
        result.setTextAlignment(TextAlignment.CENTER);
        result.setPrefSize(160,20);
        return result;
    }

    public TextFlow getTextFlowForCVWinHeadUnder(Text text){
        TextFlow result = new TextFlow(text);
        result.setLayoutX(28);
        result.setLayoutY(38);
        result.setTextAlignment(TextAlignment.CENTER);
        result.setPrefSize(480,20);
        return result;
    }

    public TextArea getTextFlowForCVWinBody(String text){
        TextArea result = new TextArea(text);
        result.setEditable(false);
        result.setWrapText(true);
        result.setEffect(new Glow(0.4));
        result.setOpacity(0.7);
        result.setLayoutX(35);
        result.setLayoutY(76);
        result.setPrefSize(465,440);
        return result ;
    }

    public TextArea getTextFlowForCVWinFooter(String text){
        TextArea result = new TextArea(text);
        result.setEditable(false);
        result.setWrapText(true);
        result.setEffect(new Glow(0.4));
        result.setOpacity(0.7);
        result.setLayoutX(215);
        result.setLayoutY(565);
        result.setPrefSize(300,165);
        return result ;
    }

    public TextFlow getTextFlowForWhyWinHead(Text text){
        TextFlow result = new TextFlow(text);
        result.setLayoutX(138.66);
        result.setLayoutY(12.2);
        result.setTextAlignment(TextAlignment.CENTER);
        result.setPrefSize(140,15);
        return result;
    }

    public TextFlow getTextFlowForWhyWinHeadUnder(Text text){
        TextFlow result = new TextFlow(text);
        result.setLayoutX(23.66);
        result.setLayoutY(30.9);
        result.setTextAlignment(TextAlignment.CENTER);
        result.setPrefSize(370,18);
        return result;
    }

    public TextArea getTextFlowForWhyWinBody(String text){
        TextArea result = new TextArea(text);
        result.setEditable(false);
        result.setWrapText(true);
        result.setEffect(new Glow(0.4));
        result.setOpacity(0.7);
        result.setLayoutX(33);
        result.setLayoutY(60);
        result.setPrefSize(352,271);
        return result ;
    }

    public TextArea getTextFlowForChatInputLayer(){
        TextArea result = new TextArea();
        result.setEditable(true);
        result.setWrapText(true);
        result.setEffect(new Glow(0.4));
        result.setOpacity(0.7);
        result.setLayoutX(122);
        result.setLayoutY(245);
        result.setPrefSize(261,81);
        return result ;
    }

    public TextArea getTextFlowForChatOutputLayer(){
        TextArea result = new TextArea();
        result.setEditable(false);
        result.setWrapText(true);
        result.setEffect(new Glow(0.4));
        result.setOpacity(0.7);
        result.setLayoutX(33);
        result.setLayoutY(60);
        result.setPrefSize(352,171);
        return result ;
    }

    public TextFlow getTextFlowForChatSendButton(Text text){
        TextFlow result = new TextFlow(text);
        result.setLayoutX(35);
        result.setLayoutY(292);
        result.setTextAlignment(TextAlignment.CENTER);
        result.setPrefSize(65,16);
        return result;
    }

}
