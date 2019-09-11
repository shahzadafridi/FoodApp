package official.com.foodapp;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity{

    EditText username,password;
    Button login,signup;
    TextView textView;
    String TAG = "MainActivity";
    SharedPreferences UserPref;
    SharedPreferences.Editor UserPrefEditor;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.linear_layout);
        Log.e(TAG, "onCreate");
        username = (EditText) findViewById(R.id.username);
        password = (EditText) findViewById(R.id.password);
        login = (Button) findViewById(R.id.login);
        signup = (Button) findViewById(R.id.signup);
        textView = (TextView) findViewById(R.id.textview);
        UserPref = getSharedPreferences("User",MODE_PRIVATE);
        UserPrefEditor = UserPref.edit();
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String str_usernam = username.getText().toString();
                String str_password = password.getText().toString();
                String username_shredpref = UserPref.getString("uname","null");
                String password_shredpref = UserPref.getString("upass","null");
                if (str_usernam.equals(username_shredpref) && str_password.equals(password_shredpref)){
                    Toast.makeText(MainActivity.this,"User successfully login",Toast.LENGTH_SHORT).show();
                    textView.setText("User succesfully login in.");
                    UserPrefEditor.putBoolean("isLogin",true);
                    UserPrefEditor.commit();

                }else {
                    textView.setText("Invalid credential.");
                }
            }
        });
        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this,Registration.class);
                startActivity(intent);
            }
        });

    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.e(TAG, "onStart");
        UserPref = getSharedPreferences("User",MODE_PRIVATE);
        boolean isLogin = UserPref.getBoolean("isLogin",false);
        if (isLogin){
            Intent intent = new Intent(MainActivity.this, MenuActivity.class);
            intent.putExtra("message","Hello this is shahzad afridi");
            startActivity(intent);
        }
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.e(TAG, "onPause");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.e(TAG, "onResume");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.e(TAG, "onRestart");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.e(TAG, "onDestroy");
    }
}