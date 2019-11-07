package AVLVisualTree;

import javafx.scene.control.TextField;

import java.util.regex.Pattern;

public class NumberTextField extends TextField {

    /*
    TODO
     Give notice to the user when non numerical values are entered.
    */

    /**
    * Creates a pattern for the validate method to use, so that it will be reused
    * and not compiled every time someone writes something in to the box.
    */
    private static Pattern integerPattern = Pattern.compile("\\d*");


    /**
     * Replaces the text the user writes in if it is not a number
     * Making the user unable to type in any other character than a number
     * @param start
     * @param end
     * @param text
     */
    @Override
    public void replaceText(int start, int end, String text)
    {
        if (validate(text))
        {
            super.replaceText(start, end, text);
        }
    }

    /**
     * Replaces the selection to match the selected
     * filter defined in integerPattern
     * @param text
     */
    @Override
    public void replaceSelection(String text)
    {
        if (validate(text))
        {
            super.replaceSelection(text);
        }
    }

    /**
     * Checks the text, the user wrote it to the text field
     * @param text
     * @return the true if the text the user wrote in was a number
     */
    private boolean validate(String text)
    {
        /*
        This will check that if the text has a length greater than 10,
        it wont allow it thru and the text == ""
        is there to allow for removing/backspacing numbers in the field
         */
        if (this.getText().length() < 10 || text == "")
            return integerPattern.matcher(text).matches();
        return false;
    }
}
