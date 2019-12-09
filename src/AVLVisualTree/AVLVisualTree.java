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


    public void clear(){
        avlTree = new AVLTree<T>();
        this.getChildren().clear();
    }

    public void drawTree() {
        this.getChildren().clear();
        if (avlTree.root != null) {
            drawTree(avlTree.root, this.widthProperty().divide(2), this.widthProperty().divide(2), 1);
        }
    }

    public void drawTree(AVLNode<T> node, DoubleBinding parentWidth, DoubleBinding passedX, int row) {
        AVLVisualNode<T> visualNode = new AVLVisualNode<T>(node.element);
        DoubleBinding x = passedX.subtract(visualNode.getRadius());
        visualNode.layoutXProperty().bind(x);

        DoubleBinding step = this.heightProperty().divide(avlTree.root.height + 1);
        DoubleBinding y = step.multiply(row).subtract(visualNode.getRadius());
        visualNode.layoutYProperty().bind(y);



        if (node.left != null) {
            DoubleBinding newParentWidth = parentWidth.divide(2);
            DoubleBinding newX = passedX.subtract(newParentWidth);
            DoubleBinding newY = step.multiply(row + 1);

            drawLine(x, y, newY, newX, visualNode);

            drawTree(node.left, newParentWidth, newX, row + 1);
        }

        if (node.right != null) {
            DoubleBinding newParentWidth = parentWidth.divide(2);
            DoubleBinding newX = passedX.add(newParentWidth);
            DoubleBinding newY = step.multiply(row + 1);

            drawLine(x, y, newY, newX, visualNode);

            drawTree(node.right, newParentWidth, newX, row + 1);

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
