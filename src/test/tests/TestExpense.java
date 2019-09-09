package tests;

import exception.ExpensePurposeHasCommaException;
import model.Expense;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestExpense {
    private Expense expense;

    @BeforeEach
    public void setup(){
        try{
            expense = new Expense("Food", 15);
        }catch(ExpensePurposeHasCommaException purposeCommaException){

        }
    }

    @Test
    public void testConstructor(){
        assertEquals("Food", expense.getExpensePurpose());
        assertEquals(15, expense.getExpenseAmount());
    }

    @Test
    public void testUpdatePurpose(){
        try{
            expense.setExpensePurpose("Book");
        }catch(ExpensePurposeHasCommaException purposeCommaException){

        }
        assertEquals("Book", expense.getExpensePurpose());
    }

    @Test
    public void testUpdateExpenseAmount(){
        expense.setExpenseAmount(40);
        assertEquals(40, expense.getExpenseAmount());
    }

}
