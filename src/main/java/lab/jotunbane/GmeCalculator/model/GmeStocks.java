package lab.jotunbane.GmeCalculator.model;

import lab.jotunbane.GmeCalculator.service.DataService;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.math.RoundingMode;

@Getter
@Setter
@NoArgsConstructor
public class GmeStocks {
    private BigDecimal amount;
    private BigDecimal usdPrice;
    private BigDecimal usdSum;


    public GmeStocks(BigDecimal amount, BigDecimal usdPrice) {
        this.amount = amount;
        this.usdPrice = usdPrice;
        this.usdSum = usdPrice.multiply(amount).setScale(2, RoundingMode.HALF_DOWN);
    }

//    protected void getPlnValue(BigDecimal usdValue){
//        this.plnPrice = usdPrice.multiply(usdValue);
//        this.plnSum = plnPrice.multiply(amount);
}



