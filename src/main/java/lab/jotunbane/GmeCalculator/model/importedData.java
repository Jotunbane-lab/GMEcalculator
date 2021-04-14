package lab.jotunbane.GmeCalculator.model;

import lab.jotunbane.GmeCalculator.service.DataService;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.IOException;
import java.math.BigDecimal;
import java.math.RoundingMode;

@Getter
public class importedData {
    private BigDecimal usdValue;
    private BigDecimal usdPrice;
    private BigDecimal plnPrice;

    public importedData() {
        this.usdPrice = BigDecimal.ZERO;
        this.usdValue = BigDecimal.ZERO;
        this.plnPrice = BigDecimal.ZERO;
    }

    public void getData() throws IOException {
        this.usdValue = DataService.getUsdValue().setScale(2, RoundingMode.HALF_DOWN);
        this.usdPrice = DataService.getGmePrice().setScale(2, RoundingMode.HALF_DOWN);
        this.plnPrice = usdPrice.multiply(this.usdValue).setScale(2, RoundingMode.HALF_DOWN);
    };
    
}
