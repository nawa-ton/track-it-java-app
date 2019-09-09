package command;

import command.helper.ConstantVariables;
import model.Budget;
import model.forex.Currency;

public class BudgetDetail {
    private ConstantVariables constantVar = new ConstantVariables();

    public void printBudgetDetail(Budget budget, Currency currency){
        System.out.println("SUMMARY OF '" + budget.getTitle() + "'");
        System.out.println("BUDGET: "+currency.getCurrencySymbol()+ String.format(constantVar.DECIMAL_FORMAT,budget.getBudget()*currency.getRate()));
        if(budget.getExpenseListSize()==0){
            System.out.println("EXPENSE: $0");
        }else{
            System.out.println("EXPENSE: ");
            for (int i = 0; i < budget.getExpenseListSize(); i++) {
                System.out.println("  " + budget.getExpenseItem(i).getExpensePurpose() + ": "+currency.getCurrencySymbol()+ String.format(constantVar.DECIMAL_FORMAT,budget.getExpenseItem(i).getExpenseAmount()*currency.getRate()));
            }
            System.out.println("TOTAL EXPENSE: "+currency.getCurrencySymbol() + String.format(constantVar.DECIMAL_FORMAT,budget.getTotalExpense()*currency.getRate()));
        }
        System.out.println("---------------");
        System.out.println("BALANCE: " +currency.getCurrencySymbol()+ String.format(constantVar.DECIMAL_FORMAT,budget.getBalance()*currency.getRate()));
        System.out.println("===============");
    }

}
