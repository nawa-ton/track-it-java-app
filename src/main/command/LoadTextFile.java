package command;

import command.helper.ConstantVariables;
import command.interfaces.Command;
import command.interfaces.Loadable;
import exception.ExitProgramException;
import exception.ExpensePurposeHasCommaException;
import exception.MainMenuException;
import exception.TitleHasCommaException;
import model.Budget;
import model.BudgetList;
import model.Expense;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.NoSuchFileException;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class LoadTextFile implements Loadable, Command {
    private ConstantVariables constantVar = new ConstantVariables();
    private int budgetIndex;

    //MODIFIES: this, budget, expense
    //EFFECTS: create budget from file input
    @Override
    public void load(String fileName, BudgetList budgetList) throws IOException, TitleHasCommaException, ExpensePurposeHasCommaException, NoSuchFileException{
        List<String> lines = Files.readAllLines(Paths.get(fileName));
        for(int i = 0; i < lines.size(); i++){
            ArrayList<String> partOfLine = splitOnComma(lines.get(i));
            if(!lines.get(i).equals("")){
                if(i%2 == 0){
                    //even row: title and budget, index starts from 0
                    Budget budget = new Budget(partOfLine.get(0));
                    budget.setBudget(Integer.parseInt(partOfLine.get(1)));
                    budgetList.addBudgetItem(budget);
                    budgetIndex = budgetList.getBudgetIndex(budget);
                }else{
                    //odd row: expenses
                    for(int j = 0; j < partOfLine.size(); j=j+2){
                        Expense expense = new Expense(partOfLine.get(j),Integer.parseInt(partOfLine.get(j+1)));
                        budgetList.getBudgetItem(budgetIndex).addExpense(expense);
                    }
                }
            }
        }
    }

    //Resource: FileReaderWriter project (https://drive.google.com/file/d/1hA9g_u-N0K0ZEzxBMYXl6IzEyoXSo4m3/view)
    //REQUIRES: valid text
    //EFFECTS: return array of split texts
    private ArrayList<String> splitOnComma(String line){
        String[] splits = line.split(",");
        return new ArrayList<>(Arrays.asList(splits));
    }

    @Override
    public int execute(BudgetList budgetList, int index) throws IOException, MainMenuException, ExitProgramException {
        Scanner scanner = new Scanner(System.in);
        String commandInput;
        System.out.println("Enter file name");
        while(true){
            commandInput = scanner.nextLine();
            if(commandInput.equals(constantVar.COMMAND_KEY_FOR_MENU)){
                throw new MainMenuException();
            }else if(commandInput.equals(constantVar.COMMAND_KEY_FOR_EXIT)){
                throw new ExitProgramException();
            }else{
                try {
                    load(commandInput, budgetList);
                    System.out.println("Loading is done.");
                    System.out.println("===============");
                    return index;
                }catch (NoSuchFileException noSuchFileException) {
                    System.out.println("File not found. Please re-enter");
                }catch(TitleHasCommaException titleCommaException){
                    System.out.println("Budget title contains non-permitted comma. Unable to load the file.");
                }catch(ExpensePurposeHasCommaException purposeCommaException){
                    System.out.println("Expense purpose contains non-permitted comma. Unable to load the file.");
                }
            }
        }
    }

    @Override
    public String commandDescription() {
        return "Load file";
    }
}
