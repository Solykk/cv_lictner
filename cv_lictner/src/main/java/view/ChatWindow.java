package view;

import javafx.scene.Group;
import javafx.scene.control.TextArea;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;
import javafx.scene.shape.Polygon;
import javafx.scene.shape.Polyline;
import javafx.scene.text.Text;
import javafx.scene.text.TextFlow;
import service.ViewProperties;

/**
 * Created by Solyk on 04.05.2017.
 */
public class ChatWindow{

    private String headText = "Chat";
    private String headUnderText;
    private String buttonText = "Send";
    private String inputInitText = "";
    private String outputInitText = "";

    private ViewProperties properties;

    public ChatWindow(ViewProperties properties, int port) {
        this.properties = properties;
        this.headUnderText = "chat - " + String.valueOf(port);
    }

    public Group createGroup(){

        Group group = new Group();

        Polygon basicLayer = properties.getBasicLayer(new Polygon(getPolygonAdjustmentLayer()));

        Polygon bodyLayerBlack = properties.getBodyLayer(new Polygon(getPolygonBodyBlack()), null);
        Polygon bodyLayerRed = properties.getBodyLayer(new Polygon(getPolygonBodyRed()), Color.rgb(255,40,0));

        Polyline polylineBlurHead = properties.getPolylineBoxBlur(new Polyline(getPolylineHead()));
        Polyline polylineGlowHead = properties.getPolylineGlow(new Polyline(getPolylineHead()));

        Group polylineLayerHead = new Group(polylineBlurHead, polylineGlowHead);

        Polyline polylineBlurBody = properties.getPolylineBoxBlur(new Polyline(getPolylineBody()));
        Polyline polylineGlowBody = properties.getPolylineGlow(new Polyline(getPolylineBody()));

        Group polylineLayerBody = new Group(polylineBlurBody, polylineGlowBody);

        Polyline polylineBlurFooter = properties.getPolylineBoxBlur(new Polyline(getPolylineFooter()));
        Polyline polylineGlowFooter = properties.getPolylineGlow(new Polyline(getPolylineFooter()));

        Group polylineLayerFooter = new Group(polylineBlurFooter, polylineGlowFooter);

        Polygon adjustmentLayer = properties.getAdjustmentLayer(new Polygon(getPolygonAdjustmentLayer()));

        Text textH = properties.getTextProperties(headText, 12);
        Text textHU = properties.getTextProperties(headUnderText, 16);

        TextFlow textLayerHead = properties.getTextFlowForWhyWinHead(textH);
        TextFlow textLayerHeadUnder = properties.getTextFlowForWhyWinHeadUnder(textHU);

        TextArea textOutputLayer = properties.getTextFlowForChatOutputLayer();
        textOutputLayer.setPromptText(outputInitText);

        TextArea textInputLayer = properties.getTextFlowForChatInputLayer();
        textInputLayer.setPromptText(inputInitText);

        Polygon usedBodyLayerRed = properties.getBodyLayer(new Polygon(getPolygonBodyRed()), Color.rgb(0,0,0));
        usedBodyLayerRed.setOpacity(0.01);

        ImageView closeButton = getCloseButton();

        Text textButton = properties.getTextProperties(buttonText, 12);
        TextFlow textButtonLayer = properties.getTextFlowForChatSendButton(textButton);

        Polygon sendButton  = properties.getBodyLayer(new Polygon(getPolygonButtonLayer()), Color.rgb(255,40,0));
        sendButton.setOpacity(0.6);

        group.getChildren().addAll(basicLayer,
                bodyLayerBlack, bodyLayerRed,
                polylineLayerHead, polylineLayerBody, polylineLayerFooter,
                adjustmentLayer,
                textLayerHead, textLayerHeadUnder, textInputLayer, textOutputLayer,
                usedBodyLayerRed, closeButton,
                textButtonLayer, sendButton);

        return group;
    }

    private ImageView getCloseButton() {
        ImageView closeButton = new  ImageView(new Image("CloseButton.png"));
        closeButton.setScaleX(0.70);
        closeButton.setScaleY(0.70);
        closeButton.setLayoutY(10);
        closeButton.setLayoutX(262);
        closeButton.setOpacity(0.25);
        return closeButton;
    }

    private double[] getPolylineFooter() {
        return new double[]{
                23.09,264.145,
                21.935,264.145,
                23.09,267.995,
                23.09,287.245,
                10,294.803,
                10,300.121,
                23.09,307.678,
                23.09,322.975,
                10,335.102,
                10,351.084,
                12.31,353.394,
                133.2,353.394,
                146.29,340.304,
                271.03,340.304,
                284.12,353.394,
                405.01,353.394,
                407.32,351.084,
                407.32,335.102,
                394.23,322.975,
                394.23,307.678,
                407.32,300.121,
                407.32,294.803,
                394.23,287.245,
                394.23,245.746,
                381.14,238.189,
                113.74,238.189,
                100.65,245.746,
                100.65,265.746
        };
    }

    private double[] getPolylineBody() {
        return new double[]{
                394.23,149.35,
                393.075,149.35,
                394.23,145.5,
                394.23,126.25,
                407.32,118.693,
                407.32,113.375,
                394.23,105.817,
                394.23,85.951,
                407.32,78.394,
                407.32,53.12,
                405.01,50.81,
                12.31,50.81,
                10,53.12,
                10,78.394,
                23.09,85.951,
                23.09,105.817,
                10,113.375,
                10,118.693,
                23.09,126.25,
                23.09,145.5,
                24.245,149.35,
                23.09,149.35
        };
    }

    public double[] getPolygonBodyRed() {
        return new double[]{
                407.32,30.02,
                405.01,27.71,
                301.83,27.71,
                297.887,26.077,
                283.443,11.633,
                279.5,10,
                137.82,10,
                133.877,11.633,
                119.433,26.077,
                115.49,27.71,
                12.31,27.71,
                10,30.02,
                10,48.5,
                12.31,50.81,
                405.01,50.81,
                407.32,48.5
        };
    }

    private double[] getPolylineHead() {
        return new double[]{
                407.32,30.02,
                405.01,27.71,
                301.83,27.71,
                297.887,26.077,
                283.443,11.633,
                279.5,10,
                137.82,10,
                133.877,11.633,
                119.433,26.077,
                115.49,27.71,
                12.31,27.71,
                10,30.02,
                10,48.5,
                12.31,50.81,
                405.01,50.81,
                407.32,48.5,
                407.32,30.02
        };
    }

    private double[] getPolygonBodyBlack() {
        return new double[]{
                10,78.394,
                23.09,85.951,
                23.09,105.817,
                10,113.375,
                10,118.693,
                23.09,126.25,
                23.09,287.245,
                10,294.803,
                10,300.121,
                23.09,307.678,
                23.09,322.975,
                10,335.102,
                10,351.084,
                12.31,353.394,
                133.2,353.394,
                146.29,340.304,
                271.03,340.304,
                284.12,353.394,
                405.01,353.394,
                407.32,351.084,
                407.32,335.102,
                394.23,322.975,
                394.23,307.678,
                407.32,300.121,
                407.32,294.803,
                394.23,287.245,
                394.23,126.25,
                407.32,118.693,
                407.32,113.375,
                394.23,105.817,
                394.23,85.951,
                407.32,78.394,
                407.32,53.12,
                405.01,50.81,
                12.31,50.81,
                10,53.12
        };
    }

    private double[] getPolygonAdjustmentLayer() {
        return new double[]{
                23.09,284.936,
                8,293.648,
                8,351.912,
                11.482,355.394,
                405.838,355.394,
                409.32,351.912,
                409.32,293.648,
                394.23,284.936,
                394.23,128.56,
                409.32,119.848,
                409.32,29.192,
                405.838,25.71,
                302.228,25.71,
                299.019,24.381,
                284.576,9.938,
                279.898,8,
                137.422,8,
                132.744,9.938,
                118.301,24.381,
                115.092,25.71,
                11.482,25.71,
                8,29.192,
                8,119.848,
                23.09,128.56
        };
    }

    private double[] getPolygonButtonLayer() {
        return new double[]{
                34.619,292.862,
                31.494,298.275,
                50.244,330.751,
                56.494,330.751,
                58.994,328.251,
                78.994,328.251,
                81.494,330.751,
                87.744,330.751,
                106.494,298.275,
                103.369,292.862,
                99.954,291.947,
                89.954,274.627,
                90.869,271.212,
                87.744,265.799,
                50.244,265.799,
                47.119,271.212,
                48.034,274.627,
                38.034,291.947
        };
    }
}
