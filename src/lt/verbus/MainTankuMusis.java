package lt.verbus;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.*;
import javafx.stage.Stage;

public class MainTankuMusis extends Application {



    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage zaidimoLangas) {

        BorderPane zaidimoInterface = new BorderPane();

        Radaras radaras = new Radaras();`
        Pultelis pultelis = new Pultelis();
        Konsole konsole = new Konsole();
        konsole.pildytiKonsole(radaras.getPaskutinisVeiksmas());

        //PULTELIO VEIKLA. NESUGALVOJAU KAIP LAMBDAS Į PULTELIO KLASĘ NUKIŠT
        pultelis.btAukstyn.setOnAction(e -> {
            radaras.aukstyn();
            konsole.pildytiKonsole(radaras.getPaskutinisVeiksmas());
        });

        pultelis.btDesinen.setOnAction(e -> {
            radaras.desinen();
            konsole.pildytiKonsole(radaras.getPaskutinisVeiksmas());
        });

        pultelis.btZemyn.setOnAction(e -> {
            radaras.zemyn();
            konsole.pildytiKonsole(radaras.getPaskutinisVeiksmas());
        });

        pultelis.btKairen.setOnAction(e -> {
            radaras.kairen();
            konsole.pildytiKonsole(radaras.getPaskutinisVeiksmas());
        });

        pultelis.btA.setOnAction(e -> {
            radaras.suvis();
            konsole.pildytiKonsole(radaras.getPaskutinisVeiksmas());
        });

        pultelis.btB.setOnAction(e -> {
            radaras.raportuoti();
            konsole.valytiKonsole();
            konsole.pildytiKonsole(radaras.getPaskutinisVeiksmas());
        });

        zaidimoInterface.setBottom(pultelis);
        zaidimoInterface.setCenter(radaras);
        zaidimoInterface.setRight(konsole);
        Scene vaizdas = new Scene(zaidimoInterface, 550, 430);

        zaidimoLangas.setScene(vaizdas);
        zaidimoLangas.setTitle("Tanko Mūšis");
        zaidimoLangas.setResizable(false);
        zaidimoLangas.show();

    }

}
