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

    String S1[]={"Madrid Río","Boadilla del Monte ","Getafe","Skatepark Alcobendas","Torrejón de Ardoz Urban Zone"};
    String dec[]={"Cómo llegar: tienes que bajarte en la parada de metro Legazpi ","Cómo llegar: hay que pillar el autobús interurbano 574."
            ,"Cómo llegar: La parada de metro es Conservatorio (línea 12)"
            ,"Cómo llegar: tienes que ir hasta el metro Manuel de Falla (línea 10).","Cómo llegar: tienes que coger el cercanías C-2 hasta  la Plaza de Toros"};

    Integer Images[]= {R.drawable.madridrio,R.drawable.skatepark_boadilla,R.drawable.skatepark_getafe, R.drawable.skateparkalco,R.drawable.skateparktorrejon};
    String Info[]={"El skatepark de Madrid Río situado junto a la parada del metro Legazpi es un de los más conocidos y frecuentados. Situado en el interior del Parque Arganzuela, este skatepark es perfecto para iniciarte en el surfskate o practicar street skate. Bowls abiertos y cerrados, planos inclinados, rails de bajadas, dunas… las opciones son ilimitadas.",
            "El skatepark Boadilla del Monte es el más pequeño de los anteriores. Sin embargo, pese a su menor tamaño ofrece opciones muy interesante para bowl y street skate. Además se permite la entrada a bikes. Lo mejor del bowl es que cuenta con dos medidas. Una más baja y otra más alta. Lo cual te permite ir probando poco a poco antes de aventurarte a entrar en una más grande.",
            "El skatepark de Getafe, se encuentra también a las afueras de la ciudad. Construido en 2014, cuenta con un bowl con pin, planos inclinados, hubbas y distintos módulos. Un skatepark perfecto tanto para principiantes como para skaters avanzados. Recomendable para aquellos que quieran darle al street y al skate surf. Es ideal para los que están empezando a darle caña al surfskate. Ya que dispone de bowls no muy grandes ni con mucha pendiente.",
            "El skatepark de Alcobendas, se encuentra en el polideportivo municipal de Valdelafuentes de Alcobendas. Totalmente renovado, es uno de los skate parks de Madrid más frecuentado. Tiene dos bañeras profundas conectadas con una tercera, que te permitirán gozarla y disfrutar como un niño con el surfskate. Conocido por lo locales como Nepal. Un Skatepark que bien merece una visita aunque sea para ver el nivelazo de los locales.",
            "El skatepark Torrejón de Ardoz se encuentra a las afueras de la ciudad. Una pista de gran calidad, con muchas posibilidades y de gran tamaño. Cuenta con un bowl medio, bordillos para todos los gustos, sección de escaleras y hubbas, zonas para el breakdance y muros graffiteros. Construido en 2008 es uno de los mejores skateparks de Madrid para vivir la cultura urbana."};

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