package exception;

public class ExpensePurposeHasCommaException extends Exception {
    public ExpensePurposeHasCommaException(){
        System.out.println(purposeCommaMsg());
    }

    public String purposeCommaMsg(){
        return "Comma is not allowed. Please re-enter expense purpose";
    }
}
