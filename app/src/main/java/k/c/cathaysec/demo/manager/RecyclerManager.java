package k.c.cathaysec.demo.manager;

import java.util.ArrayList;
import java.util.List;

import k.c.cathaysec.demo.adapter.StockRecycleViewAdapter;
import k.c.cathaysec.demo.model.StockPrice;
import k.c.cathaysec.demo.util.DataMakerUtil;

public class RecyclerManager {


    public static StockRecycleViewAdapter getStockAdapter() {
        List<StockPrice> stockPriceList = DataMakerUtil.stockPriceListMaker();
        return new StockRecycleViewAdapter(stockPriceList);
    }
}
