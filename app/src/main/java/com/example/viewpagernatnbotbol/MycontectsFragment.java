package com.example.viewpagernatnbotbol;

import android.os.Bundle;
import android.util.Log;
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
    private static final String TAG = MycontectsFragment.class.getSimpleName();
    private RecyclerView myrecycleviiew;
    private RecyclerView.LayoutManager mylayotmeneger;
    private RecyclerView.Adapter myAdapter;
    private boolean isfavorite;
    ArrayList<Contects> myListContects = new ArrayList<>();
    ArrayList<Contects> listallcontectcs;

    public static MycontectsFragment newinstance(boolean isfavorite) {
        MycontectsFragment mycontectsFragment = new MycontectsFragment();
        Bundle args = new Bundle();
        args.putBoolean("iffavorite", isfavorite);
        mycontectsFragment.setArguments(args);
        return mycontectsFragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        listallcontectcs = simplelist();
        if (getArguments() != null) {
            isfavorite = getArguments().getBoolean("iffavorite");
        }
    }

    @Nullable

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_mycontects, container, false);
        myrecycleviiew = view.findViewById(R.id.myrecyercleview);
//        initrecyerclyview();
        return view;


    }

    @Override
    public void onResume() {
        super.onResume();
        initrecyerclyview();
    }

    private void initrecyerclyview() {

        mylayotmeneger = new LinearLayoutManager(getContext());
        myrecycleviiew.setLayoutManager(mylayotmeneger);
        if (isfavorite) {
            ArrayList<Contects> myListContecsDb;
            myListContecsDb = (ArrayList<Contects>) AppDataBase.getINSTANCE(getActivity()).myDeoContects().getallcontects();
            Log.d(TAG, "initrecyerclyview From Db: " + myListContecsDb.size());
            if (myListContecsDb.size() > 0) {
                for (int i = 0; i < myListContecsDb.size(); i++) {
                    if (myListContecsDb.get(i).isfavorite) {
                        myListContects.add(myListContecsDb.get(i));
                    }

                }

            } else {
                for (int i = 0; i < listallcontectcs.size(); i++) {
                    if (listallcontectcs.get(i).isfavorite) {
                        myListContects.add(listallcontectcs.get(i));
                    }

                }
                AppDataBase.getINSTANCE(getActivity()).myDeoContects().inserallcontects(listallcontectcs);
                Log.d(TAG, "initrecyerclyview: " + listallcontectcs.size());
            }
            myAdapter = new AdapterFragmentContex(getContext(), myListContects);

        } else {
            myListContects = simplelist();
            myAdapter = new AdapterFragmentContex(getContext(), myListContects);
        }

        myrecycleviiew.setAdapter(myAdapter);

    }

    public ArrayList<Contects> simplelist() {
        ArrayList<Contects> simplecontects = new ArrayList<>();
        simplecontects.add(new Contects("bibiA", "netanio", R.drawable.bibi, "primminister", true, 0));
        simplecontects.add(new Contects("gorgA", "bush", R.drawable.bush, "primministerusa", true, 0));
        simplecontects.add(new Contects("donaldA", "tramp", R.drawable.tramp, "primministerusa", false, 0));
        simplecontects.add(new Contects("bibiB", "netanio", R.drawable.bibi, "primminister", true, 0));
        simplecontects.add(new Contects("gorgB", "bush", R.drawable.bush, "primministerusa", true, 0));
        simplecontects.add(new Contects("donaldB", "tramp", R.drawable.tramp, "primministerusa", false, 0));
        simplecontects.add(new Contects("bibiC", "netanio", R.drawable.bibi, "primminister", true, 0));
        simplecontects.add(new Contects("gorgC", "bush", R.drawable.bush, "primministerusa", true, 0));
        simplecontects.add(new Contects("donaldC", "tramp", R.drawable.tramp, "primministerusa", false, 0));
        simplecontects.add(new Contects("bibiD", "netanio", R.drawable.bibi, "primminister", true, 0));
        simplecontects.add(new Contects("gorgD", "bush", R.drawable.bush, "primministerusa", true, 0));
        simplecontects.add(new Contects("donaldD", "tramp", R.drawable.tramp, "primministerusa", false, 0));
        simplecontects.add(new Contects("arieA", "deri", R.drawable.ariadaeri, "shlohco of maran", true, 0));
        simplecontects.add(new Contects("eliA", "ishi", R.drawable.eliyehsi, "sar the job", true, 0));
        simplecontects.add(new Contects("arieB", "deri", R.drawable.ariadaeri, "shlohco of maran", true, 0));
        simplecontects.add(new Contects("eliB", "ishi", R.drawable.eliyehsi, "sar the job", true, 0));
        simplecontects.add(new Contects("arieC", "deri", R.drawable.ariadaeri, "shlohco of maran", true, 0));
        simplecontects.add(new Contects("eliC", "ishi", R.drawable.eliyehsi, "sar the job", true, 0));
        simplecontects.add(new Contects("arieD", "deri", R.drawable.ariadaeri, "shlohco of maran", true, 0));
        simplecontects.add(new Contects("eliD", "ishi", R.drawable.eliyehsi, "sar the job", true, 0));
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
