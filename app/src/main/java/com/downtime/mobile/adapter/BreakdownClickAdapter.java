package com.downtime.mobile.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.downtime.mobile.R;
import com.downtime.mobile.RecyclerViewInterface;
import com.downtime.mobile.model.Breakedown;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class BreakdownClickAdapter extends RecyclerView.Adapter<BreakdownClickAdapter.MyViewHolder> {

    private final RecyclerViewInterface recyclerViewInterface;

    Context context;
    private List<Breakedown> breakedownList;

    public BreakdownClickAdapter(List<Breakedown> breakedownList, RecyclerViewInterface recyclerViewInterface) {
        this.breakedownList = breakedownList;
        this.recyclerViewInterface = recyclerViewInterface;
    }

    public BreakdownClickAdapter(Context context, List<Breakedown> breakedownList, RecyclerViewInterface recyclerViewInterface) {
        this.context = context;
        this.breakedownList = breakedownList;
        this.recyclerViewInterface = recyclerViewInterface;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.list_failure_item_click, parent, false);
        return new MyViewHolder(view, recyclerViewInterface);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        Breakedown breakedown = breakedownList.get(position);
        holder.description.setText(breakedown.getDescription());
        if (breakedown.getTechnician().getName() == null) {
            holder.technicianName.setText("Nie wprowadzono");

        }else {
            String technician = breakedown.getTechnician().getName();
            holder.technicianName.setText(technician);
        }
        String failureStartTime = breakedown.getFailureStartTime();
        LocalDateTime now = LocalDateTime.parse(failureStartTime);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:ss dd-MM-yyyy");
        failureStartTime = now.format(formatter);
        System.out.println("failureStartTime = " + failureStartTime);
        holder.failureStartTime.setText(failureStartTime);
    }

    @Override
    public int getItemCount() {
        return breakedownList.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder {

        TextView description, technicianName, failureStartTime;

        public MyViewHolder(@NonNull View itemView, RecyclerViewInterface recyclerViewInterface) {
            super(itemView);
            description = itemView.findViewById(R.id.failureListItem_description);
            technicianName = itemView.findViewById(R.id.failureListItem_technicianName);
            failureStartTime = itemView.findViewById(R.id.failureListItem_failureStartTime);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (recyclerViewInterface != null) {
                        int pos = getAdapterPosition();

                        if (pos != RecyclerView.NO_POSITION) {
                            recyclerViewInterface.onItemClick(pos);
                        }
                    }
                }
            });
        }
    }
}