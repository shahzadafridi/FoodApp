package official.com.foodapp.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

import official.com.foodapp.Model.Product;
import official.com.foodapp.R;

public class ProductAdapter extends BaseAdapter {
    Context context;
    List<Product> products;

    public ProductAdapter(Context mContext, List<Product> mProducts){
        context = mContext;
        products = mProducts;
    }

    @Override
    public int getCount() {
        return products.size();
    }

    @Override
    public Object getItem(int i) {
        return i;
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        Product pro = products.get(i);
        View procut_view = LayoutInflater.from(context).inflate(R.layout.custom_product_layout,null);
        TextView title = procut_view.findViewById(R.id.prodcut_title);
        TextView category = procut_view.findViewById(R.id.prodcut_category);
        TextView price = procut_view.findViewById(R.id.prodcut_price);
        TextView rating = procut_view.findViewById(R.id.prodcut_rating);
        title.setText(pro.getTitle());
        category.setText(pro.getCategory());
        price.setText(pro.getPrice());
        rating.setText(pro.getRatting());
        return procut_view;
    }
}
