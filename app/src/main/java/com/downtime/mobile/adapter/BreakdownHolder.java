package com.downtime.mobile.adapter;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.downtime.mobile.R;

public class BreakdownHolder extends RecyclerView.ViewHolder {

    TextView name, location, branch;

    public BreakdownHolder(@NonNull View itemView) {
        super(itemView);
        name = itemView.findViewById(R.id.employeeListItem_name);
        location = itemView.findViewById(R.id.employeeListItem_location);
        branch = itemView.findViewById(R.id.employeeListItem_branch);
    }
}