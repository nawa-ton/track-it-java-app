package tests;

import command.LoadTextFile;
import exception.EmptyBudgetListException;
import exception.ExpensePurposeHasCommaException;
import exception.TitleHasCommaException;
import model.Budget;
import model.BudgetList;
import model.Expense;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.fail;

public class TestExceptions {

    @Test
    public void TestExpectTitleHasCommaException(){
        try{
            Budget budget = new Budget("My,Budget");
            fail("FAIL: No exception caught");
        }catch (TitleHasCommaException titleCommaException){
            System.out.println("PASS: TitleHasCommaException is caught");
        }
    }

    @Test
    public void TestNotExpectTitleHasCommaException(){
        try{
            Budget budget = new Budget("My Budget");
            System.out.println("PASS");
        }catch (TitleHasCommaException titleCommaException){
            fail("FAIL: TitleHasCommaException shouldn't be caught.");
        }
    }

    @Test
    public void TestExpectExpensePurposeHasCommaException(){
        try{
            Expense expense = new Expense("Food,drinks",50);
            fail("FAIL: No exception caught");
        }catch (ExpensePurposeHasCommaException expensePurposeCommaException){
            System.out.println("PASS: ExpensePurposeHasCommaException is caught");
        }
    }

    @Test
    public void TestNotExpectExpensePurposeHasCommaException(){
        try{
            Expense expense = new Expense("Food & drinks",50);
            System.out.println("PASS");
        }catch (ExpensePurposeHasCommaException expensePurposeCommaException){
            fail("FAIL: ExpensePurposeHasCommaException shouldn't be caught.");
        }
    }

    @Test
    public void TestExpectEmptyBudgetListException(){
        try{
            BudgetList budgetList = new BudgetList();
            budgetList.checkIfBudgetListEmpty();
            fail("FAIL: No exception caught");
        }
        catch(EmptyBudgetListException emptyBudgetListException){
            System.out.println("PASS: EmptyBudgetListException is caught.");
        }
    }

    @Test
    public void TestNotExpectEmptyBudgetListException(){
        try{
            BudgetList budgetList = new BudgetList();
            Budget budget = new Budget("My budget");
            budgetList.addBudgetItem(budget);
            budgetList.checkIfBudgetListEmpty();
            System.out.println("PASS");
        }
        catch(EmptyBudgetListException emptyBudgetListException){
            fail("FAIL: EmptyBudgetListException shouldn't be caught.");
        }
        catch (TitleHasCommaException titleCommaException){
            fail("FAIL: TitleHasCommaException shouldn't be caught.");
        }
    }

}
