package ir.sample.mvpsample.Search;

import java.util.List;

import ir.sample.mvpsample.Base.BasePresenter;
import ir.sample.mvpsample.Base.BaseView;
import ir.sample.mvpsample.Data.News;

public interface SearchContract {
    interface View extends BaseView {
        void showSearchedNews(List<News> news);
        void showError(String error);

    }
    interface Presenter extends BasePresenter<View>{
        void getSearchedNews(String searchString);

    }

}
