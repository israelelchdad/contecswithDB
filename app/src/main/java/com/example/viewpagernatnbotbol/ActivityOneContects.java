package com.example.viewpagernatnbotbol;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class ActivityOneContects extends AppCompatActivity {
    Contects myContects;
    Button add;
    Button remove;

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
        TextView name = findViewById(R.id.ac_name);
        TextView lastname = findViewById(R.id.ac_lastname);
        TextView job = findViewById(R.id.ac_job);
        add =  findViewById(R.id.ac_badd);
        remove= findViewById(R.id.ac_remov);
        if(myContects.isfavorite==true){
            add.setVisibility(View.GONE);
        }else {
            remove.setVisibility(View.GONE);

        }
        imageView.setImageResource(myContects.getImeg());
        name.setText(myContects.getName());
        lastname.setText(myContects.getLastname());
        job.setText(myContects.getJob());


    }
}
