package com.example.viewpagernatnbotbol;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MycontectsFragment extends Fragment {
    private RecyclerView myrecycleviiew;
    private RecyclerView.LayoutManager mylayotmeneger;
    private RecyclerView.Adapter myAdapter;
    private boolean isfavorite;
    ArrayList<Contects> myListContects = new ArrayList<>();
    ArrayList<Contects> listallcontectcs;

    public static MycontectsFragment newinstance(boolean isfavorite){
        MycontectsFragment mycontectsFragment = new MycontectsFragment();
        Bundle args =  new Bundle();
        args.putBoolean("iffavorite",isfavorite);
        mycontectsFragment.setArguments(args);
        return mycontectsFragment ;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        listallcontectcs = simplelist();
        if(getArguments()!=null){
            isfavorite = getArguments().getBoolean("iffavorite");
        }
    }

    @Nullable

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_mycontects,container,false);
        myrecycleviiew = view.findViewById(R.id.myrecyercleview);
        initrecyerclyview();
        return view;


    }

    private void initrecyerclyview() {

        mylayotmeneger = new LinearLayoutManager(getContext());
        myrecycleviiew.setLayoutManager(mylayotmeneger);
        if(isfavorite){
//            if(db != null){
//                myListContects=db;
//                for (int i = 0; i <listallcontectcs.size() ; i++) {
//                    if(myListContects.get(i).isfavorite == true){
//                        myListContects.add(listallcontectcs.get(i));
//                    }
//
//                }
//
//            }
//            else {
                for (int i = 0; i < listallcontectcs.size(); i++) {
                    if (simplelist().get(i).isfavorite == true) {
                        myListContects.add(listallcontectcs.get(i));
                    }

                }
//            }
            myAdapter = new AdapterFragmentContex(getContext(),myListContects);

        }else {
            myListContects = simplelist();
            myAdapter = new AdapterFragmentContex(getContext(),myListContects);
        }

        myrecycleviiew.setAdapter(myAdapter);

    }

    public ArrayList<Contects> simplelist(){
    ArrayList<Contects> simplecontects = new ArrayList<>();
    simplecontects.add(new Contects("bibi","netanio",R.drawable.bibi,"primminister",true));
    simplecontects.add(new Contects("gorg","bush",R.drawable.bush,"primministerusa",true));
    simplecontects.add(new Contects("donald","tramp",R.drawable.tramp,"primministerusa",false));
    simplecontects.add(new Contects("bibi","netanio",R.drawable.bibi,"primminister",true));
    simplecontects.add(new Contects("gorg","bush",R.drawable.bush,"primministerusa",true));
    simplecontects.add(new Contects("donald","tramp",R.drawable.tramp,"primministerusa",false));
    simplecontects.add(new Contects("bibi","netanio",R.drawable.bibi,"primminister",true));
    simplecontects.add(new Contects("gorg","bush",R.drawable.bush,"primministerusa",true));
    simplecontects.add(new Contects("donald","tramp",R.drawable.tramp,"primministerusa",false));
    simplecontects.add(new Contects("bibi","netanio",R.drawable.bibi,"primminister",true));
    simplecontects.add(new Contects("gorg","bush",R.drawable.bush,"primministerusa",true));
    simplecontects.add(new Contects("donald","tramp",R.drawable.tramp,"primministerusa",false));
    simplecontects.add(new Contects("arie","deri",R.drawable.ariadaeri,"shlohco of maran",true));
        simplecontects.add(new Contects("eli","ishi",R.drawable.eliyehsi,"sar the job",true));
        simplecontects.add(new Contects("arie","deri",R.drawable.ariadaeri,"shlohco of maran",true));
        simplecontects.add(new Contects("eli","ishi",R.drawable.eliyehsi,"sar the job",true));
        simplecontects.add(new Contects("arie","deri",R.drawable.ariadaeri,"shlohco of maran",true));
        simplecontects.add(new Contects("eli","ishi",R.drawable.eliyehsi,"sar the job",true));
        simplecontects.add(new Contects("arie","deri",R.drawable.ariadaeri,"shlohco of maran",true));
        simplecontects.add(new Contects("eli","ishi",R.drawable.eliyehsi,"sar the job",true));
    return simplecontects;
}
//public ArrayList<Contects> favoritecontects(){
//    ArrayList<Contects> favorutcontects= new ArrayList<>();
//    favorutcontects.add(new Contects("arie","deri",R.drawable.ariadaeri));
//    favorutcontects.add(new Contects("eli","ishi",R.drawable.eliyehsi));
//    favorutcontects.add(new Contects("arie","deri",R.drawable.ariadaeri));
//    favorutcontects.add(new Contects("eli","ishi",R.drawable.eliyehsi));
//    favorutcontects.add(new Contects("arie","deri",R.drawable.ariadaeri));
//    favorutcontects.add(new Contects("eli","ishi",R.drawable.eliyehsi));
//    favorutcontects.add(new Contects("arie","deri",R.drawable.ariadaeri));
//  favorutcontects.add(new Contects("eli","ishi",R.drawable.eliyehsi));
//    return favorutcontects;
//}
}
