package com.example.admin.rtr.activity;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.text.format.DateUtils;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.Window;
import android.view.WindowManager;
import android.widget.FrameLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.admin.rtr.Adapter.RecyclerAdapter;
import com.example.admin.rtr.Agent_Queue.ResultsFragmentsN;
import com.example.admin.rtr.Desktop_wallboard.ResultsFragments;
import com.example.admin.rtr.General.Contactus;
import com.example.admin.rtr.ItemDetail.Detail;
import com.example.admin.rtr.Notification.NotificationService;
import com.example.admin.rtr.R;
import com.example.admin.rtr.SubTitle.SubTitle;
import com.example.admin.rtr.Title.TitleFragment;
import com.example.admin.rtr.Title.TitleMenu;
import com.thoughtbot.expandablerecyclerview.models.ExpandableGroup;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity implements RecyclerAdapter.ItemClickChild {

    @BindView(R.id.recyclerView)
    RecyclerView recyclerView;
    @BindView(R.id.nav_view)
    NavigationView navView;
    @BindView(R.id.drawer_layout)
    DrawerLayout drawerLayout;

    String names[] = Detail.name;
    String subNames1[] = Detail.subName1;
    String subNames3[] = Detail.subName3;
    int subImg1[] = Detail.subImage1;
    int subImg3[] = Detail.subImage3;
    @BindView(R.id.toolbar)
    Toolbar toolbar;

    @BindView(R.id.frame)
    FrameLayout frame;

    TitleFragment fragment;
    android.support.v4.app.FragmentManager fragmentManager;
    android.support.v4.app.FragmentTransaction transaction;

    private boolean isChecked = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        if (android.os.Build.VERSION.SDK_INT >= 21) {
            Window statusBar = getWindow();
            statusBar.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            statusBar.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
            statusBar.setStatusBarColor(ContextCompat.getColor(this, R.color.appbar));
        }


        TextView textView = (TextView) findViewById(R.id.datetime);
        textView.setText(DateUtils.formatDateTime(this, System.currentTimeMillis(), DateUtils.FORMAT_SHOW_TIME | DateUtils.FORMAT_SHOW_DATE | DateUtils.FORMAT_NUMERIC_DATE | DateUtils.FORMAT_12HOUR));


//        setSupportActionBar(toolbar);
        final ActionBar actionar = getSupportActionBar();
        actionar.setDisplayHomeAsUpEnabled(true);
        actionar.setHomeAsUpIndicator(R.mipmap.bct_logo);
        actionar.setBackgroundDrawable(new ColorDrawable(Color.parseColor("#494949")));

        List<TitleMenu> list = getList();
        RecyclerAdapter adapter = new RecyclerAdapter(this, list, this);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter);
        recyclerView.addItemDecoration(new DividerItemDecoration(this, LinearLayoutManager.VERTICAL));
        recyclerView.setAdapter(adapter);


        setFragment();




    }

    private void setFragment() {
        fragmentManager = getSupportFragmentManager();
        transaction = fragmentManager.beginTransaction();
        fragment = new TitleFragment();
        transaction.replace(R.id.frame,fragment, "TitleFragment").commit();
    }

    private List<TitleMenu> getList() {
        List<TitleMenu> list = new ArrayList<>();
        for (int i = 0; i < names.length; i++) {
            if (i == 0) {
                List<SubTitle> subTitles = new ArrayList<>();
                for (int j = 0; j < subNames1.length; j++) {
                    SubTitle subTitle1 = new SubTitle(subNames1[j], subImg1[j]);
                    subTitles.add(subTitle1);
                }
                TitleMenu model = new TitleMenu(names[i], subTitles, null);
                list.add(model);
            } else


            {
                List<SubTitle> subTitles = new ArrayList<>();
                for (int j = 0; j < subNames3.length; j++) {
                    SubTitle subTitle3 = new SubTitle(subNames3[j], subImg3[j]);
                    subTitles.add(subTitle3);
                }
                TitleMenu model = new TitleMenu(names[i], subTitles, null);
                list.add(model);
            }
        }
        return list;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int id = item.getItemId();
        if (id == android.R.id.home)
        {
            drawerLayout.openDrawer(GravityCompat.START);
            return true;
        }
        if (id==R.id.action_home)
        {
            setFragment();
            getSupportActionBar().setTitle("RTR");
        }
        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings)
        {
            return true;
        }
        if (id==R.id.checkable_menu) {
            isChecked = !item.isChecked();
            item.setChecked(isChecked);
            Log.e("notification status",""+isChecked);
            if (isChecked)
            {
            startService(new Intent(this, NotificationService.class));
            }
            else
            {
             stopService(new Intent(this,NotificationService.class));
            }
            return true;
        }

        if (id == R.id.action_contactus)
        {

            startActivity(new Intent(this, Contactus.class));
        }


        if (id == R.id.action_aboutus)
        {
            fragmentManager = getSupportFragmentManager();
            transaction = fragmentManager.beginTransaction();
            fragment = new TitleFragment();
            transaction.replace(R.id.frame, fragment, "TitleFragment").commit();
        }


        if (id == R.id.action_help)
        {
            fragmentManager = getSupportFragmentManager();
            transaction = fragmentManager.beginTransaction();
            fragment = new TitleFragment();
            transaction.replace(R.id.frame, fragment, "TitleFragment").commit();
        }


        return super.onOptionsItemSelected(item);


    }

    @Override
    public void onChildClick(int position, ExpandableGroup group) {
        if (group.getTitle().equals("Report")) {
            String name = subNames1[position];
            drawerLayout.closeDrawers();
            if (name.equals("Agent/Queue"))
            {
                Toast.makeText(this, name, Toast.LENGTH_SHORT).show();
                fragmentManager = getSupportFragmentManager();
                transaction = fragmentManager.beginTransaction();
                transaction.replace(R.id.frame, new ResultsFragmentsN(), "ResultsFragmentAgentQueue");
                transaction.commit();
            }
            if (name.equals("Desktop Wallboard"))
            {
                Toast.makeText(this, name, Toast.LENGTH_SHORT).show();
                fragmentManager = getSupportFragmentManager();
                transaction = fragmentManager.beginTransaction();
                transaction.replace(R.id.frame, new ResultsFragments(), "ResultsFragmentDesktop");
                transaction.commit();
            }

            if (name.equals("Historic Call List"))
            {
                Toast.makeText(this, name, Toast.LENGTH_SHORT).show();
                fragmentManager = getSupportFragmentManager();
                transaction = fragmentManager.beginTransaction();
                transaction.replace(R.id.frame,  new com.example.admin.rtr.Historic_Call.ResultsFragments() , "ResultsFragmentHistoric");
                transaction.commit();
            }
            if (name.equals("Unreturned Lost Call"))
            {
                Toast.makeText(this, name, Toast.LENGTH_SHORT).show();
                fragmentManager = getSupportFragmentManager();
                transaction = fragmentManager.beginTransaction();
                transaction.replace(R.id.frame, new com.example.admin.rtr.Unreturn_Calls.ResultsFragments(), "ResultsFragmentUnreturn");
                transaction.commit();
            }


        } else if (group.getTitle().equals("Calls")) {
            String name = subNames3[position];
            drawerLayout.closeDrawers();
            if (name.equals("Calls By Month"))
            {
                Toast.makeText(this, name, Toast.LENGTH_SHORT).show();
                fragmentManager = getSupportFragmentManager();
                transaction = fragmentManager.beginTransaction();
                transaction.replace(R.id.frame,  new com.example.admin.rtr.Call_by_Month.ResultsFragments(), "ResultsFragmentCallbyMonth");
                transaction.commit();
            }
            if (name.equals("Calls By ½ Hour"))
            {
                Toast.makeText(this, name, Toast.LENGTH_SHORT).show();
                fragmentManager = getSupportFragmentManager();
                transaction = fragmentManager.beginTransaction();
                transaction.replace(R.id.frame, new com.example.admin.rtr.Call_by_Half_n_Hour.ResultsFragments(), "ResultsFragmentCallbyhalfnhour");
                transaction.commit();
            }

        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        MenuItem checkable = menu.findItem(R.id.checkable_menu);
        checkable.setChecked(isChecked);



        return true;
    }
    public void setActionBarTitle(String title){
        getSupportActionBar().setTitle(title);
    }





}
