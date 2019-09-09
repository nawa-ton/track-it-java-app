package model.forex;

import java.io.IOException;

public class CAD extends Currency {
    public CAD() {
        super();
        this.currencyName = "CAD";
        this.currencySymbol = "$";
        this.rate = getForexFromWeb.getForex().getForexList().get(this.currencyName);
    }
}
