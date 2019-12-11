package ir.sample.mvpsample.Home;

import java.util.List;
import ir.sample.mvpsample.Base.BasePresenter;
import ir.sample.mvpsample.Base.BaseView;
import ir.sample.mvpsample.Data.News;

public interface HomeContract
{
    interface View extends BaseView
    {
        void showNews(List<News> newsList);
        void showError(String error);
    }

    interface Presenter extends BasePresenter<View>
    {
        void getNewsList();
    }
}
