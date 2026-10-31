
package ma.emsi.namous.tp2.tests;
import ma.emsi.namous.tp2.outil.meteo.MeteoTool;

public class TestMeteo {
    public static void main(String[] args) {
        MeteoTool meteo = new MeteoTool();
        boolean pluie = meteo.isPluiePrevue(48.85, 2.35, 0, 3);
        System.out.println("pluie sur Paris? " + pluie);
    }
}
