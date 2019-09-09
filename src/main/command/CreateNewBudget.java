package command;

import command.helper.ConstantVariables;
import command.interfaces.Command;
import exception.ExitProgramException;
import exception.MainMenuException;
import exception.TitleHasCommaException;
import model.Budget;
import model.BudgetList;

import java.util.Scanner;

public class CreateNewBudget implements Command{
    private ConstantVariables constantVar = new ConstantVariables();

    //MODIFIES: ExpenseTrackingApp BudgetList
    //EFFECTS: create new Budget and add it to budgetList
    public int execute(BudgetList budgetList, int index) throws MainMenuException, ExitProgramException {
        Scanner scanner = new Scanner(System.in);
        String commandInput;
        //String budgetDuplicateMsg;
        System.out.println("Enter title of your budget");
        System.out.println("Note: Comma is not allowed");
        while (true){
            commandInput = scanner.nextLine();
            if(commandInput.equals(constantVar.COMMAND_KEY_FOR_MENU)){
                throw new MainMenuException();
            }else if(commandInput.equals(constantVar.COMMAND_KEY_FOR_EXIT)){
                throw new ExitProgramException();
            }else {
                try{
                    Budget budget = new Budget(commandInput);
                    if(budgetList.isBudgetTitleDuplicated(budget)){
                        System.out.println(budgetList.budgetDuplicateMsg(commandInput));
                    }else{
                        budgetList.addBudgetItem(budget);
                        System.out.println("'" + budget.getTitle() + "'" + " has been created.");
                        System.out.println("===============");
                        return budgetList.getBudgetIndex(budget);
                    }
                }catch(TitleHasCommaException titleCommaException){
                    //print message from TitleHasCommaException
                }
            }
        }
    }

    public String commandDescription() {
        return "Create new budget";
    }
}
