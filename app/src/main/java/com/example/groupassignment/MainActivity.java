package com.example.groupassignment;
//github token
//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
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.material.button.MaterialButton;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    EditText username;
    EditText password;
    String p, u;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        UserData myUserData = UserData.getInstance();

        username = (EditText) findViewById(R.id.username);
        password = (EditText) findViewById(R.id.password);

        MaterialButton login = (MaterialButton) findViewById(R.id.loginbutton);
        login.setOnClickListener(this);
        MaterialButton register = (MaterialButton) findViewById(R.id.registerbutton);
        register.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        UserData myUserData = UserData.getInstance();
        switch (view.getId()) {
            case R.id.loginbutton:
                //finduser
                p=password.getText().toString();
                u=username.getText().toString();
                if(myUserData.findUser(u,p)){
                    //home interface
                    startActivity(new Intent(MainActivity.this, HomeActivity.class));
                }
                else{
                    Toast.makeText(MainActivity.this, "Username or password is incorrect!", Toast.LENGTH_SHORT).show();
                }

                break;
            case R.id.registerbutton:
                //Interface for registration
                startActivity(new Intent(MainActivity.this, RegisterActivity.class));
                break;
            default:
                break;
        }
    }
}