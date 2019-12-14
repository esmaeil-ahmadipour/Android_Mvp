package ir.sample.mvpsample.Data;

import java.util.List;
import io.reactivex.Single;

public interface NewsDataSource
{
    Single<List<News>> getNews();
    Single<List<Banner>> getBanners();
    Single<List<News>> getLastNews();
    Single<List<News>> getSavedNews();
}
