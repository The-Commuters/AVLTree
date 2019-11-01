package AVLVisualTree;

public class VisualNode extends AVLNode {

    double halfText = 10.0;

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
     *
     * må finne ut av en type retur-objekt
     * */

    public VisualNode(Comparable content) {
        super(content);
    }

    // testing vertion to make text + lines for the nodes
    public void makeVisual(double myY, double YGrowth, double myX, double Xadjustment){
        System.out.println("node at " + super.height() + " height creates text at X=" + myX + " Y=" + myY);

        // left side subtrakts from Y
        if(super.left != null){
            System.out.println("line from X=" + myX + " Y=" + (myY + halfText) + " -to- X=" + (myX - Xadjustment) + " Y=" + (myY + YGrowth - halfText)); // erstatt med Line()
            makeVisual((myY + YGrowth), YGrowth, myX - Xadjustment, (Xadjustment/2));
        }

        // Right side adds to Y
        if(super.right != null){
            System.out.println("line from X=" + myX + " Y=" + (myY + halfText) + " -to- X=" + (myX + Xadjustment) + " Y=" + (myY + YGrowth - halfText)); // erstatt med Line()
            makeVisual((myY + YGrowth), YGrowth, myX + Xadjustment, (Xadjustment/2));
        }
    }


}
