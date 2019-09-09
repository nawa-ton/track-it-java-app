package model.forex;

import java.io.IOException;

public class USD extends Currency {
    public USD() {
        super();
        this.currencyName = "USD";
        this.currencySymbol = "$";
        this.rate = getForexFromWeb.getForex().getForexList().get(this.currencyName);
    }
}
