package command;

import command.interfaces.Command;

import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.Map;

public class MainCommandBuilder {

    public static Map<String, Command> initCommands() throws IOException {
        Map<String, Command> commandList = new LinkedHashMap<>();
        commandList.put("a", new CreateNewBudget());
        commandList.put("b", new ViewBudgetList());
        commandList.put("c", new ChangeTitle());
        commandList.put("d", new EnterBudget());
        commandList.put("e", new EnterExpense());
        commandList.put("f", new EditExpense());
        commandList.put("g", new ViewBudgetDetail());
        commandList.put("h", new ResetBudgetEntry());
        commandList.put("i", new RemoveBudgetEntry());
        commandList.put("l", new LoadTextFile());
        commandList.put("r", new DownloadReport());
        commandList.put("s", new Save());

        return commandList;
    }
}
