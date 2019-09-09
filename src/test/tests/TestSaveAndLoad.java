package tests;

import command.LoadTextFile;
import command.saveTool.SaveRecordToTextFile;
import command.saveTool.SaveReportToTextFile;
import exception.ExpensePurposeHasCommaException;
import exception.TitleHasCommaException;
import model.Budget;
import model.BudgetList;
import model.Expense;
import model.forex.CAD;
import model.forex.Currency;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class TestSaveAndLoad {

    private BudgetList budgetList;
    private SaveRecordToTextFile saveRecordToTxt;
    private SaveReportToTextFile saveReportToTxt;
    private LoadTextFile loadTxt;
    private int index;

    @BeforeEach
    public void setup(){
        budgetList = new BudgetList();
        loadTxt = new LoadTextFile();
    }

    @Test
    public void testLoadTxtEmpty() throws IOException, TitleHasCommaException, ExpensePurposeHasCommaException {
        loadTxt.load("testInEmpty.txt",budgetList);
        assertTrue(budgetList.isBudgetListEmpty());
    }

    @Test
    public void testLoadTxt() throws IOException, TitleHasCommaException, ExpensePurposeHasCommaException {
        loadTxt.load("testIn.txt",budgetList);
        assertEquals("MyBudget",getBudgetItem(0).getTitle());
        assertEquals(100,getBudgetItem(0).getBudget());
        assertEquals("books",getExpenseItem(0,0).getExpensePurpose());
        assertEquals(50,getExpenseItem(0,0).getExpenseAmount());
        assertEquals("dinner",getExpenseItem(0,1).getExpensePurpose());
        assertEquals(40,getExpenseItem(0,1).getExpenseAmount());
        assertEquals("YourBudget",getBudgetItem(1).getTitle());
        assertEquals(150,getBudgetItem(1).getBudget());
        assertEquals("shoes",getExpenseItem(1,0).getExpensePurpose());
        assertEquals(50,getExpenseItem(1,0).getExpenseAmount());
        assertEquals("bags",getExpenseItem(1,1).getExpensePurpose());
        assertEquals(30,getExpenseItem(1,1).getExpenseAmount());
    }


    @Test
    public void testSaveRecordToTxtEmpty() throws IOException, TitleHasCommaException, ExpensePurposeHasCommaException {
        saveRecordToTxt = new SaveRecordToTextFile();
        loadTxt.load("testInEmpty.txt", budgetList);
        saveRecordToTxt.save("testOutEmpty.txt", budgetList);
        List<String> lines = Files.readAllLines(Paths.get("testOutEmpty.txt"));
        assertTrue(lines.isEmpty());
    }

    @Test
    public void testSaveRecordToTxt() throws IOException, TitleHasCommaException, ExpensePurposeHasCommaException {
        saveRecordToTxt = new SaveRecordToTextFile();
        loadTxt.load("testIn.txt", budgetList);
        saveRecordToTxt.save("testOut.txt", budgetList);
        List<String> lines = Files.readAllLines(Paths.get("testOut.txt"));
        assertEquals("MyBudget,100", lines.get(0));
        assertEquals("books,50,dinner,40,", lines.get(1));
        assertEquals("YourBudget,150", lines.get(2));
        assertEquals("shoes,50,bags,30,", lines.get(3));
    }

    @Test
    public void testSaveReportToTxtEmpty() throws IOException, TitleHasCommaException, ExpensePurposeHasCommaException {
        saveReportToTxt = new SaveReportToTextFile();
        Currency currency = new CAD();
        loadTxt.load("testInEmpty.txt", budgetList);
        saveReportToTxt.save("testReportEmpty.txt",budgetList,currency);
        List<String> lines = Files.readAllLines(Paths.get("testReportEmpty.txt"));
        assertEquals("", lines.get(1));
        assertEquals("No record", lines.get(2));
        assertEquals("", lines.get(3));
        assertEquals("---End of report---", lines.get(4));
    }

    @Test
    public void testSaveReportToTxt() throws IOException, TitleHasCommaException, ExpensePurposeHasCommaException {
        saveReportToTxt = new SaveReportToTextFile();
        Currency currency = new CAD();
        loadTxt.load("testIn.txt", budgetList);
        saveReportToTxt.save("testReport.txt",budgetList,currency);
        List<String> lines = Files.readAllLines(Paths.get("testReport.txt"));
        assertEquals("", lines.get(1));
        assertEquals("'MyBudget'", lines.get(2));
        assertEquals("Budget: $100.00", lines.get(3));
        assertEquals("Expense:", lines.get(4));
        assertEquals("  books $50.00", lines.get(5));
        assertEquals("  dinner $40.00", lines.get(6));
        assertEquals("Total Expense: $90.00", lines.get(7));
        assertEquals("-------------", lines.get(8));
        assertEquals("Balance: $10.00", lines.get(9));
        assertEquals("=============", lines.get(10));
        assertEquals("", lines.get(11));
        assertEquals("'YourBudget'", lines.get(12));
        assertEquals("Budget: $150.00", lines.get(13));
        assertEquals("Expense:", lines.get(14));
        assertEquals("  shoes $50.00", lines.get(15));
        assertEquals("  bags $30.00", lines.get(16));
        assertEquals("Total Expense: $80.00", lines.get(17));
        assertEquals("-------------", lines.get(18));
        assertEquals("Balance: $70.00", lines.get(19));
        assertEquals("=============", lines.get(20));
        assertEquals("", lines.get(21));
        assertEquals("---End of report---", lines.get(22));
    }


    private Budget getBudgetItem(int index){
        return budgetList.getBudgetItem(index);
    }

    private Expense getExpenseItem(int budgetIndex, int expenseIndex){
        return budgetList.getBudgetItem(budgetIndex).getExpenseItem(expenseIndex);
    }
}
