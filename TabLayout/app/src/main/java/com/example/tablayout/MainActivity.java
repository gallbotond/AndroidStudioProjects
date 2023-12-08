package com.example.tablayout;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;

import com.google.android.material.tabs.TabItem;
import com.google.android.material.tabs.TabLayout;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TabLayout tabLayout=findViewById(R.id.tabLayout);
        TabItem tabChats=findViewById(R.id.tabChats);
        TabItem tabCalls=findViewById(R.id.tabCalls);
        TabItem tabProfile=findViewById(R.id.tabProfile);

        ViewPager viewPager = findViewById(R.id.viewPager);

        MyPagerAdapter myPagerAdapter = new MyPagerAdapter(getSupportFragmentManager(), tabLayout.getTabCount());
        viewPager.setAdapter(myPagerAdapter);

        tabLayout.setupWithViewPager(viewPager);
    }
}