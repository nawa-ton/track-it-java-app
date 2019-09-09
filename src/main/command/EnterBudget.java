package command;

import command.helper.ConstantVariables;
import command.interfaces.Command;
import exception.EmptyBudgetListException;
import exception.ExitProgramException;
import exception.MainMenuException;
import model.Budget;
import model.BudgetList;

import java.util.Scanner;

public class EnterBudget implements Command {

    private ConstantVariables constantVar = new ConstantVariables();

    @Override
    //MODIFIES: Budget budget
    //EFFECTS: set a new budget for the selected expense entry
    public int execute(BudgetList budgetList, int index) throws EmptyBudgetListException, MainMenuException, ExitProgramException {
        budgetList.checkIfBudgetListEmpty();

        Scanner scanner = new Scanner(System.in);
        String commandInput;
        Budget activeBudget = budgetList.getBudgetItem(index);

        System.out.println("'" + activeBudget.getTitle() + "'");
        System.out.println("Enter budget (CAD)");
        while(true){
            commandInput = scanner.nextLine();
            if(commandInput.equals(constantVar.COMMAND_KEY_FOR_MENU)){
                throw new MainMenuException();
            }else if(commandInput.equals(constantVar.COMMAND_KEY_FOR_EXIT)){
                throw new ExitProgramException();
            }else {
                try {
                    int amount = Integer.parseInt(commandInput);
                    activeBudget.setBudget(amount);
                    System.out.println("Your budget: $" + amount);
                    System.out.println("===============");
                    return index;
                }
                catch(NumberFormatException numFormatException) {
                    constantVar.printNotNumberMessage();
                }
            }
        }
    }

    @Override
    public String commandDescription() {
        return "Enter budget";
    }
}
