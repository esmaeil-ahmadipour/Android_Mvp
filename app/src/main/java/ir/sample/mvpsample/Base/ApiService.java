package ir.sample.mvpsample.Base;

import java.util.List;
import io.reactivex.Single;
import ir.sample.mvpsample.Data.Banner;
import ir.sample.mvpsample.Data.News;
import retrofit2.http.GET;

public interface ApiService
{
    @GET("news.php")
    Single<List<News>> getNews();
    @GET("banners.php")
    Single<List<Banner>> getBanners();
}
