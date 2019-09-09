package command.saveTool;

import command.helper.ConstantVariables;
import model.Budget;
import model.BudgetList;
import model.Expense;
import model.forex.Currency;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

public class SaveReportToTextFile extends SaveReport {
    private ConstantVariables constantVar = new ConstantVariables();
    //EFFECTS: output all budgets to a file in a user-friendly format
    @Override
    public void contentFormat(BudgetList budgetList, Currency currency) {
        Date date = new Date();
        SimpleDateFormat dateTime = new SimpleDateFormat("MMM dd,yyyy (hh:mm:ss)");
        output.println("As of "+dateTime.format(date)+"\n");
        if(budgetList.isBudgetListEmpty()){
            output.println("No record\n");
        }else{
            Budget currentBudget;
            for (int i = 0; i< budgetList.getBudgetListSize(); i++){
                currentBudget = budgetList.getBudgetItem(i);
                output.println("'"+currentBudget.getTitle()+"'");
                output.println("Budget: "+currency.getCurrencySymbol()+String.format(constantVar.DECIMAL_FORMAT,currentBudget.getBudget()*currency.getRate()));
                if(currentBudget.isExpenseListEmpty()){
                    output.println("Expense: "+currency.getCurrencySymbol()+"0");
                }else{
                    output.println("Expense:");
                    expenseFormat(currentBudget,currency);
                }
                output.println("-------------");
                output.println("Balance: "+currency.getCurrencySymbol()+String.format(constantVar.DECIMAL_FORMAT,currentBudget.getBalance()*currency.getRate()));
                output.println("=============\n");
            }
        }
        output.println("---End of report---");
        output.close();

        System.out.println("You can find the report here");
        System.out.println(new File(fileName).getAbsolutePath());
        System.out.println("===============");
    }

    protected void expenseFormat(Budget budget, Currency currency){
        Expense currentExpense;
        for(int j = 0; j< budget.getExpenseListSize(); j++){
            currentExpense = budget.getExpenseItem(j);
            output.println("  " + currentExpense.getExpensePurpose() + " "+ currency.getCurrencySymbol() + String.format(constantVar.DECIMAL_FORMAT,currentExpense.getExpenseAmount()*currency.getRate()));
        }
        output.println("Total Expense: "+currency.getCurrencySymbol()+String.format(constantVar.DECIMAL_FORMAT,budget.getTotalExpense()*currency.getRate()));
    }
}
