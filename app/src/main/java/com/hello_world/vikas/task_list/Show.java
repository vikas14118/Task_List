package com.hello_world.vikas.task_list;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;

import java.util.ArrayList;

public class Show extends AppCompatActivity {

    int pos;
    private ViewPager pager;
    ArrayList<Item> list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show);
        pager = (ViewPager) findViewById(R.id.viewpager);
        pos = getIntent().getIntExtra("position",0);

        Toolbar toolbar = (Toolbar)findViewById(R.id.tooltool);

        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        Log.i("vikas",pos+"");
        FragmentManager manager = getSupportFragmentManager();
        Log.i("vikas","coming2");
        vikasmanager man = vikasmanager.get();
        list = man.getList();
        Log.i("vikas",""+list.size());
        pager.setAdapter(new FragmentStatePagerAdapter(manager) {
            @Override
            public Fragment getItem(int position) {
                Log.i("vikas","coming");
                vikasmanager  man = vikasmanager.get();
                list = man.getList();
                fragmentClass fragment = fragmentClass.instance(list, position);
                return fragment;
            }

            @Override
            public int getCount()
            {
                return list.size();
            }
        });
        if(list != null)
            pager.setCurrentItem(pos);
    }
}
