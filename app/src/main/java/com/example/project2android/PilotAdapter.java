package com.example.project2android;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.core.graphics.drawable.DrawableCompat;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.os.Build;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.project2android.Entity.Pilot;
import com.example.project2android.dataBase.AppDataBase;

import java.util.ArrayList;
import java.util.List;


public class PilotAdapter extends RecyclerView.Adapter<PilotAdapter.ViewHolder> {

    String[] names;
    String[] descriptions;
    Integer[] images;
    Context context;
    private List<Pilot> rowList = new ArrayList<Pilot>();
    FavorisAdapter favorisAdapter;


    public PilotAdapter(Context context, Integer[] images, String[] names, String[] descriptions) {
        this.context = context;
        this.names = names;
        this.images = images;
        this.descriptions = descriptions;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.my_row, parent, false);
        return new ViewHolder(view);
    }

    public PilotAdapter() {

    }

    @RequiresApi(api = Build.VERSION_CODES.M)
    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, final int position) {

        holder.tv_name.setText(names[position]);
        holder.imageView1.setBackgroundResource(images[position]);
        holder.tv_dec.setText(descriptions[position]);
        Pilot row = new Pilot();
        row.setNamePilot(names[position]);
        row.setImgPilot(images[position]);
        row.setDecPilot(descriptions[position]);
        AppDataBase database = AppDataBase.getAppDatabase(context);
        rowList = database.pilotDao().getAll();
//        rowList.get(position).setDecPilot(descriptions[position]);
//
//        System.out.println("Result:" + rowList.contains(row));
//        System.out.println("Name:" + rowList.get(position).getNamePilot());
//        System.out.println("dec:"+rowList.get(position).getDecPilot());
        if(rowList.contains(row))
        {
            DrawableCompat.setTint(holder.imageView2.getDrawable(),context.getColor(R.color.cardview_dark_background));

        }


        holder.imageView2.setOnClickListener(new View.OnClickListener()

        {
            @Override
            public void onClick (View v){

                Toast toast = Toast.makeText(context, "room time !", Toast.LENGTH_SHORT);
                toast.show();



                //insert
                favorisAdapter = new FavorisAdapter(context, rowList);
                Pilot row = new Pilot();
                row.setDecPilot(descriptions[position]);
                row.setNamePilot(names[position]);
                row.setImgPilot(images[position]);

                if(!rowList.contains(row)){
                    database.pilotDao().insertOne(row);
                    favorisAdapter.notifyChange(database.pilotDao().getAll());}
                else {
                    Toast toast2 = Toast.makeText(context, "Exists", Toast.LENGTH_SHORT);
                    toast2.show();
                }


            }
        });

    }


    @Override
    public int getItemCount() {
        return names.length;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView imageView1,imageView2;
        TextView tv_name;
        TextView tv_dec;


        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tv_name = itemView.findViewById(R.id.nomPilote);
            imageView1 = itemView.findViewById(R.id.imgPilote);
            tv_dec = itemView.findViewById(R.id.decPilote);
            imageView2 = itemView.findViewById(R.id.btnStar);

        }
    }
}