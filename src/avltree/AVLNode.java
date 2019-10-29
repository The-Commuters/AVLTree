package avltree;

import java.util.function.Consumer;
import java.util.function.Function;

/**
 *
 * @author Mads
 * @param <E>
 */
public class AVLNode<E extends Comparable<E>> {
    AVLNode<E> left;
    AVLNode<E> right;
    E content;

    public AVLNode(E content) {
        this.content = content;
    }

    private int childCount(){
        int out = 0;
        if(right != null){
            out ++;
        }
        if(left != null){
            out ++;
        }

        return out;
    }

    public E find(E target){
        //returner null når den ikke finner og objektet om den finner det
        int comparison = content.compareTo(target);
        if(comparison == 0){
            return content;
        }
        if(comparison < 0){ // venstre/mindre
            if(left == null){
                return null;
            }
            else{
                return left.find(target);
            }
        }
        if(comparison > 0){// høgre/større
            if(right == null){
                return null;
            }
            else{
                return right.find(target);
            }
        }
        return null;

    }

    public int size(){
        int size = 1;
        if(right != null){
            size += right.size();
        }
        if(left != null){
            size += left.size();
        }
        return size;
    }

    public int height() {
        int leftHeight = 0;
        int rightHeight = 0;
        if(left != null){
            leftHeight = left.height();
            leftHeight++;
        }
        if (right != null){
            rightHeight = right.height();
            rightHeight++;
        }
        return Math.max(leftHeight, rightHeight);
    }

    public void addContent(E newContent){
        int comparison = content.compareTo(newContent);

        if (comparison < 0){//hvis mindre, gå venstre
            if(left == null){
                left = new AVLNode(newContent);
            }
            else{
                left.addContent(newContent);
            }

        }
        else if(comparison > 0){//hvis større, gå høyre
            if(right == null){
                right = new AVLNode(newContent);
            }
            else{
                right.addContent(newContent);
            }

        }
        else if(comparison == 0){

        }
        else{
            //send error
            System.out.println("ERROR");
        }
    }
}

