package lab.jotunbane.GmeCalculator.controller;

import lab.jotunbane.GmeCalculator.model.GmeStocks;
import lab.jotunbane.GmeCalculator.model.PlnValues;
import lab.jotunbane.GmeCalculator.model.importedData;
import lab.jotunbane.GmeCalculator.model.Stonks;
import lab.jotunbane.GmeCalculator.service.DataService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import java.io.IOException;

@Controller
public class IndexController {

//    @GetMapping("/gmeStonks")
//    public ModelAndView view() throws IOException {
//        GmeStocks myGmeStocks = DataService.prepareData();
//        importedData importedData = new importedData();
//        Stonks stonks = new Stonks();
//
//        ModelAndView modelAndView = new ModelAndView("gmeStonks", "myGmeStocks", myGmeStocks);
//        modelAndView.addObject("stonks", stonks);
//        modelAndView.addObject("importedData", importedData);
//        return modelAndView;
//    }

    @GetMapping("/gmeStonks")
    public ModelAndView rView() throws IOException {
        GmeStocks myGmeStocks = DataService.prepareData();
        importedData importedData = new importedData();
        Stonks stonks = new Stonks();

        importedData.getData();
        stonks.getStonksValue(myGmeStocks, importedData);
        PlnValues plnValues = new PlnValues(importedData, myGmeStocks, stonks);

        ModelAndView modelAndView = new ModelAndView("gmeStonks", "myGmeStocks", myGmeStocks)
                .addObject("stonks", stonks)
                .addObject("importedData", importedData)
                .addObject("plnValues", plnValues);
        return modelAndView;

    }


}
