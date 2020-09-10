package lt.verbus;

import javafx.animation.FadeTransition;
import javafx.animation.Timeline;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.util.Duration;

public class Radaras extends Pane {

    //ČIA NESUGALVOJU KAIP REIKĖTŲ PRIKABINTI PRIE "PANE" MATMENŲ PER PUSĘ ?????
    private final double CENTRO_X = 150.0;
    private final double CENTRO_Y = 150.0;

    private double dabartinisX = CENTRO_X;
    private double dabartinisY = CENTRO_Y;
    private double sekantisX;
    private double sekantisY;

    private Tankas tankiukas = new Tankas((int) CENTRO_X, (int) CENTRO_Y);
    private double zingsnis = tankiukas.getZINGSNIS();

    private Circle tankoSimbolis = new Circle(CENTRO_X, CENTRO_Y, zingsnis / 4);


    public Radaras() {
        piestiRadara();
    }

    private void piestiRadara() {
        //Radaro spalva
        setStyle("-fx-background-color: forestgreen");
        kurtiRadaroCrosshair();
        kurtiRadaroTinkleli();
        kurtiTankoSimboli();

    }

    public void aukstyn() {
        tankiukas.aukstyn();
        sekantisX = dabartinisX;
        sekantisY = tankiukas.getY();
        piestiJudejimoTrajektorija();
        dabartinisX = sekantisX;
        dabartinisY = sekantisY;
    }

    public void zemyn() {
        tankiukas.zemyn();
        sekantisX = dabartinisX;
        sekantisY = tankiukas.getY();
        piestiJudejimoTrajektorija();
        dabartinisX = sekantisX;
        dabartinisY = sekantisY;
    }

    public void desinen() {

        tankiukas.desinen();
        sekantisX = tankiukas.getX();
        sekantisY = dabartinisY;
        piestiJudejimoTrajektorija();
        dabartinisX = sekantisX;
        dabartinisY = sekantisY;
    }

    public void kairen() {
        tankiukas.kairen();
        sekantisX = tankiukas.getX();
        sekantisY = dabartinisY;
        piestiJudejimoTrajektorija();
        dabartinisX = sekantisX;
        dabartinisY = sekantisY;
    }

    public void suvis() {
        String kryptis = tankiukas.getKryptis();
        tankiukas.suvis();
        piestiSuvi(kryptis);
    }

    public void raportuoti() {
        tankiukas.getInfo();
    }

    public String getPaskutinisVeiksmas() {
        return tankiukas.getVeiksmuZurnalas().get(tankiukas.getVeiksmuZurnalas().size() - 1);
    }

    private void kurtiRadaroCrosshair() {
        //Radaro "crosshair" kryžius
        Color zaliaTaikinioSpalva = Color.rgb(52, 152, 52);

        Line crosshairLinijaV = new Line(CENTRO_X, 0, CENTRO_X, 300);
        crosshairLinijaV.setStrokeWidth(1);
        crosshairLinijaV.setStroke(zaliaTaikinioSpalva);
        crosshairLinijaV.getStrokeDashArray().addAll(3d, 3d);
        getChildren().add(crosshairLinijaV);

        Line crosshairLinijaH = new Line(0, CENTRO_Y, 300, CENTRO_Y);
        crosshairLinijaH.setStrokeWidth(1);
        crosshairLinijaH.setStroke(zaliaTaikinioSpalva);
        crosshairLinijaH.getStrokeDashArray().addAll(3d, 3d);
        getChildren().add(crosshairLinijaH);

        //Radaro "crosshair" taikinio apskritimas
        Circle crosshairApskritimas = new Circle(CENTRO_X, CENTRO_Y, 150 - zingsnis);
        crosshairApskritimas.setStrokeWidth(1);
        crosshairApskritimas.setFill(Color.FORESTGREEN);
        crosshairApskritimas.setStroke(zaliaTaikinioSpalva);
        crosshairApskritimas.getStrokeDashArray().addAll(3d, 3d);
        getChildren().add(crosshairApskritimas);
        crosshairApskritimas.toBack();

        //Radaro pasaulio šalys
        Text siaure = new Text("Š");
        siaure.setFont(Font.font("Courier New" /*, FontWeight.BOLD*/, 15));
        siaure.setFill(Color.LIMEGREEN);
        siaure.setX(CENTRO_X - 4);
        siaure.setY(zingsnis - 10);
        getChildren().add(siaure);

        Text pietus = new Text("P");
        pietus.setFont(Font.font("Courier New" /*, FontWeight.BOLD*/, 15));
        pietus.setFill(Color.LIMEGREEN);
        pietus.setX(CENTRO_X - 4);
        pietus.setY(290);
        getChildren().add(pietus);

        Text vakarai = new Text("V");
        vakarai.setFont(Font.font("Courier New" /*, FontWeight.BOLD*/, 15));
        vakarai.setFill(Color.LIMEGREEN);
        vakarai.setX(10);
        vakarai.setY(CENTRO_Y + 4);
        getChildren().add(vakarai);

        Text rytai = new Text("R");
        rytai.setFont(Font.font("Courier New" /*, FontWeight.BOLD*/, 15));
        rytai.setFill(Color.LIMEGREEN);
        rytai.setX(280);
        rytai.setY(CENTRO_Y + 4);
        getChildren().add(rytai);
    }

    private void kurtiRadaroTinkleli() {
        //Radaro foninis tinklelis
        for (int i = 0; i < 10; i++) {
            Line radaroLinija = new Line(zingsnis * i, 0, zingsnis * i, 280);
            radaroLinija.setStrokeWidth(1);
            radaroLinija.setStroke(Color.LIMEGREEN);
            radaroLinija.getStrokeDashArray().addAll(1d, 29d);
            getChildren().add(radaroLinija);
        }
    }

    private void kurtiTankoSimboli() {
        tankoSimbolis.toFront();
        tankoSimbolis.setStrokeWidth(0);
        tankoSimbolis.setFill(Color.LIME);
        getChildren().add(tankoSimbolis);
        FadeTransition mirksejimas = new FadeTransition(Duration.millis(500), tankoSimbolis);
        mirksejimas.setFromValue(1.0);
        mirksejimas.setToValue(0.0);
        mirksejimas.setCycleCount(Timeline.INDEFINITE);
        mirksejimas.setAutoReverse(true);
        mirksejimas.play();
    }

    private void piestiJudejimoTrajektorija() {
        //Perkelti simbolį į naują tašką
        tankoSimbolis.setCenterX(sekantisX);
        tankoSimbolis.setCenterY(sekantisY);

        //Brėžti judėjimo trajektoriją nuo senojo taško
        Line trajektorija = new Line(dabartinisX, dabartinisY, sekantisX, sekantisY);
        trajektorija.setStrokeWidth(2);
        trajektorija.setStroke(Color.LIME);

        FadeTransition mirksejimas = new FadeTransition(Duration.millis(5000), trajektorija);
        mirksejimas.setFromValue(1.0);
        mirksejimas.setToValue(0.0);
        mirksejimas.setCycleCount(Timeline.INDEFINITE);
        mirksejimas.setAutoReverse(true);
        mirksejimas.play();

        getChildren().add(trajektorija);
    }

    private void piestiSuvi(String kryptis) {
        Line kulka = new Line();
        kulka.setStrokeWidth(1);
        kulka.setStroke(Color.WHITESMOKE);
        getChildren().add(kulka);
        kulka.getStrokeDashArray().addAll(3d, 3d);

        kulka.setStartX(tankiukas.getX());
        kulka.setStartY(tankiukas.getY());

        switch (kryptis) {
            case "į Šiaurę":
                kulka.setEndX(dabartinisX);
                kulka.setEndY(tankiukas.getMinLeistinasY());
                break;
            case "į Rytus":
                kulka.setEndX(tankiukas.getMaxLeistinasX());
                kulka.setEndY(dabartinisY);
                break;
            case "į Pietus":
                kulka.setEndX(dabartinisX);
                kulka.setEndY(tankiukas.getMaxLeistinasY());

                break;
            case "į Vakarus":
                kulka.setEndX(tankiukas.getMinLeistinasX());
                kulka.setEndY(dabartinisY);
                break;
        }

        FadeTransition blyksnis = new FadeTransition(Duration.millis(120), kulka);
        blyksnis.setFromValue(1.0);
        blyksnis.setToValue(0.0);
        blyksnis.setCycleCount(3);
        blyksnis.setAutoReverse(false);
        blyksnis.play();


    }


    @Override
    public void setWidth(double plotis) {
        super.setWidth(plotis);

    }

    @Override
    public void setHeight(double aukstis) {
        super.setHeight(aukstis);

    }


}