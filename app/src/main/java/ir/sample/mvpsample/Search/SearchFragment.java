package ir.sample.mvpsample.Search;

import android.content.Context;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import androidx.annotation.Nullable;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import ir.sample.mvpsample.Base.BaseFragment;
import ir.sample.mvpsample.Data.News;
import ir.sample.mvpsample.Data.NewsRepository;
import ir.sample.mvpsample.Home.NewsAdapter;
import ir.sample.mvpsample.R;

public class SearchFragment extends BaseFragment implements SearchContract.View {
    private SearchContract.Presenter presenter;
    private RecyclerView recycler_searchedNews;
    private EditText editText_Search;
    private TextView txt_NotFound;
    private List<News> searchedNewsList;
    private NewsAdapter newsAdapter;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//presenter use NewsRepository for Connect DataModel
        this.presenter = new SearchPresenter(new NewsRepository());
        searchedNewsList = new ArrayList<>();
    }

    @Override
    public void onStart() {
        super.onStart();
        presenter.attachView(this);
        setupViews();
    }

    @Override
    public void onStop() {
        super.onStop();
        presenter.detachView();
    }

    @Override
    public void setupViews() {
//Cast RecyclerView & EditText &TextView
        txt_NotFound = (TextView) rootView.findViewById(R.id.txt_FragmentSearch_notFound);
        editText_Search = (EditText) rootView.findViewById(R.id.edt_fragmentSearch_searchNews);
        recycler_searchedNews = (RecyclerView) rootView.findViewById(R.id.rv_fragmentSearch_searchNews);
//Configuration RecyclerView & EditText
        recycler_searchedNews.setLayoutManager(new LinearLayoutManager(getViewContext(), LinearLayoutManager.VERTICAL, false));
        editText_Search.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int start, int count, int after) {
                presenter.getSearchedNews(charSequence.toString());
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });
    }

    @Override
    public int getLayout() {
        return R.layout.fragment_search;
    }

    @Override
    public Context getViewContext() {
        return getContext();
    }

    @Override
    public void showSearchedNews(List<News> news) {
        searchedNewsList.clear();
        searchedNewsList = news;
        if (news.isEmpty()) {
            txt_NotFound.setVisibility(View.VISIBLE);

        } else{
            txt_NotFound.setVisibility(View.GONE);
            newsAdapter = new NewsAdapter(searchedNewsList);
            recycler_searchedNews.setAdapter(newsAdapter);
            newsAdapter.notifyDataSetChanged();

        }
    }

    @Override
    public void showError(String error) {

    }
}
