package command.interfaces;

import exception.ExpensePurposeHasCommaException;
import model.BudgetList;
import model.forex.Currency;

import java.io.FileNotFoundException;
import java.io.UnsupportedEncodingException;

public interface Saveable {
    void save(String fileName, BudgetList budgetList, Currency currency) throws FileNotFoundException, UnsupportedEncodingException, ExpensePurposeHasCommaException;
}
