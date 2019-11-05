package AVLVisualTree;

import javafx.beans.property.DoubleProperty;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.text.Text;
import javafx.scene.text.TextBoundsType;

public class AVLVisualNode<T> extends StackPane {
    private Circle circle;
    private Text text;

    private static final double RADIUS = 30;

    public AVLVisualNode(T input) {
        this.circle = new Circle(RADIUS);
        circle.setFill(Color.WHITE);
        circle.setStroke(Color.BLACK);

        this.text = new Text(input.toString());

        this.getChildren().addAll(circle, text);
    }

    public void update() {
        this.getChildren().clear();
        this.getChildren().addAll(circle, text);
    }

    public void setInput(T input) {
        this.text = new Text(input.toString());
    }

    public double getRadius() {
        return circle.getRadius();
    }
}
