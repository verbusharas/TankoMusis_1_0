package lt.verbus;

import java.util.ArrayList;

public class Tankas {

    private int[] dabartinesKoordinates = new int[2];
    private String kryptis = "į Šiaurę";
    private ArrayList<int[]> koordinaciuZurnalas = new ArrayList<>();
    private ArrayList<String> veiksmuZurnalas = new ArrayList<>();
    private int[] suviuSkaicius = {0, 0, 0, 0};
    // Šūvių skaičiaus masyvo indeksų paaiškinimas:
    // 0 - į šiaurę;
    // 1 - į rytus;
    // 2 - į pietus;
    // 3 - į vakarus
    private final int ZINGSNIS = 30;

    //ČIA NESUGALVOJU KAIP REIKĖTŲ PRIKABINTI PRIE KITOS KLASĖS "PANE" MATMENŲ MINUS ŽINGSNIS?????
    private int minLeistinasX = 30;
    private int maxLeistinasX = 270;
    private int minLeistinasY = 30;
    private int maxLeistinasY = 270;

    public Tankas() {
        dabartinesKoordinates[0] = 150; //x
        dabartinesKoordinates[1] = 150; //y
        koordinaciuZurnalas.add(dabartinesKoordinates);
        veiksmuZurnalas.add("TANKAS PRADEDA MISIJĄ");
    }

    public Tankas(int pradinisX, int pradinisY) {
        dabartinesKoordinates[0] = pradinisX; //x
        dabartinesKoordinates[1] = pradinisY; //y
        koordinaciuZurnalas.add(dabartinesKoordinates);
        veiksmuZurnalas.add("TANKAS PRADEDA MISIJĄ");
    }

    public void aukstyn() {
        kryptis = "į Šiaurę";
        if (dabartinesKoordinates[1] > minLeistinasY) {
            dabartinesKoordinates[0] += 0; //x
            dabartinesKoordinates[1] -= ZINGSNIS; //y
            koordinaciuZurnalas.add(dabartinesKoordinates);
            veiksmuZurnalas.add("Tankas pajuda " + kryptis + " (" + dabartinesKoordinates[0] + ", " + dabartinesKoordinates[1] + ")");
        } else veiksmuZurnalas.add("(!)TANKAS PASIEKĖ ZONOS RIBĄ(!)");
        System.out.println(veiksmuZurnalas.get(veiksmuZurnalas.size() - 1));
    }

    public void zemyn() {
        kryptis = "į Pietus";
        if (dabartinesKoordinates[1] < maxLeistinasY) {
            dabartinesKoordinates[0] += 0; //x
            dabartinesKoordinates[1] += ZINGSNIS; //y
            koordinaciuZurnalas.add(dabartinesKoordinates);
            veiksmuZurnalas.add("Tankas pajuda " + kryptis + " (" + dabartinesKoordinates[0] + ", " + dabartinesKoordinates[1] + ")");
        } else veiksmuZurnalas.add("(!)TANKAS PASIEKĖ ZONOS RIBĄ(!)");
        System.out.println(veiksmuZurnalas.get(veiksmuZurnalas.size() - 1));
    }

    public void desinen() {
        kryptis = "į Rytus";
        if (dabartinesKoordinates[0] < maxLeistinasX) {
            dabartinesKoordinates[0] += ZINGSNIS; //x
            dabartinesKoordinates[1] += 0; //y
            koordinaciuZurnalas.add(dabartinesKoordinates);
            veiksmuZurnalas.add("Tankas pajuda " + kryptis + " (" + dabartinesKoordinates[0] + ", " + dabartinesKoordinates[1] + ")");
        } else veiksmuZurnalas.add("(!)TANKAS PASIEKĖ ZONOS RIBĄ(!)");
        System.out.println(veiksmuZurnalas.get(veiksmuZurnalas.size() - 1));
    }

    public void kairen() {
        kryptis = "į Vakarus";
        if (dabartinesKoordinates[0] > minLeistinasX) {
            dabartinesKoordinates[0] -= ZINGSNIS; //x
            dabartinesKoordinates[1] += 0; //y
            koordinaciuZurnalas.add(dabartinesKoordinates);
            veiksmuZurnalas.add("Tankas pajuda " + kryptis + " (" + dabartinesKoordinates[0] + ", " + dabartinesKoordinates[1] + ")");
        } else veiksmuZurnalas.add("(!)TANKAS PASIEKĖ ZONOS RIBĄ(!)");
        System.out.println(veiksmuZurnalas.get(veiksmuZurnalas.size() - 1));
    }

    public void suvis() {
        switch (kryptis) {
            case "į Šiaurę":
                suviuSkaicius[0]++;
                break;
            case "į Rytus":
                suviuSkaicius[1]++;
                break;
            case "į Pietus":
                suviuSkaicius[2]++;
                break;
            case "į Vakarus":
                suviuSkaicius[3]++;
                break;
        }

        veiksmuZurnalas.add("Šūvis " + kryptis);
        System.out.println(veiksmuZurnalas.get(veiksmuZurnalas.size() - 1));

    }

    public void getInfo() {

        int suviuSuma = 0;
        for (int suviai : suviuSkaicius) suviuSuma += suviai;

        String info = "TANKO VEIKSMŲ RAPORTAS:\n";
        info += "..................................\n";
        info += ". Tanko koordinatės: \n";
        info += ". x=" + dabartinesKoordinates[0] + ", y=" + dabartinesKoordinates[1];
        info += ", kryptis: " + kryptis + ".\n";
        info += "..................................\n";
        info += ". Tanko šūvių istorija:\n";
        info += ". " + " į Šiaurę: " + suviuSkaicius[0] + "\n";
        info += ". " + " į Rytus: " + suviuSkaicius[1] + "\n";
        info += ". " + " į Pietus: " + suviuSkaicius[2] + "\n";
        info += ". " + " į Vakarus: " + suviuSkaicius[3] + "\n";
        info += ".  Viso šūvių: " + suviuSuma + "\n";
        info += "..................................\n";

        veiksmuZurnalas.add(info);
        System.out.println(info);
    }

    public ArrayList<int[]> getKoordinaciuZurnalas() {
        return koordinaciuZurnalas;
    }

    public ArrayList<String> getVeiksmuZurnalas() {
        return veiksmuZurnalas;
    }

    public int getZINGSNIS() {
        return ZINGSNIS;
    }

    public String getKryptis() {
        return kryptis;
    }

    public int getX() {
        return dabartinesKoordinates[0];
    }

    public int getY() {
        return dabartinesKoordinates[1];
    }

    public int getMinLeistinasX() {
        return minLeistinasX;
    }

    public int getMaxLeistinasX() {
        return maxLeistinasX;
    }

    public int getMinLeistinasY() {
        return minLeistinasY;
    }

    public int getMaxLeistinasY() {
        return maxLeistinasY;
    }
}
