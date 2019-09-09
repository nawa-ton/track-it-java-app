package model;

import exception.ExpensePurposeHasCommaException;
import observer.Subject;

public class Expense extends Subject{
    private Budget budget;
    private String purpose;
    private int expense;


    //REQUIRES: valid string and int inputs
    //MODIFIES: this
    //EFFECTS: construct the Expense, initialize sumOfExpense, purpose and expense to zero.
    public Expense(String purpose, int expenseAmt) throws ExpensePurposeHasCommaException {
        setExpensePurpose(purpose);
        setExpenseAmount(expenseAmt);
    }

    public void addBudget(Budget budget){
        this.budget = budget;
        budget.addExpense(this);
        addObserver(budget);
    }

    //REQUIRES: valid number input
    //MODIFIES: this
    //EFFECTS: set expense value
    public void setExpenseAmount(int expenseAmt){
        this.expense = expenseAmt;
        notifyObserver();
    }

    //REQUIRES: valid string input
    //MODIFIES: this
    //EFFECTS: set expense purpose
    public void setExpensePurpose(String purpose) throws ExpensePurposeHasCommaException {
        if(purpose.contains(",")){
            throw new ExpensePurposeHasCommaException();
        }
        this.purpose = purpose;
    }

    //EFFECTS: return expense amount
    public int getExpenseAmount(){
        return this.expense;
    }

    //EFFECTS: return expense purpose
    public String getExpensePurpose(){
        return this.purpose;
    }


}
