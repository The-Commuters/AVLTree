package avltree;

public class VisualTre extends AVLTre {



    public VisualTre(Comparable inn) {
        super(inn);
    }

    /*
    *forutsetter at treet er allerede lagd, metode ber om et Pane med riktigt bilde på
    *
    * finne distansen mellom objekter på X-aksen basert på treets høyde
    *
    * finne distansen til objekter på Y-aksen
    *   y/2 med mulige justeringer, så tar itterasjonen sev av oppdelingen
    *
    * spørre VisualNode om og skrive på en pane (foreldreX, vekstX, dinY, pane/liste/objekt som largrer)
    * hver nodegjør dette:
    *   skriver sit tall
    *   lager en strek til hvert av barna sine
    *   ber barna om og gjøre det samme
    *       X og Y kordinater er basert på metodene over
    *           Y vokser fast nedover med en variabel som blir sent fra en til hver itterasjon
    *           X krymper eller vokser med halvparten av sine foreldres styrke
    *               venstre blir halvparten mindre
    *               høyre blir halvparten større
    * */

    public void makeVisual(double viewX, double viewY){
        double xStart = viewX / 2;
        double yGrowth = viewY / (root.height() + 1);
        System.out.println("X start: " + xStart + " | Y start: " + yGrowth);
        VisualNode visualRoot = (VisualNode)super.root;
        visualRoot.makeVisual(yGrowth, yGrowth, xStart, xStart);
        // kalle på VisualNode in metod eog skrive n' ut
    }



}
