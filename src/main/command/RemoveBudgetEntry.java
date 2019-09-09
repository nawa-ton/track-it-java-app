package command;

import command.helper.ConstantVariables;
import command.helper.HelperMethods;
import command.interfaces.Command;
import exception.EmptyBudgetListException;
import exception.ExitProgramException;
import exception.MainMenuException;
import model.BudgetList;

import java.util.Scanner;

public class RemoveBudgetEntry implements Command {
    private HelperMethods helperMethods = new HelperMethods();
    private ConstantVariables constantVar = new ConstantVariables();

    @Override
    //MODIFIES: ExpenseTrackingApp budgetList
    //EFFECTS: confirm with users that they want to remove the selected tracking, and remove it from budgetList, if users confirm.
    public int execute(BudgetList budgetList, int index) throws EmptyBudgetListException, ExitProgramException, MainMenuException {
        budgetList.checkIfBudgetListEmpty();

        Scanner scanner = new Scanner(System.in);
        String commandInput;
        String removeItem;

        System.out.println("Are you sure you want to remove?");
        System.out.println("[y] Yes, I want to remove something.");
        System.out.println("["+constantVar.COMMAND_KEY_FOR_MENU+"] No. Back to menu | ["+constantVar.COMMAND_KEY_FOR_EXIT+"] Exit");
        System.out.println("===============");
        while (true) {
            commandInput = scanner.nextLine();
            if (commandInput.equals(constantVar.COMMAND_KEY_FOR_MENU)) {
                throw new MainMenuException();
            } else if (commandInput.equals(constantVar.COMMAND_KEY_FOR_EXIT)) {
                throw new ExitProgramException();
            } else if (commandInput.equals("y")) {
                System.out.println("Which one do you want to remove?");
                helperMethods.printBudgetList(budgetList);
                index = helperMethods.checkIndexOutOfBound(budgetList.getBudgetListSize());
                //removeItem = budgetList.getBudgetTitle(index);
                removeItem = budgetList.getBudgetItem(index).getTitle();
                budgetList.removeBudget(index);
                System.out.println("'" + removeItem + "' has been removed.");
                System.out.println("===============");
                return index;
            } else {
                constantVar.printSelectionNotAvailableMessage();
            }
        }
    }

    @Override
    public String commandDescription(){
        return "Remove budget";
    }
}
