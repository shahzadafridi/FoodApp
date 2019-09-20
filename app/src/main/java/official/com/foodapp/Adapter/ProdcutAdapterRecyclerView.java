package official.com.foodapp.Adapter;

import android.content.Context;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import official.com.foodapp.Model.Product;
import official.com.foodapp.R;

public class ProdcutAdapterRecyclerView extends RecyclerView.Adapter<ProdcutAdapterRecyclerView.MyViewHolder> {

    Context context;
    List<Product> products;

    public ProdcutAdapterRecyclerView(Context context, List<Product> products) {
        this.context = context;
        this.products = products;
    }

    @NonNull
    @Override
    public ProdcutAdapterRecyclerView.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.custom_product_layout, parent, false);
        ProdcutAdapterRecyclerView.MyViewHolder myViewHolder = new ProdcutAdapterRecyclerView.MyViewHolder(view);
        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ProdcutAdapterRecyclerView.MyViewHolder holder, int position) {
        Product product = products.get(position);
        holder.title.setText(product.getTitle());
        holder.category.setText(product.getCategory());
        holder.price.setText(product.getPrice());
        holder.rating.setText(product.getRatting());
    }

    @Override
    public int getItemCount() {
        return products.size();
    }


    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView title, category, rating, price;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            title = itemView.findViewById(R.id.prodcut_title);
            category = itemView.findViewById(R.id.prodcut_category);
            rating = itemView.findViewById(R.id.prodcut_rating);
            price = itemView.findViewById(R.id.prodcut_price);
        }
    }
}
