package ir.sample.mvpsample.Detail;

import android.content.Context;
import android.content.res.Resources;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.TextView;

import com.google.android.material.appbar.CollapsingToolbarLayout;
import com.squareup.picasso.Picasso;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.content.ContextCompat;
import ir.sample.mvpsample.R;

public class DetailActivity extends AppCompatActivity {
    Bundle bundle;
    String news_image, news_title, news_date, news_description;
    ImageView img_News;
    TextView txt_Title, txt_Description, txt_Date;
    Toolbar toolbar;
    CollapsingToolbarLayout collapsingToolbarLayout ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        getIntentData();
        setupViews();
    }



    private void getIntentData() {
        bundle = getIntent().getExtras();
        news_image = bundle.getString("news_image");
        news_title = bundle.getString("news_title");
        news_date = bundle.getString("news_date");
        news_description = bundle.getString("news_description");
    }
    private void setupViews() {
// findViewById of All Objects .
        collapsingToolbarLayout=(CollapsingToolbarLayout) findViewById(R.id.collapsingToolbar_detail);
        toolbar=(Toolbar) findViewById(R.id.toolbar_detail);
        img_News = (ImageView) findViewById(R.id.img_detail_imgNews);
        txt_Title =(TextView) findViewById(R.id.txt_detailContent_title);
        txt_Description =(TextView) findViewById(R.id.txt_detailContent_description);
        txt_Date =(TextView) findViewById(R.id.txt_detailContent_date);
// Set value for Objects .
        Picasso.get().load(news_image).into(img_News);
        txt_Title.setText(news_title);
        txt_Description.setText(news_description);
        txt_Date.setText(news_date);
//Toolbar Configuration
        collapsingToolbarLayout.setTitle(news_title);
        collapsingToolbarLayout.setExpandedTitleTextAppearance(R.style.custom_expanded_title);
        collapsingToolbarLayout.setCollapsedTitleTextAppearance (R.style.custom_collapsed_title);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
finish();
            }
        });

    }
}
