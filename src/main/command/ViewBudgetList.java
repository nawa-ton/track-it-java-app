package command;

import command.helper.HelperMethods;
import command.interfaces.Command;
import exception.EmptyBudgetListException;
import exception.ExitProgramException;
import exception.MainMenuException;
import model.BudgetList;

public class ViewBudgetList implements Command {

    private HelperMethods helperMethods = new HelperMethods();

    //MODIFIES: ExpenseTrackingApp index
    //EFFECTS: display all active expense tracking entries. allow users to select the item they want. Store users' valid selection as index
    public int execute(BudgetList budgetList, int index) throws EmptyBudgetListException, ExitProgramException, MainMenuException {
        budgetList.checkIfBudgetListEmpty();
        helperMethods.printBudgetList(budgetList);
        return helperMethods.checkIndexOutOfBound(budgetList.getBudgetListSize());
    }

    public String commandDescription() {
        return "View budget list";
    }





}
