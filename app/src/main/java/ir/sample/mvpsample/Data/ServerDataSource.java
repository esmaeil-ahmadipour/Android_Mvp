package ir.sample.mvpsample.Data;

import java.util.List;
import io.reactivex.Single;
import ir.sample.mvpsample.Base.ApiService;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class ServerDataSource implements NewsDataSource
{
    private ApiService apiService;

    public ServerDataSource()
    {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("")
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        apiService=retrofit.create(ApiService.class);
    }

    @Override
    public Single<List<News>> getNews()
    {
        return apiService.getNews();
    }
}
