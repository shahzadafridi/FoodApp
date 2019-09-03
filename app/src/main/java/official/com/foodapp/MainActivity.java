package official.com.foodapp;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity{

    EditText username,password;
    Button login;
    TextView textView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.linear_layout);

        username = (EditText) findViewById(R.id.username);
        password = (EditText) findViewById(R.id.password);
        login = (Button) findViewById(R.id.login);
        textView = (TextView) findViewById(R.id.textview);
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String str_usernam = username.getText().toString();
                String str_password = password.getText().toString();
                if (str_usernam.equals("admin") && str_password.equals("admin")){
                    textView.setText("User succesfully login in");
                }else {
                    textView.setText("Invalid credential.");
                }
            }
        });

    }
}