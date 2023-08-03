package com.genuinecoder.springclient.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.genuinecoder.springclient.R;
import com.genuinecoder.springclient.model.Breakedown;

import java.util.List;

public class BreakdownAdapter extends RecyclerView.Adapter<BreakdownHolder> {

  private List<Breakedown> breakedownList;

  public BreakdownAdapter(List<Breakedown> breakedownList) {
    this.breakedownList = breakedownList;
  }

  @NonNull
  @Override
  public BreakdownHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
    View view = LayoutInflater.from(parent.getContext())
        .inflate(R.layout.list_employee_item, parent, false);
    return new BreakdownHolder(view);
  }

  @Override
  public void onBindViewHolder(@NonNull BreakdownHolder holder, int position) {
    Breakedown breakedown = breakedownList.get(position);
    holder.name.setText(breakedown.getFailureName());
    holder.location.setText(breakedown.getComputerName());
    holder.branch.setText(breakedown.getDescription());
  }

  @Override
  public int getItemCount() {
    return breakedownList.size();
  }
}
