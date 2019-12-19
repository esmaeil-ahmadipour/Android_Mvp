package ir.sample.mvpsample.Categories;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import ir.sample.mvpsample.Data.Categories;
import ir.sample.mvpsample.R;

public class CategoriesAdapter extends RecyclerView.Adapter<CategoriesAdapter.CategoriesViewHolder> {
    List<Categories> categoriesList;

    public CategoriesAdapter(List<Categories> categoriesList) {
        this.categoriesList = categoriesList;
    }

    @NonNull
    @Override
    public CategoriesViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_categories_rows, parent, false);
        return new CategoriesViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CategoriesViewHolder holder, int position) {
    Categories categories = categoriesList.get(position);
    holder.txt_title.setText(categories.getTitle());
    }

    @Override
    public int getItemCount() {
        return categoriesList.size();
    }

    public class CategoriesViewHolder extends RecyclerView.ViewHolder {
        private TextView txt_title;

        public CategoriesViewHolder(@NonNull View itemView) {
            super(itemView);
            txt_title = (TextView) itemView.findViewById(R.id.txt_categoriesRow_title);
        }
    }
}
