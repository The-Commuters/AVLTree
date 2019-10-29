package avltree;
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
        int mySize = 1;
        if(right != null){
            mySize += right.size();
        }
        if(left != null){
            mySize += left.size();
        }

        return mySize;
    }

    public int height() {
        return height(0, 0);
    }

    private int height(int leftHeight, int rightHeight) {
        if (left != null) {
            leftHeight = left.height(leftHeight + 1, rightHeight);
        }
        if (right != null) {
            rightHeight = right.height(leftHeight, rightHeight + 1);
        }
        return Math.max(rightHeight, leftHeight);
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

