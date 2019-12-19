package ir.sample.mvpsample.Data;

import java.util.List;
import io.reactivex.Single;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ApiService
{
    @GET("news.php")
    Single<List<News>> getNews();
    @GET("banners.php")
    Single<List<Banner>> getBanners();
    @GET("categories.php")
    Single<List<Categories>> getCategories();
    @GET("search.php")
    Single<List<News>> getSearchedNews(@Query("search")String searchString);

}
