package lab.jotunbane.GmeCalculator;

import lab.jotunbane.GmeCalculator.model.GmeStocks;
import lab.jotunbane.GmeCalculator.service.DataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.IOException;
import java.math.BigDecimal;

@SpringBootApplication
public class GmeCalculatorApplication {

	public static void main(String[] args) {
		SpringApplication.run(GmeCalculatorApplication.class, args);

//		Prepare Data
		GmeStocks myStocks = DataService.prepareData();

		System.out.println(myStocks);
	}

}

