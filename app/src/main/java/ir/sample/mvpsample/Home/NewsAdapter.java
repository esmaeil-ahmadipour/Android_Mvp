package ir.sample.mvpsample.Home;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.squareup.picasso.Picasso;
import java.util.List;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import ir.sample.mvpsample.Data.News;
import ir.sample.mvpsample.R;

public class NewsAdapter extends RecyclerView.Adapter<NewsAdapter.NewsViewHolder> {
    List<News> newsList;

    //Create Constructor for Get List of data.
    public NewsAdapter(List<News> newsList) {
        //Get Data.
        this.newsList = newsList;
    }

    @NonNull
    @Override
    public NewsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        // Prepare RecyclerView for Create ViewHolder .
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.news_rows_layout, parent, false);
        return new NewsViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull NewsViewHolder holder, int position) {
        News news = newsList.get(position);
        //Set Any NewsData in All Item Of RecyclerView .
        holder.txt_title.setText(news.getTitle());
        holder.txt_date.setText(news.getDate());
        Picasso.get().load(news.getImage()).into(holder.img_icon);
    }

    @Override
    public int getItemCount() {
        //Detect Qty News in NewsList.
        return newsList.size();
    }

    //Define RecyclerView .
    public class NewsViewHolder extends RecyclerView.ViewHolder {
        TextView txt_title;
        TextView txt_date;
        ImageView img_icon;
        public NewsViewHolder(@NonNull View itemView) {
            super(itemView);
            txt_title = (TextView) itemView.findViewById(R.id.txt_newsRows_title);
            txt_date = (TextView) itemView.findViewById(R.id.txt_newsRows_date);
            img_icon = (ImageView) itemView.findViewById(R.id.img_newsRows_icon);

        }
    }
}
