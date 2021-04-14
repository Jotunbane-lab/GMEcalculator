package lab.jotunbane.GmeCalculator.model;

import lombok.Getter;

import java.math.BigDecimal;
import java.math.RoundingMode;

@Getter
public class PlnValues {
    private BigDecimal plnGmeValue;
    private BigDecimal plnTax;
    private BigDecimal plnProfit;
    private BigDecimal plnFinalSum;
    private BigDecimal megaStonks;


    public PlnValues(importedData importedData, GmeStocks gmeStocks, Stonks stonks){
        this.plnGmeValue = gmeStocks.getUsdSum().multiply(importedData.getUsdValue()).setScale(2, RoundingMode.HALF_DOWN);
        this.plnTax = stonks.getTax().multiply(importedData.getUsdValue()).setScale(2, RoundingMode.HALF_DOWN);
        this.plnProfit = stonks.getProfit().multiply(importedData.getUsdValue()).setScale(2, RoundingMode.HALF_DOWN);
        this.plnFinalSum = stonks.getFinalValue().multiply(importedData.getUsdValue()).setScale(2, RoundingMode.HALF_DOWN);
        this.megaStonks = plnGmeValue.add(plnFinalSum);

    }
}
