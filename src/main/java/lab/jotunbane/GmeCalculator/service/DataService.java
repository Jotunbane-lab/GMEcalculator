package lab.jotunbane.GmeCalculator.service;

import lab.jotunbane.GmeCalculator.Exchanger.NbpExchangeRateDownloader;
import lab.jotunbane.GmeCalculator.model.GmeStocks;
import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.IOException;
import java.math.BigDecimal;

public class DataService {

    public static BigDecimal getUsdValue(){
        return NbpExchangeRateDownloader.downloadUsdValue();
    }

    public static BigDecimal getGmePrice() throws IOException {
        Document doc = Jsoup.connect("https://pl.investing.com/equities/gamestop-corp").get();
        String string = doc.select("span[data-test='instrument-price-last']").first().text();
        BigDecimal result = new BigDecimal(string.replace(",", "."));
        return result;
    }

    public static GmeStocks prepareData(){
        BigDecimal myAmount = BigDecimal.valueOf(6.5387);
        BigDecimal initialPrice = BigDecimal.valueOf(81.34);
        GmeStocks myStocks = new GmeStocks(myAmount, initialPrice);
        return myStocks;
    }
}
