package command.interfaces;

import exception.EmptyBudgetListException;
import exception.ExitProgramException;
import exception.MainMenuException;
import model.BudgetList;

import java.io.IOException;

public interface Command {

    int execute(BudgetList budgetList, int index) throws EmptyBudgetListException, IOException, MainMenuException, ExitProgramException;

    String commandDescription();
}
