package ir.sample.mvpsample.Categories;

import java.util.List;

import io.reactivex.SingleObserver;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import ir.sample.mvpsample.Data.Categories;
import ir.sample.mvpsample.Data.NewsDataSource;

public class CategoriesPresenter implements CategoriesContract.Presenter {
    private CategoriesContract.View view;
    private NewsDataSource newsDataSource;
    private CompositeDisposable compositeDisposable = new CompositeDisposable();

    public CategoriesPresenter(NewsDataSource newsDataSource) {
        this.newsDataSource = newsDataSource;
    }

    @Override
    public void getCategoriesList() {
//Listen  & When Data Received & on Main thread return answer
        newsDataSource.getCategories().subscribeOn(Schedulers.newThread()).observeOn(AndroidSchedulers.mainThread()).subscribe(new SingleObserver<List<Categories>>() {
            @Override
            public void onSubscribe(Disposable d) {
//when more disposable : we must use compositeDisposable.add()
                compositeDisposable.add(d);
            }

            @Override
            public void onSuccess(List<Categories> categoriesList) {
                view.showCategories(categoriesList);
            }

            @Override
            public void onError(Throwable e) {
                view.showError(e.toString());
            }
        });
    }

    @Override
    public void attachView(CategoriesContract.View view) {
        this.view = view;
        getCategoriesList();
    }

    @Override
    public void detachView() {
        this.view = null;
//because don't need data.
        if (compositeDisposable != null && compositeDisposable.size() > 0) {
            compositeDisposable.clear();
        }
    }


}
