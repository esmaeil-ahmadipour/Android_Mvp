package ir.sample.mvpsample.Categories;

import android.content.Context;
import android.os.Bundle;

import java.util.List;

import androidx.annotation.Nullable;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import ir.sample.mvpsample.Base.BaseFragment;
import ir.sample.mvpsample.Data.Categories;
import ir.sample.mvpsample.Data.NewsRepository;
import ir.sample.mvpsample.R;

public class CategoriesFragment extends BaseFragment implements CategoriesContract.View {
    private CategoriesContract.Presenter presenter;
    private RecyclerView recyclerView;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        presenter = new CategoriesPresenter(new NewsRepository());
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
    public void setupViews() {
//Cast & Configuration RecyclerView
        recyclerView = (RecyclerView) rootView.findViewById(R.id.rv_fragmentCat_catList);
        recyclerView.setLayoutManager(new LinearLayoutManager(getViewContext(), LinearLayoutManager.VERTICAL, false));

    }

    @Override
    public int getLayout() {
        return R.layout.fragment_categories;
    }

    @Override
    public Context getViewContext() {
        return getContext();
    }


    @Override
    public void showCategories(List<Categories> categoriesList) {
        setupViews();
        recyclerView.setAdapter(new CategoriesAdapter(categoriesList));
    }

    @Override
    public void showError(String error) {

    }
}
