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
}
