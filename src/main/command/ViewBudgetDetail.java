package command;

import command.helper.HelperMethods;
import command.interfaces.Command;
import exception.EmptyBudgetListException;
import exception.ExitProgramException;
import exception.MainMenuException;
import model.Budget;
import model.BudgetList;
import model.forex.Currency;

import java.io.IOException;

public class ViewBudgetDetail implements Command {
    private HelperMethods helperMethods;

    public ViewBudgetDetail(){
        helperMethods = new HelperMethods();
    }

    @Override
    //EFFECTS: display current budget, list of expense, total expense and balance the selected expense entry
    public int execute(BudgetList budgetList, int index) throws EmptyBudgetListException, ExitProgramException, MainMenuException {
        budgetList.checkIfBudgetListEmpty();

        Budget activeBudget = budgetList.getBudgetItem(index);
        BudgetDetail viewBudgetCommand = new BudgetDetail();

        if (activeBudget.getBudget() == 0 && activeBudget.getTotalExpense() == 0) {
            helperMethods.printBudgetTitle(activeBudget);
            System.out.println("Your budget and expense are $0.");
            System.out.println("===============");
        } else {
            helperMethods.printCurrencyList();
            Currency selectedCurrency = helperMethods.getCurrencyInput();
            viewBudgetCommand.printBudgetDetail(activeBudget,selectedCurrency);
        }
        return index;
    }

    @Override
    public String commandDescription(){
        return "View budget detail";
    }

}
