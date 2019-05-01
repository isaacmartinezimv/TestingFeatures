package com.example.isaac.pruebam8uf2;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class recyclerAdapter extends RecyclerView.Adapter<recyclerAdapter.recyclerViewHolder> {

    ArrayList<ImageUploadInfo> mylist;

    public recyclerAdapter(ArrayList<ImageUploadInfo> mylist) {
        this.mylist = mylist;
    }

    @Override
    public recyclerViewHolder onCreateViewHolder( ViewGroup parent, int position) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_list,null,false);

        return new recyclerViewHolder(view);
    }

    @Override
    public void onBindViewHolder(recyclerViewHolder holder, int position) {
        holder.myName.setText(mylist.get(position).getImageName());
        holder.myCheckBox.setChecked(mylist.get(position).isStatus());
        holder.myInfo.setText((mylist.get(position).getImageURL()));
    }

    @Override
    public int getItemCount() {
        return mylist.size();
    }

    public class recyclerViewHolder extends RecyclerView.ViewHolder {
        TextView myName, myInfo;
        ImageView myImage;
        CheckBox myCheckBox;

        public recyclerViewHolder(View itemView) {
            super(itemView);
            myName = itemView.findViewById(R.id.idNombre);
            myInfo = itemView.findViewById(R.id.idInfo);
            myImage = itemView.findViewById(R.id.idImagen);
            myCheckBox = itemView.findViewById(R.id.idCheckBox);
        }
    }
}
