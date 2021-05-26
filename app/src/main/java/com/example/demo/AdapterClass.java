package com.example.demo;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class AdapterClass extends RecyclerView.Adapter<AdapterClass.MyViewHolder> {
    private LayoutInflater inflater;
    private ArrayList<ModelView> rogerModelArrayList;
    private ArrayList<ModelView> filtr;
    private Demo mListiner;
    private boolean loading = true;
    private ArrayList<ModelView> mLinearLayoutManager;

    public AdapterClass(ArrayList<ModelView> linearLayoutManager) {
        this.mLinearLayoutManager = linearLayoutManager;
    }


    public String getString(ArrayList<ModelView> email) {
        return null;
    }


    public interface OnItemClickListener {
        void onScrollChange(View v, int scrollX, int scrollY, int oldScrollX, int oldScrollY);

        void OnItemClick(int postion);
    }

    public void setOnItemClickListener(Demo listener) {
        mListiner = listener;
    }


    @Override
    public int getItemViewType(int position) {
        return position;
    }

    Context context;
    ArrayList specilization;

    public AdapterClass(Context context, ArrayList<ModelView> rogerModelArrayList) {
        this.context = context;
        this.filtr = rogerModelArrayList;
        inflater = LayoutInflater.from(context);
        this.rogerModelArrayList = rogerModelArrayList;
        this.notifyDataSetChanged();
    }

    @Override
    public AdapterClass.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        AdapterClass.MyViewHolder holder;
        View view = inflater.inflate(R.layout.design, parent, false);
        holder = new MyViewHolder(view);
        return holder;

    }


    @Override
    public void onBindViewHolder(final MyViewHolder holder, final int position) {
        ModelView modal = rogerModelArrayList.get(position);
        holder.name.setText(modal.getName());
        holder.description.setText(modal.getDesc());
        Picasso.get().load(modal.getImage()).into(holder.image);
    }




    @Override
    public int getItemCount() {
        System.out.println("Array List size======= " + rogerModelArrayList.size());
        return filtr.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        TextView name, description;
        ImageView image;

        public MyViewHolder(final View itemView) {
            super(itemView);

            image = (ImageView) itemView.findViewById(R.id.img_people);
            name = (TextView) itemView.findViewById(R.id.name);
            description = (TextView) itemView.findViewById(R.id.description);


            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (mListiner != null) {
                        int position = getAdapterPosition();
                        String name = filtr.get(position).getName();
                        String desce = filtr.get(position).getDesc();
                        for (int i = 0; i < rogerModelArrayList.size(); i++) {
                            if (name.equals(rogerModelArrayList.get(i).getName()) && desce.equals(rogerModelArrayList.get(i).getDesc())) {
                                position = i;
                                break;
                            }
                        }
                        if (position != RecyclerView.NO_POSITION) {
                            mListiner.OnItemClick(position);

                        }
                    }
                }
            });
        }
    }
}