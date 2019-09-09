package command.saveTool;

import model.Budget;
import model.BudgetList;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;

public class SaveRecordToTextFile {
    private PrintWriter output;
    private String fileName;

    public void save(String fileName, BudgetList budgetList) throws FileNotFoundException, UnsupportedEncodingException {
        output = new PrintWriter(fileName,"UTF-8");
        this.fileName = fileName;
        contentFormat(budgetList);
    }

    //EFFECTS: output budget details to a file
    private void contentFormat(BudgetList budgetList){
        Budget currentBudget;
        for (int i = 0; i< budgetList.getBudgetListSize(); i++){
            currentBudget = budgetList.getBudgetItem(i);
            output.println(currentBudget.getTitle()+","+ currentBudget.getBudget());
            for(int j = 0; j< currentBudget.getExpenseListSize(); j++){
                output.print(currentBudget.getExpenseItem(j).getExpensePurpose() + "," + currentBudget.getExpenseItem(j).getExpenseAmount() + ",");
            }
            output.print("\n");
        }
        output.close();
        System.out.println("You record is saved.");
        System.out.println("===============");
    }
}
