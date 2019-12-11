package ir.sample.mvpsample.Base;

import java.util.List;
import io.reactivex.Single;
import ir.sample.mvpsample.Data.News;
import retrofit2.http.GET;

public interface ApiService
{
    @GET("")
    Single<List<News>> getNews();
}
