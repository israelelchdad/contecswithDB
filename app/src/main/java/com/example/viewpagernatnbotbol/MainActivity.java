package com.example.viewpagernatnbotbol;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;
import android.widget.TableLayout;

import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ViewPager myviewpajer;
    AdapterViewPager myadapterviewpager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        myviewpajer  = findViewById(R.id.ma_vp);
        myadapterviewpager = new AdapterViewPager(getSupportFragmentManager(),areyfragment());
        myviewpajer.setAdapter(myadapterviewpager);
        TabLayout tabLayout = findViewById(R.id.tab_layout);
        tabLayout.setupWithViewPager(myviewpajer);

//          MycontectsFragment mcf =new MycontectsFragment();
//                getSupportFragmentManager().beginTransaction().add(R.id.ma_fl,mcf).commit();
//

    }
    public ArrayList<MycontectsFragment> areyfragment(){
        ArrayList<MycontectsFragment> mylistfragment = new ArrayList<>();
        mylistfragment.add(MycontectsFragment.newinstance(true));
        mylistfragment.add(MycontectsFragment.newinstance(false));

        return mylistfragment;
    }
}
