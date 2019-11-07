package AVLTree;

public class AVLTree<T extends Comparable<T>> {
    public AVLNode<T> root;

    public AVLTree() {}

    public int getHeight() {
        return root.height;
    }

    public T search(T element) {
        if (root != null) {
            return search(root, element);
        }
        else {
            return null;
        }
    }

    private T search(AVLNode<T> AVLNode, T element) {
        if (element.compareTo(AVLNode.element) == 0) {
            return AVLNode.element;
        }

        if ((element.compareTo(AVLNode.element) < 0) && (AVLNode.left != null)) {
            return search(AVLNode.left, element);
        }

        if ((element.compareTo(AVLNode.element) > 0) && (AVLNode.right != null)) {
            return search(AVLNode.right, element);
        }

        return null;
    }

    public void insert(T element) {
        if (root != null) {
            insert(root, element);
        }
        else {
            root = new AVLNode<T>(element);
        }
    }

    private void insert(AVLNode<T> AVLNode, T element) {
        if (element.compareTo(AVLNode.element) < 0) {
            if (AVLNode.left == null) {
                AVLNode.left = new AVLNode<T>(element);
            }
            else {
                insert(AVLNode.left, element);
            }

            AVLNode.updateHeight();

            if (!AVLNode.left.isBalanced()) {
                AVLNode.left = balance(AVLNode.left, element);
            }
        }

        if (element.compareTo(AVLNode.element) > 0) {
            if (AVLNode.right == null) {
                AVLNode.right = new AVLNode<T>(element);
            }
            else {
                insert(AVLNode.right, element);
            }

            AVLNode.updateHeight();

            if (!AVLNode.right.isBalanced()) {
                AVLNode.right = balance(AVLNode.right, element);
            }
        }

        if (element.compareTo(AVLNode.element) == 0) {
            System.out.println("NO DUPLICATES");
            return;
        }

        if (AVLNode.equals(root)) {
            if (!root.isBalanced()) {
                root = balance(AVLNode, element);
            }
        }
    }

    public T delete(T element) {
        if (root != null) {
            return delete(root, element);
        }
        else {
            // TODO: empty tree handling
            System.out.println("ERROR");
            return null;
        }
    }

    private T delete(AVLNode<T> AVLNode, T element) {
        if (element.compareTo(AVLNode.element) == 0) {

        }

        if ((element.compareTo(AVLNode.element) < 0) && (AVLNode.left != null)) {
            return delete(AVLNode.left, element);
        }

        if ((element.compareTo(AVLNode.element) > 0) && (AVLNode.right != null)) {
            return delete(AVLNode.right, element);
        }

        return null;
    }

    private AVLNode<T> balance(AVLNode<T> AVLNode, T element) {
        int balance = AVLNode.getBalanceFactor();

        if ((balance > 1) && (element.compareTo(AVLNode.left.element) < 0)) {
            return rotateRight(AVLNode);
        }

        if ((balance < -1) && (element.compareTo(AVLNode.right.element) > 0)) {
            return rotateLeft(AVLNode);
        }

        if ((balance > 1) && (element.compareTo(AVLNode.left.element) > 0)) {
            AVLNode.left = rotateLeft(AVLNode.left);
            return rotateRight(AVLNode);
        }

        if ((balance < -1) && (element.compareTo(AVLNode.right.element) < 0)) {
            AVLNode.right = rotateRight(AVLNode.right);
            return rotateLeft(AVLNode);
        }

        else {
            return AVLNode;
        }
    }

    private AVLNode rotateRight(AVLNode<T> AVLNode) {
        AVLNode<T> newRoot = AVLNode.left;
        AVLNode<T> subtree = newRoot.right;

        newRoot.right = AVLNode;
        AVLNode.left = subtree;

        AVLNode.updateHeight();
        newRoot.updateHeight();

        return newRoot;
    }

    private AVLNode rotateLeft(AVLNode<T> AVLNode) {
        AVLNode<T> newRoot = AVLNode.right;
        AVLNode<T> subtree = newRoot.left;

        newRoot.left = AVLNode;
        AVLNode.right = subtree;

        AVLNode.updateHeight();
        newRoot.updateHeight();

        return newRoot;
    }
}
