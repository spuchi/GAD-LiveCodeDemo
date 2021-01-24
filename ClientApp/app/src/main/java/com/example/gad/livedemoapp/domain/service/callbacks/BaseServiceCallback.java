package com.example.gad.livedemoapp.domain.service.callbacks;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public abstract class BaseServiceCallback<T> implements Callback<T>
{
    @Override
    public void onResponse(Call<T> call, Response<T> response) {
        int httpcode = response.code();

        switch (httpcode) {
            case 200:   onSuccessResponse200(call, response);
                        break;
            case 400:   onClientErrorResponse400(call, response);
                        break;
            case 403:   onClientErrorResponse403(call, response);
                        break;
            case 404:   onClientErrorResponse404(call, response);
                        break;
            default:    onDefaultResponse(call, response);
        }
    }

    @Override
    public void onFailure(Call<T> call, Throwable t) {
        onServiceFailure(call, t);
    }

    //region SUCCESS Response
    public void onSuccessResponse200(Call<T>call, Response<T> response)
    { throw new UnsupportedOperationException(); }
    //endregion

    //region CLIENT ERROR Response
    // Bad Request
    public void onClientErrorResponse400(Call<T>call, Response<T> response)
    { throw new UnsupportedOperationException(); }

    // Forbidden
    public void onClientErrorResponse403(Call<T>call, Response<T> response)
    { throw new UnsupportedOperationException(); }

    //Not Found
    public void onClientErrorResponse404(Call<T>call, Response<T> response)
    { throw new UnsupportedOperationException(); }
    //endregion

    public void onDefaultResponse(Call<T>call, Response<T> response)
    { }

    public void onServiceFailure(Call<T> call, Throwable t)
    { throw new UnsupportedOperationException(); }



}
