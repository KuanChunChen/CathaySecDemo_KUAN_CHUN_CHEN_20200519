package k.c.cathaysec.demo.util;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import k.c.cathaysec.demo.CathatSecApplication;
import k.c.cathaysec.demo.R;
import k.c.cathaysec.demo.model.StockPrice;

public class DataMakerUtil {


    public static List<StockPrice> stockPriceListMaker(){

        List<StockPrice> stockPriceList = new ArrayList<>();
        stockPriceList.add(stockPriceMaker());
        stockPriceList.add(stockPriceMaker());
        stockPriceList.add(stockPriceMaker());
        stockPriceList.add(stockPriceMaker());
        stockPriceList.add(stockPriceMaker());
        stockPriceList.add(stockPriceMaker());
        stockPriceList.add(stockPriceMaker());
        stockPriceList.add(stockPriceMaker());
        stockPriceList.add(stockPriceMaker());
        stockPriceList.add(stockPriceMaker());
        return stockPriceList;

    }

    private static StockPrice stockPriceMaker() {

        StockPrice stockPrice = new StockPrice();

        String[] stockN = {"埃克森美孚 2,995% 2039年", "安海斯布希英博 2,495% 2029年","比特國私安乞博 2,125% 9999年 "};
        double[] sellPrice = {101.94,123.45,122.42};
        double[] sellRate = {2.31,2.33,1.22};
        double[] datelineYear = {8.85,8.83,8.882};

        stockPrice.stockName = stockN[new Random().nextInt(3)];
        stockPrice.sellPrize = sellPrice[new Random().nextInt(3)];
        stockPrice.sellRate = sellRate[new Random().nextInt(3)];
        stockPrice.dateLineYear = datelineYear[new Random().nextInt(3)];
        stockPrice.dateLineYearName = CathatSecApplication.getContext().getString(R.string.sellyear);
        stockPrice.sellPrizeName = CathatSecApplication.getContext().getString(R.string.sellprice);
        stockPrice.sellRateName = CathatSecApplication.getContext().getString(R.string.sellrate);

        return stockPrice;
    }
}
