package ir.sample.mvpsample.Home;

import android.content.Context;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.Toast;

import com.squareup.picasso.Picasso;

import java.util.List;

import androidx.annotation.Nullable;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import ir.sample.mvpsample.Base.BaseFragment;
import ir.sample.mvpsample.Data.Banner;
import ir.sample.mvpsample.Data.News;
import ir.sample.mvpsample.Data.NewsRepository;
import ir.sample.mvpsample.R;

public class HomeFragment extends BaseFragment implements HomeContract.View {
    private HomeContract.Presenter presenter;
    private ImageView imgBanner;
    private RecyclerView newsRecycler;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//presenter use NewsRepository for Connect DataModel
        presenter = new HomePresenter(new NewsRepository());
    }

    @Override
    public void onStart() {
        super.onStart();
        presenter.attachView(this);
    }

    @Override
    public void onStop() {
        super.onStop();
        presenter.detachView();
    }

    @Override
    public void showNews(List<News> newsList) {
        setupViews();
        newsRecycler.setAdapter(new NewsAdapter(newsList));
    }

    @Override
    public void showBanners(List<Banner> bannersList) {
//Set BannerImage: Set URL of Banner From DataModel To BannerImage By Use Picasso .
        Banner banner = bannersList.get(0);
        Picasso.get().load(banner.getUrl()).into(imgBanner);
    }

    @Override
    public void showError(String error) {
// fake return for testing.
        Toast.makeText(getViewContext(), error, Toast.LENGTH_SHORT).show();
    }

    @Override
    public Context getViewContext() {
// fake return for testing.
        return getContext();
    }

    @Override
    public void setupViews() {
// Initialize BannerImage & RecyclerView
        imgBanner = (ImageView) rootView.findViewById(R.id.img_fragmentHome_slider);
        newsRecycler = (RecyclerView) rootView.findViewById(R.id.rv_fragmentHome_lastNews);
//Configuration RecyclerView
        newsRecycler.setLayoutManager(new LinearLayoutManager(getViewContext(), LinearLayoutManager.VERTICAL, false));
    }

    @Override
    public int getLayout() {
//pass layout to BaseFragment (int value !)
        return R.layout.fragment_home;
    }
}
