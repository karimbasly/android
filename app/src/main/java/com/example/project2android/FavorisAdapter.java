package com.example.project2android;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.project2android.Entity.Pilot;
import com.example.project2android.dataBase.AppDataBase;


import java.util.List;


public class FavorisAdapter extends RecyclerView.Adapter<FavorisAdapter.ViewHolder> {

    List<Pilot> rows;
    Context context;

    public FavorisAdapter(Context context, List<Pilot> rows) {
        this.context = context;
        this.rows = rows;
    }


    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.fragment_favo, parent, false);
        return new ViewHolder(view);
    }
    public FavorisAdapter() {

    }


    @Override
    public void onBindViewHolder(@NonNull final ViewHolder holder, final int position) {
        final Pilot pilot=rows.get(position);

        holder.textView2.setText(rows.get(position).getDecPilot());
        holder.textView.setText(rows.get(position).getNamePilot());
//        System.out.println("dec :"+rows.get(position).getDecPilot());
        holder.imageView1.setImageResource(rows.get(position).getImgPilot());

//DELETE
//        final Pilot singleItem = rows.get(position);
//        holder.action.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                AppDataBase.getAppDatabase(context).pilotDao().delete(singleItem);
//                FavorisAdapter.this.notifyChange(AppDataBase.getAppDatabase(context).pilotDao().getAll());
//            }
//        });
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(holder.itemView.getContext(),DetailActivity.class);
                intent.putExtra("pilotDetail",pilot);
                holder.itemView.getContext().startActivity(intent);

            }
        });




    }


    @Override
    public int getItemCount() {
        return rows.size();
    }

    public void notifyChange(List<Pilot> rows){
        this.rows = rows;
        this.notifyDataSetChanged();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView imageView1;
        TextView textView,textView2;
        Button action;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
//            itemView.setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View v) {
//                    Intent intent=new Intent(v.getContext(),HomeActivity2.class);
//                    intent.putExtra("a",rows.get(getAdapterPosition()));
//                    v.getContext().startActivity(intent);
//
//                }
//            });
            textView = itemView.findViewById(R.id.nomPilotefav);
            textView2 = itemView.findViewById(R.id.decfavv);
            imageView1 = itemView.findViewById(R.id.imgPilotefav);
            action = itemView.findViewById(R.id.btnSupp);

        }
    }

}