package com.example.gad.livedemoapp.ui.activities;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.gad.livedemoapp.R;
import com.example.gad.livedemoapp.TaskApplication;
import com.example.gad.livedemoapp.domain.model.Task;
import com.example.gad.livedemoapp.domain.service.TaskService;
import com.example.gad.livedemoapp.domain.service.callbacks.GetAllTasksCallback;
import com.example.gad.livedemoapp.domain.service.callbacks.GetAllTasksCallbackListener;
import com.example.gad.livedemoapp.ui.adapters.TaskListAdapter;
import com.example.gad.livedemoapp.ui.listeners.OnTaskListItemClickListener;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class TaskListActivity extends BaseActivity implements   OnTaskListItemClickListener,
                                                                GetAllTasksCallbackListener
{
    private final static String TAG = "TASK_LIST_ACT";
    private TaskService mServiceClient;

    private RecyclerView mTaskList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initViews();

        mServiceClient = TaskApplication.getServiceClient();
        mServiceClient.getAllTasks().enqueue(new GetAllTasksCallback(this));
    }

    private void initViews() {
        mTaskList = findViewById(R.id.actTaskList_listTasks);
        mTaskList.setHasFixedSize(true);
        mTaskList.setLayoutManager(new LinearLayoutManager(this));
    }

    @Override
    public void onTaskListItemClicked() {
        Intent intent = TaskDetailsActivity.getStartingIntent(this, "title task");
        startActivity(intent);
    }

    //region Service Handler Methods
    @Override
    public void onGetAllTasksSuccess(Call<List<Task>> call, Response<List<Task>> response) {
        List<Task> tasks = response.body();
        TaskListAdapter adapter = new TaskListAdapter(tasks, this);
        mTaskList.setAdapter(adapter);
    }

    @Override
    public void onGetAllTasksClientError(Call<List<Task>> call, Response<List<Task>> response) {
        Toast.makeText(this, "Something went wrong!", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onGetAllTasksFailed(Call<List<Task>> call, Throwable t) {
        Toast.makeText(this, "Something went really really wrong!", Toast.LENGTH_SHORT).show();
    }
    //endregion

}