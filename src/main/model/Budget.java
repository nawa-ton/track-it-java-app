package model;

import command.helper.HelperMethods;
import exception.TitleHasCommaException;
import observer.Observer;

import java.util.ArrayList;
import java.util.List;

public class Budget implements Observer {
    private String title;
    private int budget;
    private int totalExpense;
    private List<Expense> expenseList;
    private String expensePercentageOfBudget;

    //REQUIRES: valid string input which is the expense entry title
    //MODIFIES: this title, budget, totalExpense, balance
    //EFFECTS: construct the Budget, initialize its budget, totalExpense and balance to zero, and set input as its title
    public Budget(String titleInput) throws TitleHasCommaException {
        expenseList = new ArrayList<>();
        setTitle(titleInput);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Budget budget = (Budget) o;

        return title.equals(budget.title);
    }

    @Override
    public int hashCode() {
        return title.hashCode();
    }


    //REQUIRES: valid Expense object
    //MODIFIES: this
    //EFFECTS: add Expense object to expenseList, calculate totalExpense and balance
public void addExpense(Expense expense) {
    if(!expenseList.contains(expense)){
        expenseList.add(expense);
        expense.addBudget(this);
        this.totalExpense = totalExpense + expense.getExpenseAmount();
    }
}

    public void removeExpense(Expense expense) {
        if(expenseList.contains(expense)){
            expenseList.remove(expense);
            this.totalExpense = totalExpense - expense.getExpenseAmount();
        }
    }

    //REQUIRES: valid string input
    //MODIFIES: this title
    //EFFECTS: set user's input as title of the expense entry
    public void setTitle(String titleInput) throws TitleHasCommaException {
        if(titleInput.contains(",")){
            throw new TitleHasCommaException();
        }
        this.title = titleInput;
    }

    //REQUIRES: valid number input
    //MODIFIES: this budget
    //EFFECTS: set input as budget amount
    public void setBudget(int budgetInput){
        this.budget = budgetInput;
    }

    //EFFECTS: return current title
    public String getTitle(){
      return this.title;
    }

    //EFFECTS: return current budget
    public int getBudget(){
        return this.budget;
    }

    //EFFECTS: calculate current total expense
    public int getTotalExpense(){
        return this.totalExpense;
    }


    public String getExpensePercentOfBudget(){
        return this.expensePercentageOfBudget;
    }

    //EFFECTS: return current balance
    public int getBalance(){
        return budget - totalExpense;
    }

    //EFFECTS: Return size of expenseList
    public int getExpenseListSize(){
        return expenseList.size();
    }

    public Expense getExpenseItem(int index){
        return expenseList.get(index);
    }

    private void calculateTotalExpense(){
        int total = 0;
        for(Expense expense : expenseList){
            total += expense.getExpenseAmount();
        }
        this.totalExpense = total;
    }

    public void calculateExpensePercentageOfBudget(){
        HelperMethods helperMethods = new HelperMethods();
        this.expensePercentageOfBudget = helperMethods.calculatePercentageReturnString(this.totalExpense,this.budget);
    }

    //MODIFIES: this budget, totalExpense, balance, listExpenseAmount, listExpensePurpose
    //EFFECTS: reset budget, totalExpense, balance to zero. Clear listExpenseAmount and listExpensePurpose
    public void clearBudget(){
        this.budget = 0;
        this.totalExpense = 0;
        expenseList.clear();
    }

    public boolean isExpenseListEmpty(){
        return expenseList.isEmpty();
    }

    //Observe
    @Override
    public void update() {
        calculateTotalExpense();
        calculateExpensePercentageOfBudget();
        printExpensePercentageOfBudget();
    }

    private void printExpensePercentageOfBudget(){
        if(this.budget!=0){
            System.out.println("Total expense is "+this.expensePercentageOfBudget+"% of the budget");
            System.out.println("===============");
        }
    }

}
