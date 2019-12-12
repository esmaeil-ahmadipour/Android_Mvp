package ir.sample.mvpsample.Home;

import java.util.List;

import io.reactivex.SingleObserver;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import ir.sample.mvpsample.Data.News;
import ir.sample.mvpsample.Data.NewsDataSource;

public class HomePresenter implements HomeContract.Presenter
{
    private HomeContract.View view;
    private NewsDataSource newsDataSource;
    private CompositeDisposable compositeDisposable = new CompositeDisposable();

    public HomePresenter(NewsDataSource newsDataSource)
    {
        this.newsDataSource = newsDataSource;
    }

    @Override
    public void getNewsList()
    {
        //Listen  & When Data Received & on Main thread return answer
        newsDataSource.getNews().subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new SingleObserver<List<News>>()
                {
                    @Override
                    public void onSubscribe(Disposable d)
                    {
                        //when more disposable : we must use compositeDisposable.add()
                        compositeDisposable.add(d);
                    }

                    @Override
                    public void onSuccess(List<News> newsList)
                    {
                        //when received data : show NewsList Items on View
                        view.showNews(newsList);
                    }

                    @Override
                    public void onError(Throwable e)
                    {
                        view.showError(e.toString());
                    }
                });
    }

    @Override
    public void attachView(HomeContract.View view)
    {
        this.view = view;
        getNewsList();
    }

    @Override
    public void detachView()
    {
        this.view = null;
        //because don't need data.
        if (compositeDisposable != null && compositeDisposable.size() > 0)
        {
            compositeDisposable.clear();
        }
    }
}
