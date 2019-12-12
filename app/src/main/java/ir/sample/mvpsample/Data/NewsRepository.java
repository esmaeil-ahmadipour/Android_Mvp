package ir.sample.mvpsample.Data;

import java.util.List;
import io.reactivex.Single;

public class NewsRepository implements NewsDataSource {
    private ServerDataSource serverDataSource = new ServerDataSource();
    private LocalDataSource localDataSource = new LocalDataSource();

    @Override
    public Single<List<News>> getNews() {
        return serverDataSource.getNews();
    }

    @Override
    public Single<List<News>> getBanners() {
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
}
