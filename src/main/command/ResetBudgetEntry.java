package command;

import command.helper.ConstantVariables;
import command.helper.HelperMethods;
import command.interfaces.Command;
import exception.EmptyBudgetListException;
import exception.ExitProgramException;
import exception.MainMenuException;
import model.BudgetList;

import java.util.Scanner;

public class ResetBudgetEntry implements Command {
    private HelperMethods helperMethods = new HelperMethods();
    private ConstantVariables constantVar = new ConstantVariables();

    @Override
    //MODIFIES: Budget budget, totalExpense, balance, listExpenseAmount, listExpensePurpose
    //EFFECTS: confirm with users that they want to reset the selected tracking, and reset it, if users confirm.
    public int execute(BudgetList budgetList, int index) throws EmptyBudgetListException, ExitProgramException, MainMenuException {
        budgetList.checkIfBudgetListEmpty();

        Scanner scanner = new Scanner(System.in);
        String commandInput;

        System.out.println("Are you sure you want to reset?");
        System.out.println("[y] Yes, I want to reset something.");
        System.out.println("["+constantVar.COMMAND_KEY_FOR_MENU+"] No. Back to menu | ["+constantVar.COMMAND_KEY_FOR_EXIT+"] Exit");
        System.out.println("===============");
        while (true) {
            commandInput = scanner.nextLine();
            if (commandInput.equals(constantVar.COMMAND_KEY_FOR_MENU)) {
                throw new MainMenuException();
            } else if (commandInput.equals(constantVar.COMMAND_KEY_FOR_EXIT)) {
                throw new ExitProgramException();
            } else if (commandInput.equals("y")) {
                System.out.println("Which one do you want to reset?");
                helperMethods.printBudgetList(budgetList);
                index = helperMethods.checkIndexOutOfBound(budgetList.getBudgetListSize());
                budgetList.getBudgetItem(index).clearBudget();
                System.out.println("'" + budgetList.getBudgetItem(index).getTitle() + "' is now reset.");
                System.out.println("===============");
                return index;
            }else {
                constantVar.printSelectionNotAvailableMessage();
            }

        }
    }

    @Override
    public String commandDescription() {
        return "Reset budget";
    }
}
