package observer;

import java.util.ArrayList;
import java.util.List;

public abstract class Subject {

    private List<Observer> observers = new ArrayList<>();

    protected void addObserver(Observer observer){
        if(!observers.contains(observer)){
            observers.add(observer);
        }
    }

    protected void notifyObserver(){
        for(Observer observer : observers){
            observer.update();
        }
    }
}
