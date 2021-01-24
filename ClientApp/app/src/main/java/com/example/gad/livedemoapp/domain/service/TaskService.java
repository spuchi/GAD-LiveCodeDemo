package com.example.gad.livedemoapp.domain.service;

import com.example.gad.livedemoapp.domain.model.Task;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface TaskService
{
    @GET("/task")
    Call<Task> getSingleTask();

    @GET("/tasks")
    Call<List<Task>> getAllTasks();
}
