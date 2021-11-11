package com.example.lesson31.ui.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.lesson31.databinding.ItemRecBinding;
import com.example.lesson31.interfaces.OnItemClick;
import com.example.lesson31.model.TaskModel;

import java.util.ArrayList;

public class TaskAdapter extends RecyclerView.Adapter<TaskAdapter.ViewHolder> {


    ArrayList<TaskModel> list = new ArrayList<>();
    OnItemClick onItemClick;
    ItemRecBinding binding;

    public TaskModel getModelPosition(int position) {
        return list.get(position);
    }

    public void addList(ArrayList<TaskModel> models) {
        this.list = models;
        notifyDataSetChanged();
    }


    public void setOnItemClick(OnItemClick onItemClick) {
        this.onItemClick = onItemClick;
    }

    @NonNull
    @Override
    public TaskAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        binding = ItemRecBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false);
        return new ViewHolder(binding.getRoot());
    }

    @Override
    public void onBindViewHolder(@NonNull TaskAdapter.ViewHolder holder, int position) {
        holder.onBind(list.get(position));
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
        }

        public void onBind(TaskModel taskModel) {
            binding.flag.setImageResource(taskModel.getImageview());
            binding.country.setText(taskModel.getCountry());
            itemView.setOnClickListener(v -> {
                onItemClick.OnClick(getAdapterPosition());
            });
        }
    }
}


