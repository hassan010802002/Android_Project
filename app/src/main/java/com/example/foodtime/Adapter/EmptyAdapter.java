package com.example.foodtime.Adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import com.example.foodtime.Domain.CategoryDomain;
import com.example.foodtime.R;

import java.util.ArrayList;

public class EmptyAdapter extends RecyclerView.Adapter<EmptyAdapter.ViewHolder> {

    ArrayList<CategoryDomain> categoryDomain;

    public EmptyAdapter(ArrayList<CategoryDomain> categoryDomain) {
        this.categoryDomain = categoryDomain;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View inflate = LayoutInflater.from(parent.getContext()).inflate(R.layout.viewholder_category,parent,false);

        return new ViewHolder(inflate);
    }

    @Override
    public void onBindViewHolder(@NonNull EmptyAdapter.ViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return categoryDomain.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView categoryName;
        ImageView categoryPic;
        ConstraintLayout mainLayout;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            categoryName = itemView.findViewById(R.id.categoryName);
            categoryPic = itemView.findViewById(R.id.categoryPic);
            mainLayout = itemView.findViewById(R.id.mainLayout);
        }
    }
}
