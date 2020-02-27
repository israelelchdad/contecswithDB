package com.example.viewpagernatnbotbol;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;
import android.widget.SearchView;
import android.widget.TableLayout;

import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ViewPager myviewpajer;
    AdapterViewPager myadapterviewpager;
    MycontectsFragment mycontectsFragmentTrue = MycontectsFragment.newinstance(true);
    MycontectsFragment mycontectsFragmentFalse = MycontectsFragment.newinstance(false);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        myviewpajer  = findViewById(R.id.ma_vp);
//        myadapterviewpager = new AdapterViewPager(getSupportFragmentManager(),areyfragment());
//        myviewpajer.setAdapter(myadapterviewpager);
//        TabLayout tabLayout = findViewById(R.id.tab_layout);
//        tabLayout.setupWithViewPager(myviewpajer);
//        initSerchMen();



    }

    @Override
    protected void onResume() {
       super.onResume();
        myviewpajer  = findViewById(R.id.ma_vp);
        myadapterviewpager = new AdapterViewPager(getSupportFragmentManager(),areyfragment());
        myviewpajer.setAdapter(myadapterviewpager);
        TabLayout tabLayout = findViewById(R.id.tab_layout);
        tabLayout.setupWithViewPager(myviewpajer);
        initSerchMen();

    }

    private void initSerchMen() {
        SearchView serchMen = findViewById(R.id.ma_serce_SV);
        serchMen.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                mycontectsFragmentTrue.myAdapter.getFilter().filter(newText);
                mycontectsFragmentFalse.myAdapter.getFilter().filter(newText);
                return true;
            }
        });

    }

    public ArrayList<MycontectsFragment> areyfragment(){
        ArrayList<MycontectsFragment> mylistfragment = new ArrayList<>();
        mylistfragment.add(mycontectsFragmentTrue);
        mylistfragment.add(mycontectsFragmentFalse);

        return mylistfragment;
    }
}
