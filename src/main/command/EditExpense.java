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

public class EditExpense implements Command {
    private HelperMethods helperMethods = new HelperMethods();
    private ConstantVariables constantVar = new ConstantVariables();

    @Override
    //MODIFIES: Budget expenseList
    //EFFECTS: Edit expense amount and purpose
    public int execute(BudgetList budgetList, int index) throws EmptyBudgetListException, ExitProgramException, MainMenuException {
        budgetList.checkIfBudgetListEmpty();

        Scanner scanner = new Scanner(System.in);
        String commandInput;
        int expenseIndex;
        Expense selectedExpense;
        Budget selectedBudget = budgetList.getBudgetItem(index);

        if(selectedBudget.isExpenseListEmpty()){
            System.out.println("You have no expense record");
            System.out.println("===============");
        }
        else{
            helperMethods.printBudgetTitle(selectedBudget);
            System.out.println("Which item you would like to edit?");
            for (int i = 0; i < selectedBudget.getExpenseListSize(); i++) {
                System.out.println("["+ i +"] " + selectedBudget.getExpenseItem(i).getExpensePurpose() + ": $" + selectedBudget.getExpenseItem(i).getExpenseAmount());
            }
            helperMethods.printSelectIndexInstruction();

            expenseIndex = helperMethods.checkIndexOutOfBound(selectedBudget.getExpenseListSize());

            //get the selected expense
            selectedExpense = budgetList.getBudgetItem(index).getExpenseItem(expenseIndex);

            System.out.println(selectedExpense.getExpensePurpose() + ": $" + selectedExpense.getExpenseAmount());
            System.out.println("[o] Edit purpose | [p] Edit amount | [q] Edit purpose & amount");
            constantVar.printMenuAndExitOptions();
            while (true){
                commandInput = scanner.nextLine();
                if(commandInput.equals(constantVar.COMMAND_KEY_FOR_MENU)){
                    throw new MainMenuException();
                }else if(commandInput.equals(constantVar.COMMAND_KEY_FOR_EXIT)){
                    throw new ExitProgramException();
                }else if(commandInput.equals("o")){
                    editOnlyExpensePurpose(selectedExpense);
                    break;
                }
                else if(commandInput.equals("p")){
                    editOnlyExpenseAmount(selectedExpense);
                    break;
                }
                else if(commandInput.equals("q")){
                    editBothExpenseAmountAndPurpose(selectedExpense);
                    break;
                }else {
                    System.out.println("Your selection is not available. Please re-enter.");
                }
            }
        }
        return index;
    }

    @Override
    public String commandDescription() {
        return "Edit expense";
    }

    private void editOnlyExpenseAmount(Expense expense) throws MainMenuException, ExitProgramException {
        int amount = helperMethods.getExpenseAmountInput();
        expense.setExpenseAmount(amount);
        System.out.println("Expense amount is updated.");
        System.out.println("===============");
    }

    private void editOnlyExpensePurpose(Expense expense) throws ExitProgramException, MainMenuException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter expense purpose");
        while(true){
            String commandInput = scanner.nextLine();
            if(commandInput.equals(constantVar.COMMAND_KEY_FOR_MENU)){
                throw new MainMenuException();
            }else if(commandInput.equals(constantVar.COMMAND_KEY_FOR_EXIT)){
                throw new ExitProgramException();
            }else {
                try {
                    expense.setExpensePurpose(commandInput);
                    System.out.println("Expense purpose is updated.");
                    System.out.println("===============");
                    return;
                } catch (ExpensePurposeHasCommaException purposeCommaException) {
                    //print message from ExpensePurposeHasCommaException
                }
            }
        }
    }

    private void editBothExpenseAmountAndPurpose(Expense expense) throws ExitProgramException, MainMenuException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter expense purpose");
        while(true){
            String commandInput = scanner.nextLine();
            if(commandInput.equals(constantVar.COMMAND_KEY_FOR_MENU)){
                throw new MainMenuException();
            }else if(commandInput.equals(constantVar.COMMAND_KEY_FOR_EXIT)){
                throw new ExitProgramException();
            }else {
                try {
                    expense.setExpensePurpose(commandInput);
                    int amount = helperMethods.getExpenseAmountInput();
                    expense.setExpenseAmount(amount);
                    System.out.println("Expense purpose and amount are updated.");
                    System.out.println("===============");
                    return;
                } catch (NumberFormatException numFormatException) {
                    constantVar.printNotNumberMessage();
                } catch (ExpensePurposeHasCommaException purposeCommaException) {
                    //print message from ExpensePurposeHasCommaException
                }
            }
        }
    }
}
