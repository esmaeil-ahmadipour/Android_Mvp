package ir.sample.mvpsample.Search;

import java.util.ArrayList;
import java.util.List;
import io.reactivex.SingleObserver;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import ir.sample.mvpsample.Data.News;
import ir.sample.mvpsample.Data.NewsDataSource;

public class SearchPresenter implements SearchContract.Presenter {
    private SearchContract.View view;
    private NewsDataSource newsDataSource;
    private CompositeDisposable compositeDisposable = new CompositeDisposable();
    private List<News> emptyList;

    public SearchPresenter(NewsDataSource newsDataSource) {
        this.newsDataSource = newsDataSource;
        emptyList = new ArrayList<>();
    }

    @Override
    public void attachView(SearchContract.View view) {
        this.view = view;
    }

    @Override
    public void detachView() {
        this.view = null;
//because don't need data.
        if (compositeDisposable != null && compositeDisposable.size() > 0) {
            compositeDisposable.clear();
        }

    }


    @Override
    public void getSearchedNews(String searchString) {
// By One If Statement We Check : Don't Send EmptyString Request To DataSource & Server !
        if (searchString.length() > 0) {
//Listen  & When Data Received & on Main thread return answer
            newsDataSource.getSearchedNews(searchString).subscribeOn(Schedulers.newThread()).observeOn(AndroidSchedulers.mainThread()).subscribe(new SingleObserver<List<News>>() {
                @Override
                public void onSubscribe(Disposable d) {
//when more disposable : we must use compositeDisposable.add()
                    compositeDisposable.add(d);
                }

                @Override
                public void onSuccess(List<News> newsList) {
//when received data : show NewsList Items on View
                    view.showSearchedNews(newsList);
                    System.out.println("showSearchedNews:" + newsList.size());
                }

                @Override
                public void onError(Throwable e) {
                    view.showError(e.toString());

                }
            });
        } else {
//Clear RecyclerView By Send EmptyList
            view.showSearchedNews(emptyList);
        }

    }
}
