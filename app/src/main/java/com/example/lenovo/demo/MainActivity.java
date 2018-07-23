package com.example.lenovo.demo;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.bumptech.glide.Glide;
import com.example.lenovo.demo.view.IView;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements IView{

    private ViewPager mViewPager = null;
    private TabLayout mTabLayout = null;
    private FragmentAdapter adapter = null;
    private List fragments = new ArrayList();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        mViewPager = findViewById(R.id.view_pager);
        mTabLayout = findViewById(R.id.tab);
        ContentFragment fragment1 = new ContentFragment();
        ContentFragment fragment2 = new ContentFragment();
        ContentFragment fragment3 = new ContentFragment();
        fragments.add(fragment1);
        fragments.add(fragment2);
        fragments.add(fragment3);


        adapter = new FragmentAdapter(getSupportFragmentManager(),fragments);
        mViewPager.setAdapter(adapter);
        mTabLayout.setupWithViewPager(mViewPager);
        new FontUtil(this.getApplicationContext()).initFont();
    }

    @Override
    public void showLoading() {

    }

    @Override
    public void hideLoading() {

    }

    @Override
    public void progress(int id) {

    }
}
