package AVLTree;

public class AVLNode<T extends Comparable<T>> {
    T element;
    AVLNode<T> left;
    AVLNode<T> right;
    int height;

    public AVLNode(T element) {
        this.element = element;
        this.height = 1;
    }

    public void updateHeight() {
        height = Math.max(getHeight(left), getHeight(right)) + 1;
    }

    public int getBalanceFactor() {
        return getHeight(left) - getHeight(right);
    }

    public boolean isBalanced() {
        int balanceFactor = getBalanceFactor();
        return balanceFactor >= -1 && balanceFactor <= 1;
    }

    private int getHeight(AVLNode<T> AVLNode) {
        if (AVLNode == null) {
            return 0;
        }
        return AVLNode.height;
    }
}
