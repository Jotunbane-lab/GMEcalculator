package lab.jotunbane.GmeCalculator.Exchanger;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.net.HttpURLConnection;
import java.net.URL;

public class NbpExchangeRateDownloader {

    public static BigDecimal downloadUsdValue() {
        BigDecimal result = BigDecimal.ZERO;

        try {

            URL url = new URL("http://api.nbp.pl/api/exchangerates/rates/A/USD/");
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");
            conn.setRequestProperty("Accept", "application/json");

            if (conn.getResponseCode() != 200) {
                throw new RuntimeException("Failed : HTTP error code : "
                        + conn.getResponseCode());
            }

            BufferedReader br = new BufferedReader(new InputStreamReader(
                    (conn.getInputStream())));

            System.out.println("Output from Server .... ");
            NbpExchangeRateSeries series = new ObjectMapper().readValue(br.readLine()
                    , NbpExchangeRateSeries.class);
            result = series.getRates().get(0).getMid();
            conn.disconnect();

        } catch (IOException e) {
            e.printStackTrace();

        }
        return result;
    }
}