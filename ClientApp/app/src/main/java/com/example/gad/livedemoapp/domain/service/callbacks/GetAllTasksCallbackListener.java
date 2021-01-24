package com.example.gad.livedemoapp.domain.service.callbacks;

import com.example.gad.livedemoapp.domain.model.Task;

import java.util.List;

import retrofit2.Call;
import retrofit2.Response;

public interface GetAllTasksCallbackListener
{
    void onGetAllTasksSuccess(Call<List<Task>> call, Response<List<Task>> response);
    void onGetAllTasksClientError(Call<List<Task>> call, Response<List<Task>> response);
    void onGetAllTasksFailed(Call<List<Task>> call, Throwable t);
}
