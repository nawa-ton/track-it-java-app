package tests;

import exception.ExpensePurposeHasCommaException;
import exception.TitleHasCommaException;
import model.Budget;
import model.Expense;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

//Unit test for
public class TestBudget {
    private Budget budget;

    @BeforeEach
    public void setup(){
        try{
            budget = new Budget("Expense title");
        }catch(TitleHasCommaException titleCommaException) {

        }
    }

    //Test if an budget entry is properly constructed and initialized
    @Test
    public void testConstructor(){
        assertEquals("Expense title", budget.getTitle());
        assertEquals(0, budget.getBudget());
        assertEquals(0, budget.getTotalExpense());
        assertEquals(0, budget.getBalance());
        assertEquals(0, budget.getExpenseListSize());
    }

    //Test if the budget entry title is set and returned properly.
    @Test
    public void testSetTitle(){
        try{
            budget.setTitle("New budget title");
        }catch(TitleHasCommaException titleCommaException) {
            System.out.println("Title contains non-permitted comma.");
        }
        assertEquals("New budget title", budget.getTitle());
    }

    //Test if the budget is set properly
    @Test
    public void testSetBudget(){
        budget.setBudget(300);
        assertEquals(300, budget.getBudget());
    }

    //Test if the budget is updated properly
    @Test
    public void testUpdateBudget(){
        budget.setBudget(300);
        budget.setBudget(100);
        assertEquals(100, budget.getBudget());
    }

    //Test if the total expense is correct and return properly when there's no expense.
    @Test
    public void testGetTotalExpenseNoExpense(){
        assertEquals(0, budget.getTotalExpense());
    }

    //Test if one expense entry is added to budget properly
    @Test
    public void testAddOneExpense(){
        try {
            Expense expense = new Expense("Food", 20);
            budget.addExpense(expense);
        }catch(ExpensePurposeHasCommaException purposeCommaException){

        }
        assertEquals(1, budget.getExpenseListSize());
    }

    //Test if multiple expense entries are added to budget properly
    @Test
    public void testAddMultipleExpenses(){
        setExpenseInfo();
        assertEquals(3, budget.getExpenseListSize());
        assertEquals(70, budget.getTotalExpense());
    }

    //Test if the balance is correct and return properly when there's no budget and no expense.
    @Test
    public void testGetBalanceNoBudgetNoExpense(){
        assertEquals(0, budget.getBalance());
    }

    //Test if the balance is correct and return properly when there's no expense.
    @Test
    public void testGetBalanceNoExpense(){
        budget.setBudget(200);
        assertEquals(200, budget.getBalance());
    }

    //Test if the balance is correct and return properly when there's no budget.
    @Test
    public void testGetBalanceNoBudget(){
        setExpenseInfo();
        assertEquals(-70, budget.getBalance());
    }

    //Test if the balance is correct and return properly when there's budget and expenses.
    @Test
    public void testGetBalance(){
        budget.setBudget(100);
        setExpenseInfo();
        assertEquals(30, budget.getBalance());
    }

    //Test that the entry is clear properly
    @Test
    public void testClearEntry(){
        budget.setBudget(100);
        setExpenseInfo();
        budget.clearBudget();
        assertEquals(0, budget.getBudget());
        assertEquals(0, budget.getTotalExpense());
        assertEquals(0, budget.getBalance());
        assertEquals(0, budget.getExpenseListSize());
    }

    private void setExpenseInfo(){
        try {
            Expense expense1 = new Expense("Food", 20);
            budget.addExpense(expense1);
            Expense expense2 = new Expense("Books", 40);
            budget.addExpense(expense2);
            Expense expense3 = new Expense("Snacks", 10);
            budget.addExpense(expense3);
        }catch(ExpensePurposeHasCommaException purposeCommaException){

        }
    }

}
