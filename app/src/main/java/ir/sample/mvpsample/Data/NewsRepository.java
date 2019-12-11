package ir.sample.mvpsample.Data;

import java.util.List;

import io.reactivex.Single;

public class NewsRepository implements NewsDataSource
{
    private ServerDataSource serverDataSource=new ServerDataSource();
    private LocalDataSource localDataSource=new LocalDataSource();
    @Override
    public Single<List<News>> getNews()
    {
        return serverDataSource.getNews();
    }
}
