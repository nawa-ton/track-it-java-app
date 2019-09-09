package model.forex;

import java.util.LinkedHashMap;
import java.util.Map;

public class Forex {
    //Raw forex from JSON (Keys contain USD prefix - USDUSD, USDCAD, ...)
    private Map<String,Float> quotes = new LinkedHashMap<>();

    //Formatted forex list (remove USD prefix from keys)
    private Map<String,Float> forexList = new LinkedHashMap<>();

    //setQuote allows JSON parser to parse the forex list
    public void setQuotes(Map<String, Float> quotes) {
        this.quotes = quotes;
    }

    public Map<String, Float> getForexList() {
        return forexList;
    }

    //Put forex info into forexList map
    private void buildForexList(){
        for(String key : quotes.keySet()){
            if(!forexList.containsKey(key.substring(3))){
                forexList.put(key.substring(3),quotes.get(key));
            }
        }
    }

    //Set CAD as default currency, so no conversion needed.
    public void setForexList(){
        buildForexList();
        for(String key : forexList.keySet()){
            if(key.equals("CAD")){
                forexList.replace("CAD", setDefaultCurrency());
            }
            else {
                forexList.replace(key,setCurrency(key));
            }
        }
    }

    private float setDefaultCurrency(){
        return 1;
    }

    //Convert CAD to other currency with rates from the web
    private float setCurrency(String currency){
        String currencyFormat = "USD"+currency;
        return (quotes.get("USDUSD")/quotes.get("USDCAD"))*quotes.get(currencyFormat);
    }


}
