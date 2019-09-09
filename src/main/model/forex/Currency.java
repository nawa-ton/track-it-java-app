package model.forex;

import java.io.IOException;

public abstract class Currency {
    protected String currencyName;
    protected String currencySymbol;
    protected float rate;
    protected GetForexFromWeb getForexFromWeb;

    public Currency() {
        getForexFromWeb = new GetForexFromWeb();
    }

    public String getCurrencyName() {
        return currencyName;
    }

    public String getCurrencySymbol() {
        return currencySymbol;
    }

    public float getRate() {
        return rate;
    }
}
