package k.c.cathaysec.demo.manager;

import androidx.fragment.app.Fragment;

public class FragmentManager {


    public static boolean loadfragment(Fragment mFragment) {

        if (mFragment != null) {
            return true;
        }
        return false;
    }
}
