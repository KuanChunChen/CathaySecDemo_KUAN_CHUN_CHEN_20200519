package k.c.cathaysec.demo.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import k.c.cathaysec.demo.R;
import k.c.cathaysec.demo.model.StockPrice;

public class StockRecycleViewAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {


    List<StockPrice> stockPriceList;

    static final int TYPE_CELL = 1;



    public StockRecycleViewAdapter(List<StockPrice> inputStockPriceList) {

        this.stockPriceList = inputStockPriceList;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view;

        switch (viewType) {


            default: {
                view = LayoutInflater.from(parent.getContext())
                        .inflate(R.layout.item_stock, parent, false);
                return new stockViewHolder(view) {
                };
            }
        }
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {

        switch (getItemViewType(position)) {

            case TYPE_CELL:
                StockPrice stockPrice = stockPriceList.get(position);

                if (holder instanceof stockViewHolder) {

                    ((stockViewHolder) holder).stockTitle.setText(stockPrice.stockName);

                    ((stockViewHolder) holder).stockPriceTitle.setText(stockPrice.sellPrizeName);
                    ((stockViewHolder) holder).stockPrice.setText(String.valueOf(stockPrice.sellPrize));

                    ((stockViewHolder) holder).stockRateTitle.setText(stockPrice.sellRateName);
                    ((stockViewHolder) holder).stockRate.setText(String.valueOf(stockPrice.sellRate));

                    ((stockViewHolder) holder).stockYearTitle.setText(stockPrice.dateLineYearName);
                    ((stockViewHolder) holder).stockYear.setText(String.valueOf(stockPrice.dateLineYear));

                }

                break;
        }

    }

    @Override
    public int getItemViewType(int position) {
        switch (position) {

            default:
                return TYPE_CELL;
        }
    }

    @Override
    public int getItemCount() {
        return this.stockPriceList.size();
    }


    static class stockViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.stock_title)
        TextView stockTitle;
        @BindView(R.id.stock_price_title)
        TextView stockPriceTitle;
        @BindView(R.id.stock_price)
        TextView stockPrice;
        @BindView(R.id.stock_rate_title)
        TextView stockRateTitle;
        @BindView(R.id.stock_rate)
        TextView stockRate;
        @BindView(R.id.stock_year_title)
        TextView stockYearTitle;
        @BindView(R.id.stock_year)
        TextView stockYear;

        Unbinder unbinder;


        public stockViewHolder(@NonNull View itemView) {
            super(itemView);
            unbinder = ButterKnife.bind(this, itemView);
        }
    }

}
