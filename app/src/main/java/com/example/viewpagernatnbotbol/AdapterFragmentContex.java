package com.example.viewpagernatnbotbol;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;


public class AdapterFragmentContex extends RecyclerView.Adapter<AdapterFragmentContex.ViewHolder> implements Filterable {
    private LayoutInflater inflater;
    private ArrayList<Contects> mycontects;
    private ArrayList<Contects> mylistFilterContects = new ArrayList<>();
    Context mycontext;
//    public  contectsFilter mycontecsFilter ;

    public AdapterFragmentContex(Context context, ArrayList<Contects> mycontects) {
        this.mycontext = context;
        this.inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        this.mycontects = mycontects;
        this.mylistFilterContects.addAll(mycontects);
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.item,parent,false);
        return  new ViewHolder(view);
    }



    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.setholder(mylistFilterContects.get(position));
            int a  = mylistFilterContects.size();

    }

    @Override
    public int getItemCount() {

        return mylistFilterContects.size();

    }

    @Override
    public Filter getFilter() {
//        mycontecsFilter = new contectsFilter();
//        return mycontecsFilter;

        // CREAT FILTER OF SERCHVIEW ANONIMI
        return new Filter() {
            @Override
            protected FilterResults performFiltering(CharSequence constraint) {
                FilterResults results = new FilterResults();
                ArrayList<Contects> listFilterAllContects = new ArrayList<>();
               mylistFilterContects.clear();
                for (Contects myContectsOne : mycontects) {
                    if (myContectsOne.getName().toLowerCase().contains(constraint.toString().toLowerCase())) {
                        listFilterAllContects.add(myContectsOne);
                    }

                }
                results.values = listFilterAllContects;
                results.count = listFilterAllContects.size();
                return results;
            }


            @Override
            protected void publishResults(CharSequence constraint, FilterResults results) {
                mylistFilterContects =(ArrayList<Contects>) results.values;
                notifyDataSetChanged();


            }
        };
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
    //Creat filter of serchview by inner claes extens filter
//    public class contectsFilter extends Filter{
//
//        @Override
//        protected FilterResults performFiltering(CharSequence constraint) {
//            FilterResults results = new FilterResults();
//            ArrayList<Contects> listFilterAllContects = new ArrayList<>();
//            for (Contects myContectsOne: mycontects) {
//                if (myContectsOne.getName().toLowerCase().contains(constraint.toString().toLowerCase())){
//                    listFilterAllContects.add(myContectsOne);
//                }
//
//            }
//            results.values = listFilterAllContects;
//            results.count = listFilterAllContects.size();
//            return results;
//        }
//
//        @Override
//        protected void publishResults(CharSequence constraint, FilterResults results) {
//            mylistFilterContects =(ArrayList<Contects>) results.values;
//            notifyDataSetChanged();
//
//        }
//    }

}
