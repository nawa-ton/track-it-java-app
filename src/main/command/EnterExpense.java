package command;

import command.helper.ConstantVariables;
import command.helper.HelperMethods;
import command.interfaces.Command;
import exception.EmptyBudgetListException;
import exception.ExitProgramException;
import exception.ExpensePurposeHasCommaException;
import exception.MainMenuException;
import model.Budget;
import model.BudgetList;
import model.Expense;

import java.util.Scanner;

public class EnterExpense implements Command {
    private HelperMethods helperMethods = new HelperMethods();
    private ConstantVariables constantVar = new ConstantVariables();

    @Override
    //MODIFIES: Budget listExpenseAmount and listExpensePurpose
    //EFFECTS: add expense to the expense amount list and expense purpose to the expense purpose list
    public int execute(BudgetList budgetList, int index) throws EmptyBudgetListException, ExitProgramException, MainMenuException {
        budgetList.checkIfBudgetListEmpty();

        Budget activeBudget = budgetList.getBudgetItem(index);

        helperMethods.printBudgetTitle(activeBudget);
        int amount = helperMethods.getExpenseAmountInput();

        setExpenseItem(amount, activeBudget);
        activeBudget.update();
        return index;
    }

    @Override
    public String commandDescription() {
        return "Enter expense";
    }

    private void setExpenseItem(int amount, Budget budget) throws ExitProgramException, MainMenuException {
        Scanner scanner = new Scanner(System.in);
        String commandInput;
        System.out.println("Enter purpose");
        System.out.println("Note: Comma is not allowed");
        while(true){
            commandInput = scanner.nextLine();
            if(commandInput.equals(constantVar.COMMAND_KEY_FOR_MENU)){
                throw new MainMenuException();
            }else if(commandInput.equals(constantVar.COMMAND_KEY_FOR_EXIT)){
                throw new ExitProgramException();
            }else {
                try {
                    Expense expense = new Expense(commandInput, amount);
                    budget.addExpense(expense);
                    System.out.println("You spent $" + amount + " on " + commandInput);
                    System.out.println("===============");
                    return;
                } catch (ExpensePurposeHasCommaException purposeCommaException) {
                    //print message from ExpensePurposeHasCommaException
                }
            }
        }
    }
}
