package com.shadoapps.famvisao;


import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

import static com.shadoapps.famvisao.R.layout.fragment_list_piece;


public class RightFragment extends Fragment {

    private RecyclerView recyclerView;
    private RecyclerView.Adapter recyclerAdapter;
    private List<ListPiece> listPieces;

    public RightFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View fragView = inflater.inflate(R.layout.fragment_right, container, false);

        recyclerView = (RecyclerView) fragView.findViewById(R.id.recyclerList);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this.getActivity()));

        listPieces = new ArrayList<>();

        int i;
        for(i=0; i<10; i++){
            ListPiece piece = new ListPiece("title" + i, "deadline"+i, "state" + i);

            listPieces.add(piece);
        }

        recyclerAdapter = new CustomAdapter(listPieces,this.getActivity());
        recyclerView.setAdapter(recyclerAdapter);

        /*ListView eventList = (ListView) fragView.findViewById(R.id.event_list);
        ArrayList<ListPiece> listing = new ArrayList<>();

        listing.add(list_piece);listing.add(list_piece2);listing.add(list_piece3);listing.add(list_piece4);

        ArrayAdapter<ListPiece> eventAdapter = new ArrayAdapter<ListPiece>(getActivity(), fragment_list_piece, listing);

        eventList.setAdapter(eventAdapter);

        LinearLayout rightLinear = (LinearLayout) fragView.findViewById(R.id.rightLinear);

        FragmentManager fragmentManager = getChildFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.add(R.id.rightLinear,list_piece).commit();

        FragmentTransaction fragmentTransaction2 = fragmentManager.beginTransaction();
        fragmentTransaction2.add(R.id.rightLinear,list_piece2).commit();

        FragmentTransaction fragmentTransaction3 = fragmentManager.beginTransaction();
        fragmentTransaction3.add(R.id.rightLinear,list_piece3).commit();

        FragmentTransaction fragmentTransaction4 = fragmentManager.beginTransaction();
        fragmentTransaction4.add(R.id.rightLinear,list_piece4).commit();
*/
        // Inflate the layout for this fragment
        return fragView;
    }

}
