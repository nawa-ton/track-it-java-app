package model.forex;

import java.io.IOException;

public class GBP extends Currency{
    public GBP() {
        super();
        this.currencyName = "GBP";
        this.currencySymbol = "£";
        this.rate = getForexFromWeb.getForex().getForexList().get(this.currencyName);
    }
}
