package command.saveTool;

import command.helper.ConstantVariables;
import command.helper.HelperMethods;
import model.Budget;
import model.Expense;
import model.forex.Currency;

public class SaveReportToTextFilePercent extends SaveReportToTextFile {
    private ConstantVariables constantVar = new ConstantVariables();
    @Override
    public void expenseFormat(Budget budget, Currency currency){
        Expense currentExpense;
        HelperMethods helperMethods = new HelperMethods();
        for(int j = 0; j< budget.getExpenseListSize(); j++){
            currentExpense = budget.getExpenseItem(j);
            output.println("  " + currentExpense.getExpensePurpose() + " "+currency.getCurrencySymbol() + String.format(constantVar.DECIMAL_FORMAT,currentExpense.getExpenseAmount()*currency.getRate())+" | "+helperMethods.calculatePercentageReturnString(currentExpense.getExpenseAmount(),budget.getTotalExpense())+"% of total expense");
        }
        if(budget.getBudget()!=0){
            budget.calculateExpensePercentageOfBudget();
            output.println("Total Expense: "+currency.getCurrencySymbol()+String.format(constantVar.DECIMAL_FORMAT,budget.getTotalExpense()*currency.getRate()) +" | "+budget.getExpensePercentOfBudget()+"% of budget");
        }
    }
}
