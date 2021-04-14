package lab.jotunbane.GmeCalculator.configuration;

import lab.jotunbane.GmeCalculator.model.GmeStocks;
import lab.jotunbane.GmeCalculator.service.DataService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import java.math.BigDecimal;

@Configuration
@ComponentScan(basePackages = {"lab.jotunbane.GmeCalculator.configuration","lab.jotunbane.GmeCalculator.service"})
public class SpringConfig {
//    @Bean
//    public GmeStocks getMyStocks(){
//        BigDecimal myAmount = BigDecimal.valueOf(6.5387);
//        BigDecimal initialPrice = BigDecimal.valueOf(81.34);
//        GmeStocks myStocks = new GmeStocks(myAmount, initialPrice);
//        myStocks.getPlnValue(DataService.getUsdValue());
//        return myStocks;
//    }
}
