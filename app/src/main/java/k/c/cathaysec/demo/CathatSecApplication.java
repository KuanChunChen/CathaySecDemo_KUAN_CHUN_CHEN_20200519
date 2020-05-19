package k.c.cathaysec.demo;

import android.app.Application;
import android.content.Context;

public class CathatSecApplication extends Application {


    private static CathatSecApplication instance = null;
    private static Context mContext;

    @Override
    public void onCreate() {
        super.onCreate();
        instance = this;
        mContext = this;


    }

    public static CathatSecApplication getInstance() {
        return instance;
    }


    public static Context getAppContext() {
        if (instance != null) {
            return instance.getApplicationContext();
        }
        throw new RuntimeException("APP instance is null");
    }

    public static Context getContext() {
        return mContext;
    }

}
