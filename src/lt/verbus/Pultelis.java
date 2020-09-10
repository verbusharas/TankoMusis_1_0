package lt.verbus;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;

public class Pultelis extends GridPane {

    protected Button btAukstyn = new Button();
    protected Button btDesinen = new Button();
    protected Button btZemyn = new Button();
    protected Button btKairen = new Button();
    protected Button btA = new Button();
    protected Button btB = new Button();

    public Pultelis(){
        gamintiPulteli();
    }

    private void gamintiPulteli() {
        btAukstyn.setText("↑ Aukštyn");
        btAukstyn.setMinWidth(70);

        btDesinen.setText("→ Dešinėn");
        btDesinen.setMinWidth(70);

        btZemyn.setText("↓ Žemyn");
        btZemyn.setMinWidth(70);

        btKairen.setText("← Kairėn");
        btKairen.setMinWidth(70);

        btA.setText("☼ Šūvis");
        btA.setMinWidth(70);
        btA.setMinHeight(40);

        btB.setText("Info");
        btB.setMinWidth(70);
        btB.setMinHeight(40);

        setAlignment(Pos.CENTER);
        setMaxHeight(100);
        setPadding(new Insets(10, 10, 10, 10));
        setHgap(5);
        setVgap(5);

        add(btAukstyn, 1, 0);
        add(btDesinen, 3, 1);
        add(btZemyn,   1, 2);
        add(btKairen,  0, 1);

        add(btA,       8, 1);
        add(btB,       9, 1);

        setStyle("-fx-background-color: #3b9e3b;\n"
                +   "-fx-border-color: limegreen;\n"
                +   "-fx-border-insets: 3;\n"
                +   "-fx-border-width: 1;\n"
                +   "-fx-border-style: dashed;\n"
        );
    }
}
