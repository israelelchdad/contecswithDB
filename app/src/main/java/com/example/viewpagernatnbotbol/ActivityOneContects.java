package com.example.viewpagernatnbotbol;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Switch;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class ActivityOneContects extends AppCompatActivity implements View.OnClickListener {
   private Contects myContects;
   private Button add;
   private Button remove;
   private TextView rating;
   private ArrayList<Contects> myListContects;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_one_contects);
        Intent intent = getIntent();
         myContects = intent.getParcelableExtra("key");
         initcontects();
         String name = myContects.name;
        String namee = myContects.name;
    }

    private void initcontects() {
        ImageView imageView = findViewById(R.id.Ca_imeg);
        ImageView uprating = findViewById(R.id.ac_up);
        uprating.setOnClickListener(this);
        ImageView down = findViewById(R.id.ac_down);
        down.setOnClickListener(this);
        TextView name = findViewById(R.id.ac_name);
        TextView lastname = findViewById(R.id.ac_lastname);
        TextView job = findViewById(R.id.ac_job);
         rating =findViewById(R.id.ac_rating);
        add =  findViewById(R.id.ac_badd);
        add.setOnClickListener(this);
        remove= findViewById(R.id.ac_remov);
        remove.setOnClickListener(this);
        if(myContects.isfavorite==true){
            add.setVisibility(View.GONE);
        }else {
            remove.setVisibility(View.GONE);

        }
        imageView.setImageResource(myContects.getImeg());
        name.setText("name :"+myContects.getName());
        lastname.setText("lastname :"+myContects.getLastname());
        job.setText("job :"+myContects.getJob());
        rating.setText("rating :"+myContects.getRating());
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.ac_badd:
                myContects.setIsfavorite(true);
                add.setVisibility(View.GONE);
                remove.setVisibility(View.VISIBLE);
                break;
            case R.id.ac_remov:
                myContects.setIsfavorite(false);
                add.setVisibility(View.VISIBLE);
                remove.setVisibility(View.GONE);
                break;
            case R.id.ac_up:
//                int ratingg= myContects.getRating();
//                ratingg++;
                myContects.setRating(myContects.getRating()+1);
                rating.setText("rating :"+myContects.getRating());
                break;
            case R.id.ac_down:
//                int ratinggg= myContects.getRating();
//                ratinggg++;
                myContects.setRating(myContects.getRating()-1);
                rating.setText("rating :"+myContects.getRating());
                break;




        }
    }

    @Override
    protected void onPause() {
        super.onPause();
        myListContects =(ArrayList<Contects>) AppDataBase.getINSTANCE(this).myDeoContects().getallcontects();
        if(myListContects.size()>0){
            for (int i = 0; i <myListContects.size() ; i++) {
                if(myListContects.get(i).getName().equals(myContects.getName())){
                    myListContects.get(i).setRating(myContects.getRating());
                    myListContects.get(i).setIsfavorite(myContects.isIsfavorite());

                }


            }
            AppDataBase.getINSTANCE(this).myDeoContects().deletallcntects();
            AppDataBase.getINSTANCE(this).myDeoContects().inserallcontects((List<Contects>) myListContects);
        }


    }
}
