package k.c.cathaysec.demo.ui;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

import butterknife.BindView;
import butterknife.ButterKnife;
import k.c.cathaysec.demo.CathatSecApplication;
import k.c.cathaysec.demo.R;

public class FincFragment extends Fragment {

    View view;
    @BindView(R.id.finc_title)
    TextView fincTitle;

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        view = inflater.inflate(R.layout.finc_fragment, container, false);
        super.onCreate(savedInstanceState);
        ButterKnife.bind(this, view);
        fincTitle.setText(CathatSecApplication.getContext().getString(R.string.fincpage));
        return view;
    }
}