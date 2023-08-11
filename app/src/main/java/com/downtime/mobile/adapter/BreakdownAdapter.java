package com.downtime.mobile.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.downtime.mobile.R;
import com.downtime.mobile.SelectListener;
import com.downtime.mobile.model.Breakedown;

import java.util.List;

public class BreakdownAdapter extends RecyclerView.Adapter<BreakdownHolder> {

    private Context context;
    private List<Breakedown> breakedownList;
    private SelectListener listener;

    public BreakdownAdapter(List<Breakedown> breakedownList, SelectListener listener) {
        this.breakedownList = breakedownList;
        this.listener = listener;
    }

    @NonNull
    @Override
    public BreakdownHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.list_failure_item, parent, false);
        return new BreakdownHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull BreakdownHolder holder, int position) {
        Breakedown breakedown = breakedownList.get(position);
        holder.name.setText(breakedown.getFailureName());
        holder.location.setText(breakedown.getComputerName());
        holder.branch.setText(breakedown.getDescription());
        holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                listener.onItemClick(breakedown);
            }
        });
    }

    @Override
    public int getItemCount() {
        return breakedownList.size();
    }
}
