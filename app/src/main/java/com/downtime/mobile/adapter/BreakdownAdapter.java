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

import java.util.List;

public class BreakdownAdapter extends RecyclerView.Adapter<BreakdownAdapter.MyViewHolder> {

    private final RecyclerViewInterface recyclerViewInterface;

    Context context;
    private List<Breakedown> breakedownList;

    public BreakdownAdapter(List<Breakedown> breakedownList, RecyclerViewInterface recyclerViewInterface) {
        this.breakedownList = breakedownList;
        this.recyclerViewInterface = recyclerViewInterface;
    }

    public BreakdownAdapter(Context context, List<Breakedown> breakedownList, RecyclerViewInterface recyclerViewInterface) {
        this.context = context;
        this.breakedownList = breakedownList;
        this.recyclerViewInterface = recyclerViewInterface;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.list_failure_item, parent, false);
        return new MyViewHolder(view, recyclerViewInterface);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        Breakedown breakedown = breakedownList.get(position);
        holder.failureName.setText(breakedown.getFailureName());
        holder.computerName.setText(breakedown.getComputerName());
        holder.description.setText(breakedown.getDescription());
    }

    @Override
    public int getItemCount() {
        return breakedownList.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder {

        TextView failureName, computerName, description;

        public MyViewHolder(@NonNull View itemView, RecyclerViewInterface recyclerViewInterface) {
            super(itemView);
            failureName = itemView.findViewById(R.id.failureListItem_name);
            computerName = itemView.findViewById(R.id.failureListItem_location);
            description = itemView.findViewById(R.id.failureListItem_branch);

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