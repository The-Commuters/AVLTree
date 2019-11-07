package AVLTree;

import javafx.scene.layout.Pane;
import javafx.scene.shape.Line;
import javafx.scene.text.Text;

public class AVLVisualTree<T extends Comparable<T>> extends Pane {
    AVLTree<T> tree = new AVLTree<T>();

    public AVLVisualTree() {
        super();
    }

    public void insert(T element){
        tree.insert(element);
        //metode som kjører makeMe()
    }

    public T search(T element){
        return (T) tree.search(element);
    }

    // re-draws the entire tree
    public void refresh(){
        clear();
        double xGrowth = (this.getHeight() / tree.root.height);
        double yStart = this.getWidth()/2;
        create(tree.root, xGrowth,yStart, xGrowth, yStart/2);
    }

    private void clear(){
        this.getChildren().clear();
    }

    /*
    * rekusiv metode somtar inn et rot element og skriver seg til pane sammen med alle barna sine
    * tar inn det følgende
    * AVLNode node - roten som skal lages
    * double startX - denne rotens start på X-aksen
    * double startY - denne rotens start på Y-aksen
    * double yAdjustment - hvor mye barna til denne noden skal flyttes til høyre/venstre i forhold til startY
    * double xAdjustment - hvor mye lengre ned barna skal være en startX
    *
    * metoden skal:
    * skrive ut sit tall (kansje sette ring runt det senere)
    * lage linje fra seg til barna sine hvis de finest og så kalde seg selv på barna
    * */
    private void create(AVLNode node, double startX, double startY, double xAdjustment, double yAdjustment){
        Text me = new Text(startX, startY, "" + node.element.toString());
        this.getChildren().add(me);

        if (node.left != null){
            Line pointer = new Line(startX, startY, (startX + xAdjustment), (startY - yAdjustment));
            this.getChildren().add(pointer);
            create(node.left, (startX + xAdjustment), (startY - yAdjustment), xAdjustment, (yAdjustment/2));
        }
        if (node.right != null){
            Line pointer = new Line(startX, startY, (startX + xAdjustment), (startY + yAdjustment));
            this.getChildren().add(pointer);
            create(node.right, (startX + xAdjustment), (startY + yAdjustment), xAdjustment, (yAdjustment/2));
        }

    }
}
