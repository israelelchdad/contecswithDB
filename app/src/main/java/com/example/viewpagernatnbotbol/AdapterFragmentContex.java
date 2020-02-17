package com.example.viewpagernatnbotbol;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;


public class AdapterFragmentContex extends RecyclerView.Adapter<AdapterFragmentContex.ViewHolder> {
    private LayoutInflater inflater;
    private ArrayList<Contects> mycontects;

    Context mycontext;

    public AdapterFragmentContex(Context context, ArrayList<Contects> mycontects) {
        this.mycontext = context;
        this.inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        this.mycontects = mycontects;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.item,parent,false);
        return  new ViewHolder(view);
    }



    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.setholder(mycontects.get(position));
            int a  = mycontects.size();

    }

    @Override
    public int getItemCount() {

        return mycontects.size();

    }


    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        ImageView imageView;
        TextView name;
        TextView lastname;
        Contects myOneContect;


        public ViewHolder(@NonNull View itemView)  {
            super(itemView);
            imageView = itemView.findViewById(R.id.it_img);
            name = itemView.findViewById(R.id.text1);
            lastname =  itemView.findViewById(R.id.text2);
            itemView.setOnClickListener(this);

        }
        public void setholder(Contects contects){
            myOneContect =  contects;
            imageView.setImageResource(contects.imeg);
            name.setText(contects.name);
            lastname.setText(contects.lastname);

        }

        @Override
        public void onClick(View v) {
            Intent intent = new Intent(mycontext, ActivityOneContects.class);
            intent.putExtra("key",myOneContect);
            mycontext.startActivity(intent);

        }
    }

}
