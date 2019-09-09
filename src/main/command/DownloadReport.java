package command;

import command.helper.ConstantVariables;
import command.helper.HelperMethods;
import command.interfaces.Command;
import command.saveTool.SaveReportToTextFile;
import command.saveTool.SaveReportToTextFilePercent;
import exception.ExitProgramException;
import exception.MainMenuException;
import model.BudgetList;
import model.forex.Currency;

import java.io.IOException;
import java.util.Scanner;

public class DownloadReport implements Command {

    private SaveReportToTextFile saveReportToTxt;
    private SaveReportToTextFile saveReportToTxtWithPercent;
    private ConstantVariables constantVar;
    private HelperMethods helperMethods;

    public DownloadReport() {
        saveReportToTxt = new SaveReportToTextFile();
        saveReportToTxtWithPercent = new SaveReportToTextFilePercent();
        constantVar = new ConstantVariables();
        helperMethods = new HelperMethods();
    }


    @Override
    public int execute(BudgetList budgetList, int index) throws MainMenuException, ExitProgramException, IOException {
        Scanner scanner = new Scanner(System.in);
        String commandInput;
        System.out.println("[j] Simple report | [k] Report with percentage");
        constantVar.printMenuAndExitOptions();
        while(true) {
            commandInput = scanner.nextLine();
            if (commandInput.equals(constantVar.COMMAND_KEY_FOR_MENU)) {
                throw new MainMenuException();
            } else if (commandInput.equals(constantVar.COMMAND_KEY_FOR_EXIT)) {
                throw new ExitProgramException();
            } else if (commandInput.equals("j") || commandInput.equals("k")) {
                System.out.println("Enter file name (without file extension)");
                String fileName = scanner.nextLine() + ".csv";

                helperMethods.printCurrencyList();
                Currency selectedCurrency = helperMethods.getCurrencyInput();

                if (commandInput.equals("j")) {
                    saveReportToTxt.save(fileName, budgetList,selectedCurrency);
                } else if (commandInput.equals("k")) {
                    saveReportToTxtWithPercent.save(fileName,budgetList,selectedCurrency);
                }
                return index;
            }else {
                constantVar.printSelectionNotAvailableMessage();
            }
        }
    }

    @Override
    public String commandDescription() {
        return "Download report";
    }
}
