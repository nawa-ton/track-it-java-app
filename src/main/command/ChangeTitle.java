package command;

import command.helper.ConstantVariables;
import command.interfaces.Command;
import exception.EmptyBudgetListException;
import exception.ExitProgramException;
import exception.MainMenuException;
import exception.TitleHasCommaException;
import model.Budget;
import model.BudgetList;

import java.util.Scanner;

public class ChangeTitle implements Command{

    private ConstantVariables constantVar = new ConstantVariables();

    //MODIFIES: Budget title
    //EFFECTS: update title of the selected expense entry
    public int execute(BudgetList budgetList, int index) throws EmptyBudgetListException, MainMenuException, ExitProgramException {
        budgetList.checkIfBudgetListEmpty();

        Scanner scanner = new Scanner(System.in);
        String commandInput;
        Budget selectedBudget = budgetList.getBudgetItem(index);

        System.out.println("Enter the new title");
        System.out.println("Note: Comma is not allowed");

        while (true){
            commandInput = scanner.nextLine();
            if(commandInput.equals(constantVar.COMMAND_KEY_FOR_MENU)){
                throw new MainMenuException();
            }else if(commandInput.equals(constantVar.COMMAND_KEY_FOR_EXIT)){
                throw new ExitProgramException();
            }else {
                try {
                    //budgetList.setBudgetTitle(index, commandInput);
                    selectedBudget.setTitle(commandInput);
                    System.out.println("New title: " + commandInput);
                    System.out.println("===============");
                    return index;

                } catch (TitleHasCommaException titleCommaException) {
                    //print message from TitleHasCommaException
                }
            }
        }
    }

    @Override
    public String commandDescription() {
        return "Change budget title";
    }
}
