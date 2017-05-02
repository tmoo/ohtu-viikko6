package ohtu;

import javax.swing.JTextField;

/**
 *
 * @author tuomo
 */
public class Erotus implements Komento {

    private Sovelluslogiikka sovellus;
    private JTextField tuloskentta;
    private JTextField syotekentta;
    private int edellinen;

    public Erotus(Sovelluslogiikka sovellus, JTextField tuloskentta, JTextField syotekentta) {
        this.sovellus = sovellus;
        this.tuloskentta = tuloskentta;
        this.syotekentta = syotekentta;
    }

    @Override
    public void suorita() {
        int arvo = 0;

        try {
            arvo = Integer.parseInt(syotekentta.getText());
        } catch (Exception e) {
        }
        sovellus.miinus(arvo);

        int laskunTulos = sovellus.tulos();

        edellinen = Integer.parseInt(tuloskentta.getText());

        syotekentta.setText("");
        tuloskentta.setText("" + laskunTulos);
    }

    @Override
    public void peru() {
        sovellus.nollaa();
        sovellus.plus(edellinen);
        tuloskentta.setText("" + sovellus.tulos());
    }
}
