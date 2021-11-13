package com.example.project2android;

import android.content.Context;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.project2android.Entity.Pilot;
import com.example.project2android.dataBase.AppDataBase;

import java.util.ArrayList;
import java.util.List;


/**
 * A fragment representing a list of Items.
 */
public class ListFragment extends Fragment {

    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    String S1[]={"John Doe","Franc Marcel","Henry Montagomory","Emilio Wahsington"};
    String dec[]={"dec1jhghjghjghjghjghjghjghjghjghjghjghjghjghjghjghjghjghjghjghjghjghjgjhhj","dec2","abcd","dec4"};

    Integer Images[]= {R.drawable.madridrio,R.drawable.skatepark_boadilla,R.drawable.skatepark_getafe, R.drawable.madridrio};


    RecyclerView RecView;

    //RoomDatabase here
    private AppDataBase database ;
    PilotAdapter piloteAdapter;
    private List<Pilot> pilotList = new ArrayList<Pilot>();


    public ListFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment ListFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static ListFragment newInstance(String param1, String param2,String param3) {
        ListFragment fragment = new ListFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);

        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_listf, container, false);

        RecView = view.findViewById(R.id.recyclerr);
        piloteAdapter = new PilotAdapter(this.getContext(),Images,S1,dec);
        RecView.setAdapter(piloteAdapter);
        RecView.setLayoutManager(new LinearLayoutManager(this.getContext()));
        return view;
    }
}