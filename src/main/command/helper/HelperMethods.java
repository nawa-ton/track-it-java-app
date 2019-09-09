package command.helper;

import exception.ExitProgramException;
import exception.MainMenuException;
import model.Budget;
import model.BudgetList;
import model.forex.Currency;
import model.forex.ForexListBuilder;

import java.io.IOException;
import java.util.Map;
import java.util.Scanner;

public class HelperMethods {
    private ConstantVariables constantVar;
    private ForexListBuilder forexListBuilder;

    public HelperMethods() {
        constantVar = new ConstantVariables();
        forexListBuilder = new ForexListBuilder();
    }

    //EFFECTS: check if the index input is out of bound, ask for new input if it is
    public int checkIndexOutOfBound(int arraySize) throws MainMenuException, ExitProgramException {
        Scanner scanner = new Scanner(System.in);
        String commandInput;
        while (true){
            commandInput = scanner.nextLine();
            if(commandInput.equals("m")){
                throw new MainMenuException();
            }else if(commandInput.equals("x")){
                throw new ExitProgramException();
            }else {
                try {
                    int indexInput = Integer.parseInt(commandInput);
                    if (indexInput < 0 || indexInput >= arraySize) {
                        System.out.println("Your selection is not available.");
                        System.out.println("Please enter the number in front of the tracking name.");
                    } else {
                        return indexInput;
                    }
                } catch (NumberFormatException numberFormatException) {
                    constantVar.printNotNumberMessage();
                }
            }
        }
    }

    public int getExpenseAmountInput() throws MainMenuException, ExitProgramException {
        Scanner scanner = new Scanner(System.in);
        String commandInput;
        System.out.println("Enter expense (CAD)");
        while(true){
            commandInput = scanner.nextLine();
            if(commandInput.equals("m")){
                throw new MainMenuException();
            }else if(commandInput.equals("x")){
                throw new ExitProgramException();
            }else {
                try {
                    return Integer.parseInt(commandInput);
                } catch (NumberFormatException numFormatException) {
                    constantVar.printNotNumberMessage();
                }
            }
        }
    }

    public String calculatePercentageReturnString(float numerator, float denominator){
        if(denominator!=0){
            float percentage = (numerator*100)/denominator;
            String percentageString = String.format(constantVar.DECIMAL_FORMAT, percentage);
            return percentageString;
        }else {
            return "";
        }
    }

    public void printBudgetList(BudgetList budgetList){
        for (int i = 0; i < budgetList.getBudgetListSize(); i++) {
            System.out.println("[" + i + "] " + budgetList.getBudgetItem(i).getTitle() + ": Balance $" + budgetList.getBudgetItem(i).getBalance());
        }
        printSelectIndexInstruction();
    }

    public void printSelectIndexInstruction(){
        System.out.println("Select the item by entering the number.");
        constantVar.printMenuAndExitOptions();
    }

    public void printBudgetTitle(Budget budget){
        System.out.println("'" + budget.getTitle() + "'");
    }



    public void printCurrencyList() throws ExitProgramException, MainMenuException {
        System.out.println("Select currency");
        forexListBuilder.printCurrencyList();
        System.out.println("");
    }

    public Currency getCurrencyInput() throws MainMenuException, ExitProgramException {
        Scanner scanner = new Scanner(System.in);
        String commandInput;
        String selectedCurrency;
        while (true) {
            commandInput = scanner.nextLine();
            if (commandInput.equals(constantVar.COMMAND_KEY_FOR_MENU)) {
                throw new MainMenuException();
            } else if (commandInput.equals(constantVar.COMMAND_KEY_FOR_EXIT)) {
                throw new ExitProgramException();
            } else if(commandInput.equals("CAD") || commandInput.equals("USD") || commandInput.equals("GBP") || commandInput.equals("EUR")){
                selectedCurrency = commandInput;
                return forexListBuilder.getCurrency(selectedCurrency);
            }else {
                constantVar.printSelectionNotAvailableMessage();
            }
        }
    }
}
