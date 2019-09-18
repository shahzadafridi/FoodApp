package official.com.foodapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import official.com.foodapp.Adapter.ProductAdapter;
import official.com.foodapp.Model.Product;

public class Restauranants extends AppCompatActivity {
    ListView listView;
//    List<String> items = new ArrayList<>();
    List<Product> products = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_restauranants);
        listView = (ListView) findViewById(R.id.restaurants_listview);
//        items.add("item1");
//        items.add("item2");
//        items.add("item3");
//        listView.setAdapter(new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,items));
//        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//            @Override
//            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
//                Toast.makeText(Restauranants.this,i+" Row clicked",Toast.LENGTH_SHORT).show();
//            }
//        });

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


        ProductAdapter proAadpter = new ProductAdapter(this,products);
        listView.setAdapter(proAadpter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText(Restauranants.this,products.get(i).getTitle(),Toast.LENGTH_SHORT).show();
            }
        });

    }
}
