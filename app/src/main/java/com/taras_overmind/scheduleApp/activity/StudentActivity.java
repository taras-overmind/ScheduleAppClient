package com.taras_overmind.scheduleApp.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager2.widget.ViewPager2;

import android.os.Bundle;

import com.google.android.material.tabs.TabLayout;
import com.taras_overmind.scheduleApp.R;
import com.taras_overmind.scheduleApp.adapter.StudentViewPagerAdapter;

public class StudentActivity extends AppCompatActivity {

    TabLayout tabLayout;
    ViewPager2 viewPager2;
    StudentViewPagerAdapter viewPagerAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

//       getSupportActionBar().setDefaultDisplayHomeAsUpEnabled(true);

        setContentView(R.layout.activity_student);
        tabLayout= findViewById(R.id.tabLayout);
        viewPager2=findViewById(R.id.viewPager);
        viewPagerAdapter=new StudentViewPagerAdapter(this);
        viewPager2.setAdapter(viewPagerAdapter);
        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPager2.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
        viewPager2.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {
            @Override
            public void onPageSelected(int position) {
                super.onPageSelected(position);
                tabLayout.getTabAt(position).select();
            }
        });
    }
}