package ui;

import java.io.IOException;

public class Main {

    public static void main(String[] args) {
        try{
            ExpenseTrackingApp expenseTrackingApp = new ExpenseTrackingApp();
            expenseTrackingApp.runApp();
        } catch(IOException ioException){
            System.out.println("Oops, sorry. Fail to access the file.");
            ioException.printStackTrace();
        }
    }

}