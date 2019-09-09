package model.forex;

import java.io.IOException;

public class EUR extends Currency{
    public EUR() {
        super();
        this.currencyName = "EUR";
        this.currencySymbol = "€";
        this.rate = getForexFromWeb.getForex().getForexList().get(this.currencyName);
    }
}
