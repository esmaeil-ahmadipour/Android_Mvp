package ir.sample.mvpsample.Categories;

import java.util.List;

import ir.sample.mvpsample.Base.BasePresenter;
import ir.sample.mvpsample.Base.BaseView;
import ir.sample.mvpsample.Data.Categories;

public interface CategoriesContract {
    interface View extends BaseView {
        void showCategories(List<Categories> categoriesList);
        void showError(String error);

    }

    interface Presenter extends BasePresenter<View> {
        void getCategoriesList();
    }

}
