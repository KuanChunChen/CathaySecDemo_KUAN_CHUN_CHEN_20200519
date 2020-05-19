package k.c.cathaysec.demo.model;

import com.google.gson.annotations.SerializedName;

public class StockPrice {


    @SerializedName("stock_name")
    public String stockName;
    @SerializedName("sell_price_name")
    public String sellPrizeName;
    @SerializedName("sell_price")
    public double sellPrize;
    @SerializedName("sell_rate_name")
    public String sellRateName;
    @SerializedName("sell_rate")
    public double sellRate;
    @SerializedName("dateline_year_name")
    public String dateLineYearName;
    @SerializedName("dateline_year")
    public double dateLineYear;

}
