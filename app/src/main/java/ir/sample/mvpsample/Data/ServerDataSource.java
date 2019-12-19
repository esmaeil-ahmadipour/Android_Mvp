package ir.sample.mvpsample.Data;

import java.util.List;
import io.reactivex.Single;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class ServerDataSource implements NewsDataSource
{
    private ApiService apiService;

    public ServerDataSource()
    {
// Config Retrofit
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://192.168.56.1/mvp/")
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        apiService=retrofit.create(ApiService.class);
    }

    @Override
    public Single<List<News>> getNews()
    {
// Send Request To Server (For Get News And Create NewsList).
        return apiService.getNews();
    }

    @Override
    public Single<List<Banner>> getBanners() {
// Send Request To Server (For Get Banners And Create BannerList).
        return apiService.getBanners();
    }

    @Override
    public Single<List<Categories>> getCategories() {
// Send Request To Server (For Get Categories And Create CategoriesList).
        return apiService.getCategories();
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
    public Single<List<News>> getSearchedNews(String searchedString) {
// Send Request To Server (For Get Categories And Create CategoriesList).
        return apiService.getSearchedNews(searchedString);
    }
}
