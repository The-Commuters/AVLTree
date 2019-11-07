package AVLVisualTree;

import AVLTree.AVLTree;
import AVLTree.AVLNode;
import javafx.beans.binding.DoubleBinding;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Line;

public class AVLVisualTree<T extends Comparable<T>> extends Pane {
    private AVLTree<T> avlTree = new AVLTree<T>();

    public AVLVisualTree() {}

    public void insert(T element) {
        avlTree.insert(element);
        drawTree();
    }

    public T search(T element) {
        return avlTree.search(element);
    }

    public T delete(T element) {
        T returnElement = avlTree.delete(element);
        drawTree();
        return returnElement;

    }

    public void drawTree() {
        this.getChildren().clear();
        if (avlTree.root != null) {
            drawTree(avlTree.root, this.widthProperty().divide(2), 1);
        }
    }

    public void drawTree(AVLNode<T> node, DoubleBinding parentWidth, int row) {
        AVLVisualNode<T> visualNode = new AVLVisualNode<T>(node.element);
        DoubleBinding x = parentWidth.subtract(visualNode.getRadius());
        visualNode.layoutXProperty().bind(x);

        DoubleBinding step = this.heightProperty().divide(avlTree.root.height + 1);
        DoubleBinding y = step.multiply(row).subtract(visualNode.getRadius());
        visualNode.layoutYProperty().bind(y);



        if (node.left != null) {
            DoubleBinding newX = parentWidth.subtract(parentWidth.divide(2));
            DoubleBinding newY = step.multiply(row + 1);

            drawLine(x, y, newY, newX, visualNode);

            drawTree(node.left, newX, row + 1);
        }

        if (node.right != null) {
            DoubleBinding newX = parentWidth.add(parentWidth.divide(2));
            DoubleBinding newY = step.multiply(row + 1);

            drawLine(x, y, newY, newX, visualNode);

            drawTree(node.right, parentWidth.add(parentWidth.divide(2)), row + 1);
        }

        this.getChildren().add(visualNode);
    }

    private void drawLine(DoubleBinding x, DoubleBinding y, DoubleBinding newY, DoubleBinding newX, AVLVisualNode<T> visualNode) {
        Line line = new Line();
        line.startXProperty().bind(x.add(visualNode.getRadius()));
        line.startYProperty().bind(y.add(visualNode.getRadius()));
        line.endXProperty().bind(newX);
        line.endYProperty().bind(newY);
        this.getChildren().add(line);
    }

}
