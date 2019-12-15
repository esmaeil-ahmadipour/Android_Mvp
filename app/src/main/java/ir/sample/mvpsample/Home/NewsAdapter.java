package ir.sample.mvpsample.Home;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;
import ir.sample.mvpsample.Data.News;
import ir.sample.mvpsample.Detail.DetailActivity;
import ir.sample.mvpsample.R;

public class NewsAdapter extends RecyclerView.Adapter<NewsAdapter.NewsViewHolder> {
    List<News> newsList;
    Context mContext;

//Create Constructor for Get List of data.
    public NewsAdapter(List<News> newsList) {
//Get Data.
        this.newsList = newsList;
    }

    @NonNull
    @Override
    public NewsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
// Prepare RecyclerView for Create ViewHolder .
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_news_rows, parent, false);
        return new NewsViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull NewsViewHolder holder, int position) {
        final News news = newsList.get(position);
//Set Any NewsData in All Item Of RecyclerView .
        holder.txt_title.setText(news.getTitle());
        holder.txt_date.setText(news.getDate());
        Picasso.get().load(news.getImage()).into(holder.img_icon);

        holder.cvParent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(mContext, DetailActivity.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                intent.putExtra("news_image", news.getImage());
                intent.putExtra("news_title", news.getTitle());
                intent.putExtra("news_date", news.getDate());
                intent.putExtra("news_description", news.getDescription());
                mContext.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
//Detect Qty News in NewsList.
        return newsList.size();
    }

//Define RecyclerView .
    public class NewsViewHolder extends RecyclerView.ViewHolder {
        CardView cvParent;
        TextView txt_title;
        TextView txt_date;
        ImageView img_icon;

        public NewsViewHolder(@NonNull final View itemView) {
            super(itemView);
            txt_title = (TextView) itemView.findViewById(R.id.txt_newsRows_title);
            txt_date = (TextView) itemView.findViewById(R.id.txt_newsRows_date);
            img_icon = (ImageView) itemView.findViewById(R.id.img_newsRows_icon);
            cvParent = (CardView) itemView.findViewById(R.id.card_newsRows_parent);
            mContext = itemView.getContext();

        }
    }
}
