package ir.sample.mvpsample.Data;

import java.util.List;

import io.reactivex.Single;

public class LocalDataSource implements NewsDataSource
{
    @Override
    public Single<List<News>> getNews()
    {
        return null;
    }

    @Override
    public Single<List<Banner>> getBanners() {
        return null;
    }

    @Override
    public Single<List<Categories>> getCategories() {
        return null;
    }

    @Override
    public Single<List<News>> getLastNews() {
        return null;
    }

    @Override
    public Single<List<News>> getSavedNews() {
        return null;
    }

    @Override
    public Single<List<News>> getSearchedNews(String searchString) {
        return null;
    }
}
