package com.downtime.mobile.adapter;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.downtime.mobile.R;

public class BreakdownHolder extends RecyclerView.ViewHolder {

    TextView name, location, branch;
    public CardView cardView;

    public BreakdownHolder(@NonNull View itemView) {
        super(itemView);
        name = itemView.findViewById(R.id.failureListItem_name);
        location = itemView.findViewById(R.id.failureListItem_location);
        branch = itemView.findViewById(R.id.failureListItem_branch);
        cardView = itemView.findViewById(R.id.main_container);
    }
}
