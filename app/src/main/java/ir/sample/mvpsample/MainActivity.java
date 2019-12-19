package ir.sample.mvpsample;

import android.os.Bundle;

import com.ss.bottomnavigation.BottomNavigation;
import com.ss.bottomnavigation.events.OnSelectedItemChangeListener;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import ir.sample.mvpsample.Categories.CategoriesFragment;
import ir.sample.mvpsample.Home.HomeFragment;
import ir.sample.mvpsample.Search.SearchFragment;
import ir.sample.mvpsample.TopNews.TopNewsFragment;

public class MainActivity extends AppCompatActivity {
    BottomNavigation bottomNavigation;
    FragmentTransaction fragmentTransaction;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setupViews();
    }

    private void setupViews() {
//Configuration HomeFragment
        callFragmentTransaction(new HomeFragment());

//Configuration BottomNavigation
        bottomNavigation=(BottomNavigation) findViewById(R.id.bottom_navigation) ;
        bottomNavigation.setDefaultItem(0);
        bottomNavigation.setOnSelectedItemChangeListener(new OnSelectedItemChangeListener() {
            @Override
            public void onSelectedItemChanged(int id) {
                switch (id) {
                    case R.id.tab_home:
                        callFragmentTransaction(new HomeFragment());
                        break;
                    case R.id.tab_search:
                        callFragmentTransaction(new SearchFragment());
                        break;
                    case R.id.tab_top_news:
                        callFragmentTransaction(new TopNewsFragment());
                        break;
                    case R.id.tab_categories:
                        callFragmentTransaction(new CategoriesFragment());
                        break;

                }
            }
        });


    }

    @Override
    public void onBackPressed() {
//When Press BackButton Then:
        if (bottomNavigation.getSelectedItem() == 0) {
            super.onBackPressed();
        } else {
            callFragmentTransaction(new HomeFragment());
            bottomNavigation.setSelectedItem(0);
        }
    }

    private void callFragmentTransaction(Fragment fragment) {
        fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.rl_main_fragmentContainer, fragment);
        fragmentTransaction.commit();
    }
}
