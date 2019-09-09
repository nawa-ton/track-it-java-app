package command;

import command.helper.ConstantVariables;
import command.interfaces.Command;
import command.saveTool.SaveRecordToTextFile;
import exception.ExitProgramException;
import exception.MainMenuException;
import model.BudgetList;

import java.io.IOException;
import java.util.Scanner;

public class Save implements Command {

    private ConstantVariables constantVar = new ConstantVariables();
    private SaveRecordToTextFile saveRecordToTextFile = new SaveRecordToTextFile();

    @Override
    public int execute(BudgetList budgetList, int index) throws IOException, MainMenuException, ExitProgramException {
        Scanner scanner = new Scanner(System.in);
        String commandInput;
        System.out.println("Enter file name (without file extension)");
        commandInput = scanner.nextLine();
        if(commandInput.equals(constantVar.COMMAND_KEY_FOR_MENU)){
            throw new MainMenuException();
        }else if(commandInput.equals(constantVar.COMMAND_KEY_FOR_EXIT)){
            throw new ExitProgramException();
        }else {
            String fileName = commandInput + ".csv";
            saveRecordToTextFile.save(fileName,budgetList);
        }
        return index;
    }

    @Override
    public String commandDescription(){
        return "Save";
    }
}
