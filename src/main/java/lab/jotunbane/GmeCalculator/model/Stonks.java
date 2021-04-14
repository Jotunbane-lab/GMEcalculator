package lab.jotunbane.GmeCalculator.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.math.RoundingMode;

@Getter
@Setter
public class Stonks {
    private BigDecimal tax;
    private BigDecimal profit;
    private BigDecimal finalValue;

    public Stonks() {
        this.tax = BigDecimal.ZERO;
        this.profit = BigDecimal.ZERO;
        this.finalValue = BigDecimal.ZERO;
    }

    public void getStonksValue(GmeStocks gmeStocks, importedData importedData) {
        this.profit = importedData.getUsdPrice()
                .multiply(gmeStocks.getAmount())
                .subtract(gmeStocks.getUsdSum()
                .setScale(2, RoundingMode.HALF_DOWN));

        if (profit.compareTo(BigDecimal.ZERO) > 0) {
            this.tax = profit.multiply(BigDecimal.valueOf(0.19)).setScale(2, RoundingMode.HALF_DOWN);
        } else this.tax = BigDecimal.ZERO;

        this.finalValue = profit.subtract(tax);
    }
}
