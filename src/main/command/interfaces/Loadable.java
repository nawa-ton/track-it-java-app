package command.interfaces;

import exception.ExpensePurposeHasCommaException;
import exception.TitleHasCommaException;
import model.BudgetList;

import java.io.IOException;

public interface Loadable {
    void load(String fileName, BudgetList budgetList) throws IOException, TitleHasCommaException, ExpensePurposeHasCommaException;
}

