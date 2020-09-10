package lt.verbus;

import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontSmoothingType;
import javafx.scene.text.Text;

public class Konsole extends VBox {
    private Text tekstas = new Text();
    private int konsolesEiluciuIndeksas = 0;

    public Konsole() {
        piestiKonsole();
    }

    private void piestiKonsole() {

        setStyle("-fx-background-color: #3b9e3b;\n"
                + "-fx-border-color: limegreen;\n"
                + "-fx-border-insets: 3;\n"
                + "-fx-border-width: 1;\n"
                + "-fx-border-style: dashed;\n"
        );

        setMinWidth(250);

        tekstas.setFill(Color.LIME);
        tekstas.setFont(Font.font("Courier New" /*, FontWeight.BOLD*/, 11));
        tekstas.setFontSmoothingType(FontSmoothingType.LCD);
        tekstas.setLineSpacing(2);

        getChildren().add(tekstas);

    }

    public void valytiKonsole() {
        tekstas.setText("");
    }

    public void pildytiKonsole(String pildytiTekstu) {

        konsolesEiluciuIndeksas++;

        if (kiekEiluciu(tekstas.getText()) < 19) {
            tekstas.setText(tekstas.getText() + konsolesEiluciuIndeksas + " " + pildytiTekstu + "\n");

        } else tekstas.setText(konsolesEiluciuIndeksas + " " + pildytiTekstu + "\n");

    }

    public static int kiekEiluciu(String str) {
        if (str == null || str.isEmpty()) {
            return 0;
        }
        int eiluciu = 1;
        int i = 0;
        while ((i = str.indexOf("\n", i) + 1) != 0) {
            eiluciu++;
        }
        return eiluciu;
    }


}
