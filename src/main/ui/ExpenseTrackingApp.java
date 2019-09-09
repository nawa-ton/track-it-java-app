package ui;

import command.MainCommandBuilder;
import command.helper.ConstantVariables;
import command.interfaces.Command;
import exception.EmptyBudgetListException;
import exception.ExitProgramException;
import exception.MainMenuException;
import model.BudgetList;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.Map;
import java.util.Scanner;

public class ExpenseTrackingApp {
    private String commandInput;
    private int index;
    private BudgetList budgetList = new BudgetList();
    private Scanner scanner = new Scanner(System.in);
    private Map<String, Command> commandList;
    private ConstantVariables constantVar = new ConstantVariables();

    public ExpenseTrackingApp() throws IOException {
        commandList = MainCommandBuilder.initCommands();
    }

    //EFFECTS: run the loop that take input from user and run the corresponding method.
    public void runApp() throws IOException {
        System.out.println("Hello! Welcome to Track-It. What do you want to do?");
        printMainMenu();
        while (true){
            commandInput = scanner.nextLine();
            try{
                getCommand(commandInput);
            }
            catch(EmptyBudgetListException emptyBudgetListException){
                System.out.println("You have no tracking record.");
                System.out.println("===============");
            }
            catch(MainMenuException mainMenuException){
                printMainMenu();
            }
            catch(ExitProgramException exitProgramException){
                System.out.println("See you soon. Have a lovely day!!!");
                break;
            }
            catch(NumberFormatException numFormatException){
                constantVar.printNotNumberMessage();
            }
            catch (FileNotFoundException filenotFoundException) {
                System.out.println("File not found. Please check");
            } catch (UnsupportedEncodingException unsupportedEncodingException) {
                System.out.println("Encoding is unsupported. Please check");
            }
        }
    }

    //EFFECTS: print main menu options
    private void printMainMenu(){
        String value;
        for(String key : commandList.keySet()){
            value = commandList.get(key).commandDescription();
            System.out.println("["+key+"] "+value);
        }
        constantVar.printMenuAndExitOptions();
    }

    private void getCommand(String commandInput) throws MainMenuException, ExitProgramException, EmptyBudgetListException, IOException {
        if(commandInput.equals(constantVar.COMMAND_KEY_FOR_MENU)){
            throw new MainMenuException();
        }
        else if(commandInput.equals(constantVar.COMMAND_KEY_FOR_EXIT())){
            throw new ExitProgramException();
        }
        else if(!commandList.containsKey(commandInput)){
            constantVar.printSelectionNotAvailableMessage();
        }
        else {
            //get command from the HashMap
            index = commandList.get(commandInput).execute(budgetList, index);
        }
    }

}
