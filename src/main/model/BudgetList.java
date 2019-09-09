package model;

import exception.EmptyBudgetListException;

import java.util.ArrayList;
import java.util.List;

public class BudgetList {
    private List<Budget> budgetList;

    public BudgetList(){
        budgetList = new ArrayList<>();
    }

    public boolean isBudgetTitleDuplicated(Budget budget){
        if(budgetList.contains(budget)){
            return true;
        }else {
            return false;
        }
    }

    public String budgetDuplicateMsg(String title){
        return "You already have '"+title+"' budget. Please enter a new title";
    }

    public void addBudgetItem(Budget budget){
        if(!isBudgetTitleDuplicated(budget)){
            budgetList.add(budget);
        }
    }


    public Budget getBudgetItem(int index){
        return budgetList.get(index);
    }

    public void removeBudget(int index){
        budgetList.remove(index);
    }


    public int getBudgetIndex(Budget budget){
        return budgetList.indexOf(budget);
    }

    public int getBudgetListSize(){
        return budgetList.size();
    }

    public boolean isBudgetListEmpty(){
        return budgetList.isEmpty();
    }

    public void checkIfBudgetListEmpty() throws EmptyBudgetListException {
        if(isBudgetListEmpty()){
            throw new EmptyBudgetListException();
        }
    }




}
