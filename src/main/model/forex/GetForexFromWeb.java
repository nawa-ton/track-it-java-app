package model.forex;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.net.URL;

public class GetForexFromWeb {

    //JSON PARSER resource: https://github.com/FasterXML/jackson-databind
    private ObjectMapper mapper;
    private Forex forex;

    public GetForexFromWeb() {
        mapper = new ObjectMapper();
        mapper.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
        try {
            forex = mapper.readValue(new URL("http://apilayer.net/api/live?access_key=36478291df55f05a9c8aa18edcf72392&currencies=CAD,USD,GBP,EUR&format=1"), Forex.class);
            //forex = mapper.readValue(new URL("http://nawacreative.com/trackit/forex.json"), Forex.class);
        } catch (IOException ioException) {
            System.out.println("Unable to download the exchange rate.");
            ioException.printStackTrace();
        }
        forex.setForexList();
    }

    public Forex getForex() {
        return forex;
    }

}
