package ir.sample.mvpsample.Data;

import java.util.List;
import io.reactivex.Single;

public interface NewsDataSource
{
    Single<List<News>> getNews();
}
