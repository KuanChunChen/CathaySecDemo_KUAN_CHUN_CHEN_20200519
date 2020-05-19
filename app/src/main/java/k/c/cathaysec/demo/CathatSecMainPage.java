package k.c.cathaysec.demo;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import k.c.cathaysec.demo.manager.FragmentManager;
import k.c.cathaysec.demo.ui.BidFragment;
import k.c.cathaysec.demo.ui.FincFragment;
import k.c.cathaysec.demo.ui.MainPageFragment;
import k.c.cathaysec.demo.ui.MoreFragment;
import k.c.cathaysec.demo.ui.PriceFragment;

public class CathatSecMainPage extends AppCompatActivity {


    private Fragment currentFragment = null;
    private static MainPageFragment mainPageFragment;
    private static PriceFragment priceFragment;
    private static BidFragment bidFragment;
    private static FincFragment fincFragment;
    private static MoreFragment moreFragment;

    private Unbinder unbind;



    static {

        mainPageFragment = new MainPageFragment();
        priceFragment = new PriceFragment();
        bidFragment = new BidFragment();
        fincFragment = new FincFragment();
        moreFragment = new MoreFragment();
    }

    @BindView(R.id.bnve)
    BottomNavigationView bottomNavigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        unbind = ButterKnife.bind(this);
        initBnve();
    }


    @Override
    protected void onStart() {

        super.onStart();



    }



    void initBnve(){

        getSupportFragmentManager().beginTransaction().add(R.id.lay_container, moreFragment).hide(moreFragment).commit();
        getSupportFragmentManager().beginTransaction().add(R.id.lay_container, fincFragment).hide(fincFragment).commit();
        getSupportFragmentManager().beginTransaction().add(R.id.lay_container, bidFragment).hide(bidFragment).commit();
        getSupportFragmentManager().beginTransaction().add(R.id.lay_container, priceFragment).hide(priceFragment).commit();
        getSupportFragmentManager().beginTransaction().add(R.id.lay_container, mainPageFragment).commit();

        currentFragment = mainPageFragment;

        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                switch (item.getItemId()) {
                    case R.id.menu_mainpage:
                        getSupportFragmentManager().beginTransaction().hide(currentFragment).show(mainPageFragment).commit();
                        currentFragment = mainPageFragment;
                        break;
                    case R.id.menu_price:
                        getSupportFragmentManager().beginTransaction().hide(currentFragment).show(priceFragment).commit();
                        currentFragment = priceFragment;
                        break;
                    case R.id.menu_bid:
                        getSupportFragmentManager().beginTransaction().hide(currentFragment).show(bidFragment).commit();
                        currentFragment = bidFragment;
                        break;
                    case R.id.menu_finc:
                        getSupportFragmentManager().beginTransaction().hide(currentFragment).show(fincFragment).commit();
                        currentFragment = fincFragment;
                        break;
                    case R.id.menu_more:
                        getSupportFragmentManager().beginTransaction().hide(currentFragment).show(moreFragment).commit();
                        currentFragment = moreFragment;
                        break;

                }


                return FragmentManager.loadfragment(currentFragment);
            }
        });

    }

    @Override
    public void onPause(){
        super.onPause();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        currentFragment = null;
        unbind.unbind();

    }

}
