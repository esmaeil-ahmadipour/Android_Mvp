package ir.sample.mvpsample.TopNews;

import android.content.Context;

import ir.sample.mvpsample.Base.BaseFragment;
import ir.sample.mvpsample.R;

public class TopNewsFragment extends BaseFragment implements TopNewsContract.View {
    @Override
    public void setupViews() {

    }

    @Override
    public int getLayout() {
        return R.layout.fragment_topnews;
    }

    @Override
    public Context getViewContext() {
        return getContext();
    }
}
