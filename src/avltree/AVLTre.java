package avltree;

/**
 *
 * @author Mads
 */
public class AVLTre<E extends Comparable<E>> {
    private AVLNode<E> root;

    public AVLTre(E inn) {
        root = new AVLNode(inn);
    }

    public void add(E inn){
        root.addContent(inn);
    }

    public int size(){
        return root.size();
    }

    public int height(){
        return root.height();
    }

    public E find(E target){
        return root.find(target);
    }

}
