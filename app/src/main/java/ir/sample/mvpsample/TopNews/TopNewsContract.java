package ir.sample.mvpsample.TopNews;

import ir.sample.mvpsample.Base.BasePresenter;
import ir.sample.mvpsample.Base.BaseView;

public interface TopNewsContract {
    interface View extends BaseView {
    }

    interface Presenter extends BasePresenter<View> {
    }
}
