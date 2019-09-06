package official.com.foodapp;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class Registration extends Activity implements View.OnClickListener{

    EditText username, password;
    Button register;
    String TAG = "Registration";
    SharedPreferences UserPref;
    SharedPreferences.Editor editor;

    @Override
    protected void onCreate(@Nullable Bundle savedInstce){
        super.onCreate(savedInstce);
        setContentView(R.layout.registration_activity);


        // username: shahzad password: 123 username: khan, password: khan

        username = (EditText) findViewById(R.id.register_username);
        password = (EditText) findViewById(R.id.register_password);
        register = (Button) findViewById(R.id.register);
        register.setOnClickListener(this);
        UserPref = getSharedPreferences("User", Context.MODE_PRIVATE);
        editor = UserPref.edit();


    }

    @Override
    public void onClick(View view) {
        String str_username = username.getText().toString();
        String str_password = password.getText().toString();

        if (str_username.equals("") && str_password.equals("")){
            Log.e(TAG,"Please enter username and password");
            Toast.makeText(Registration.this,"Please enter username and passsword",Toast.LENGTH_SHORT).show();
        }else {
            editor.putString("uname",str_username);
            editor.putString("upass",str_password);
            editor.commit();
            Log.d(TAG,"User successfully register");
        }
    }
}
