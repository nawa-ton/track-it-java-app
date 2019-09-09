package command.saveTool;

import command.interfaces.Saveable;
import model.BudgetList;
import model.forex.Currency;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;

public abstract class SaveReport implements Saveable {
    protected PrintWriter output;
    protected String fileName;

    @Override
    public void save(String fileName, BudgetList budgetList, Currency currency) throws FileNotFoundException, UnsupportedEncodingException {
        output = new PrintWriter(fileName,"UTF-8");
        this.fileName = fileName;
        contentFormat(budgetList, currency);
    }

    abstract void contentFormat(BudgetList budgetList, Currency currency);
}
