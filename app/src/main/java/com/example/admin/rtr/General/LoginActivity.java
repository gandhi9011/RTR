package com.example.admin.rtr.General;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.TextInputEditText;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;

import com.example.admin.rtr.R;
import com.example.admin.rtr.activity.MainActivity;

public class LoginActivity extends AppCompatActivity {

    TextInputEditText username;
    TextView forgotpassword;
    CheckBox savepassword;
    Button btnlogin;
    TextInputEditText etpassword;
    TextInputLayout etPasswordLayout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        getSupportActionBar().hide();
        username=(TextInputEditText)findViewById(R.id.username);
        etpassword=(TextInputEditText)findViewById(R.id.etPassword);
        etPasswordLayout=(TextInputLayout)findViewById(R.id.etPasswordLayout);
        savepassword=(CheckBox)findViewById(R.id.savepassword);
        forgotpassword=(TextView)findViewById(R.id.forgotpassword);
        btnlogin=(Button)findViewById(R.id.btnlogin);
        btnlogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
            startActivity(new Intent(getApplicationContext(), MainActivity.class));
            }
        });
       }
}
