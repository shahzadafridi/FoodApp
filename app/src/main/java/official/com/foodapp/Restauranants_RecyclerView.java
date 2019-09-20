package official.com.foodapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

import official.com.foodapp.Adapter.ProdcutAdapterRecyclerView;
import official.com.foodapp.Model.Product;

public class Restauranants_RecyclerView extends AppCompatActivity {

    RecyclerView recyclerView;
    List<Product> products = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_restauranants__recycler_view);
        recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        // Product 1
        Product p1 = new Product();
        p1.setTitle("Chicken Burger");
        p1.setCategory("Fast food");
        p1.setPrice("150");
        p1.setRatting(" 4.5");
        products.add(p1);

        // Product 2
        Product p2 = new Product();
        p2.setTitle("Meat Burger");
        p2.setCategory("Fast food");
        p2.setPrice("250");
        p2.setRatting(" 3.5");
        products.add(p2);

        // Product 3
        Product p3 = new Product();
        p3.setTitle("Vegitable Burger");
        p3.setCategory("Fast food");
        p3.setPrice("100");
        p3.setRatting(" 2.5");
        products.add(p3);

        ProdcutAdapterRecyclerView adapterRecyclerView = new ProdcutAdapterRecyclerView(this,products);
        recyclerView.setAdapter(adapterRecyclerView);
    }
}
