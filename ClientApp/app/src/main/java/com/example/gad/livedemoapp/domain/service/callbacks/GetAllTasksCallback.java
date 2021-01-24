package com.example.gad.livedemoapp.domain.service.callbacks;

import com.example.gad.livedemoapp.domain.model.Task;

import java.util.List;

import retrofit2.Call;
import retrofit2.Response;

public class GetAllTasksCallback extends BaseServiceCallback<List<Task>>
{
    private final GetAllTasksCallbackListener mListener;

    public GetAllTasksCallback(GetAllTasksCallbackListener listener) {
        mListener = listener;
    }

    @Override
    public void onSuccessResponse200(Call<List<Task>> call, Response<List<Task>> response) {
        mListener.onGetAllTasksSuccess(call, response);
    }
}
