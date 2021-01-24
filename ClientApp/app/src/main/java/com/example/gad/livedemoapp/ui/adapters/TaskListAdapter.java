package com.example.gad.livedemoapp.ui.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.gad.livedemoapp.R;
import com.example.gad.livedemoapp.domain.model.Task;
import com.example.gad.livedemoapp.ui.listeners.OnTaskListItemClickListener;

import java.util.List;

public class TaskListAdapter extends RecyclerView.Adapter<TaskListAdapter.TaskViewHolder>
{
    //region MEMBERS
    private final List<Task>                  mDataSet;
    private final OnTaskListItemClickListener mTaskItemClickListener;
    //endregion

    //region CONSTRUCTORS
    public TaskListAdapter(List<Task> tasks, OnTaskListItemClickListener click_listener) {
        mDataSet                = tasks;
        mTaskItemClickListener  = click_listener;
    }
    //endregion

    //region ADAPTER METHODS
    @NonNull
    @Override
    public TaskViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_task, parent, false);
        return new TaskViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull TaskViewHolder holder, int position) {
        Task task = mDataSet.get(position);
        holder.updateView(task);
    }

    @Override
    public int getItemCount() {
        return mDataSet.size();
    }
    //endregion

    public class TaskViewHolder extends RecyclerView.ViewHolder
    {
        private final TextView mTaskTitle;
        private final TextView mTaskDescription;

        public TaskViewHolder(View view) {
            super(view);

            mTaskTitle       = view.findViewById(R.id.itemTask_taskTitle);
            mTaskDescription = view.findViewById(R.id.itemTask_taskDescription);

            view.setOnClickListener(new TaskItemClickListener());
        }

        public void updateView(Task task) {
            mTaskTitle.setText(task.getTitle());
            mTaskDescription.setText(task.getDescription());
        }
    }

    public class TaskItemClickListener implements View.OnClickListener
    {
        @Override
        public void onClick(View v) {
            mTaskItemClickListener.onTaskListItemClicked();
        }
    }
}
