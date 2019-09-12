package official.com.foodapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import official.com.foodapp.SQLite.SQLiteAdapter;

public class MenuActivity extends AppCompatActivity {

    SharedPreferences UserPref;
    SharedPreferences.Editor UserPrefEditor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
        String getMessage = getIntent().getStringExtra("message");
        Toast.makeText(MenuActivity.this,getMessage,Toast.LENGTH_SHORT).show();
        UserPref = getSharedPreferences("User",MODE_PRIVATE);
        UserPrefEditor = UserPref.edit();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();


        if (id == R.id.item_logout){
            UserPrefEditor.putBoolean("isLogin",false);
            UserPrefEditor.commit();
            Intent intent = new Intent(MenuActivity.this,MainActivity.class);
            startActivity(intent);
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void insert(View view) {
        SQLiteAdapter adapter = new SQLiteAdapter(MenuActivity.this);
        adapter.insertUser(2,"shahzad","23","2897128","dosaifjajdlsa");
    }
}
