package model.forex;

import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.Map;

public class ForexListBuilder {
    public Map<String, Currency> currencyList;

    public ForexListBuilder() {
        currencyList = new LinkedHashMap<>();
        currencyList.put("CAD",new CAD());
        currencyList.put("USD",new USD());
        currencyList.put("GBP",new GBP());
        currencyList.put("EUR",new EUR());
    }

//    public Map<String, Currency> getCurrencyList() {
//        return currencyList;
//    }

    public void printCurrencyList(){
        for(String key : currencyList.keySet()){
            System.out.print("["+key+"]  ");
        }
    }

    public Currency getCurrency(String currency){
        return currencyList.get(currency);
    }
}
