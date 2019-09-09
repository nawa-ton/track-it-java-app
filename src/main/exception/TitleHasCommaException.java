package exception;

public class TitleHasCommaException extends Exception {
    public TitleHasCommaException(){
        System.out.println(titleHasCommaMsg());
    }

    public String titleHasCommaMsg(){
        return "Comma is not allowed. Please re-enter budget title";
    }
}
