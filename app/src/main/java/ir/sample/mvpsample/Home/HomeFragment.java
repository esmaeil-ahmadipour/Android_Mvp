package ir.sample.mvpsample.Home;

import android.content.Context;
import android.os.Bundle;
import android.widget.Toast;
import java.util.List;
import androidx.annotation.Nullable;
import ir.sample.mvpsample.Base.BaseFragment;
import ir.sample.mvpsample.Data.News;
import ir.sample.mvpsample.Data.NewsRepository;
import ir.sample.mvpsample.R;

public class HomeFragment extends BaseFragment implements HomeContract.View {
    private HomeContract.Presenter presenter;

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
// for testing.
        if (newsList.isEmpty()) {
            Toast.makeText(getViewContext(), "newsList isEmpty", Toast.LENGTH_SHORT).show();

        } else {
            Toast.makeText(getViewContext(), "newsList Ok", Toast.LENGTH_SHORT).show();

        }
    }

    @Override
    public void showError(String error) {

    }

    @Override
    public Context getViewContext() {
// fake return for testing.
        return getContext();
    }

    @Override
    public void setupViews() {

    }

    @Override
    public int getLayout() {
//pass layout to BaseFragment (int value !)
        return R.layout.fragment_home;
    }
}
