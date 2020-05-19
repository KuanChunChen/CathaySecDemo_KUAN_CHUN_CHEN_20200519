package k.c.cathaysec.demo.ui;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.appbar.AppBarLayout;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import k.c.cathaysec.demo.CathatSecApplication;
import k.c.cathaysec.demo.R;
import k.c.cathaysec.demo.adapter.StockRecycleViewAdapter;
import k.c.cathaysec.demo.manager.RecyclerManager;

public class PriceFragment extends Fragment implements View.OnClickListener {

    View view;

    private static StockRecycleViewAdapter stockRecycleViewAdapter;

    private Unbinder unbind;

    @BindView(R.id.recycleList)
    RecyclerView recycleList;
    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.appbar)
    AppBarLayout appbar;
    @BindView(R.id.btn_sell_price)
    Button btnSellPrice;
    @BindView(R.id.btn_sell_rate)
    Button btnSellRate;




    static {
        stockRecycleViewAdapter = RecyclerManager.getStockAdapter();

    }





    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        view = inflater.inflate(R.layout.price_fragment, container, false);
        super.onCreate(savedInstanceState);
        unbind = ButterKnife.bind(this, view);
        initRecyclerView();
        initBasic();
        initToobar();
        return view;
    }



    private void initBasic(){
        Drawable drawable = getResources().getDrawable(R.drawable.ic_noti_info_white);
        drawable.setBounds(0, 0, drawable.getMinimumWidth(), drawable.getMinimumHeight());

        btnSellPrice.setCompoundDrawables(null,null,drawable,null);
        btnSellPrice.setText(CathatSecApplication.getContext().getString(R.string.sellprice));
        btnSellRate.setCompoundDrawables(null,null,drawable,null);
        btnSellRate.setText(CathatSecApplication.getContext().getString(R.string.sellrate));

    }

    private void initRecyclerView() {




        LinearLayoutManager llm = new LinearLayoutManager(CathatSecApplication.getInstance());
        llm.setOrientation(LinearLayoutManager.VERTICAL);
        recycleList.setLayoutManager(llm);
        recycleList.setHasFixedSize(true);
        recycleList.setAdapter(stockRecycleViewAdapter);
        recycleList.setItemAnimator(new DefaultItemAnimator());
    }

    private void initToobar() {


        ((AppCompatActivity) getActivity()).setSupportActionBar(toolbar);
        if (((AppCompatActivity) getActivity()).getSupportActionBar() != null) {
            ((AppCompatActivity) getActivity()).getSupportActionBar().setTitle("");

        }

    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        unbind.unbind();

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_sell_price:
                Toast.makeText(CathatSecApplication.getContext(), "目前參考賣價123.55", Toast.LENGTH_SHORT).show();
                break;
            case R.id.btn_sell_rate:
                Toast.makeText(CathatSecApplication.getContext(), "目前參考殖利率5523.55", Toast.LENGTH_SHORT).show();
                break;

        }
    }
}