package com.example.admin.rtr.General;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;

import com.example.admin.rtr.R;

public class Contactus extends AppCompatActivity
{
    EditText editTextname,editTextsubject,editTextemail,editTextphone,editTextmessage;
    Button button1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_contactus);
        if (android.os.Build.VERSION.SDK_INT >= 21) {
            Window statusBar = getWindow();
            statusBar.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            statusBar.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
            statusBar.setStatusBarColor(ContextCompat.getColor(this, R.color.appbar));
        }
        final ActionBar actionar = getSupportActionBar();
        actionar.setDisplayHomeAsUpEnabled(true);
        actionar.setDisplayShowHomeEnabled(true);
        actionar.setBackgroundDrawable(new ColorDrawable(Color.parseColor("#494949")));
        actionar.setTitle("ContactUs");

        editTextname=(EditText)findViewById(R.id.editText1);
        editTextsubject=(EditText)findViewById(R.id.editText2);
        editTextemail=(EditText)findViewById(R.id.editText3);
        editTextphone=(EditText)findViewById(R.id.editText4);
        editTextmessage=(EditText)findViewById(R.id.editText5);
        button1=(Button)findViewById(R.id.button1);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                String to="gandhivraj@gmail.com";
                String subject=editTextsubject.getText().toString();
                String name=editTextname.getText().toString();
                String phone=editTextphone.getText().toString();
                String msg=editTextmessage.getText().toString();
                String message=name+"/n"+""+phone+"/n"+""+msg;

                Intent email = new Intent(Intent.ACTION_SEND);
                email.putExtra(Intent.EXTRA_EMAIL, new String[]{ to});
                //email.putExtra(Intent.EXTRA_CC, new String[]{ to});
                //email.putExtra(Intent.EXTRA_BCC, new String[]{to});
                email.putExtra(Intent.EXTRA_SUBJECT, subject);
                email.putExtra(Intent.EXTRA_TEXT, message);

                //need this to prompts email client only
                email.setType("message/rfc822");

                startActivity(Intent.createChooser(email, editTextemail.getText().toString()));
            }
        });


    }
    public boolean onOptionsItemSelected(MenuItem item)
    {

        int id = item.getItemId();
        if (id == android.R.id.home)
        {
            this.finish();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
