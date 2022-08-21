package com.aaamab.testapp.data;

import com.aaamab.testapp.pojo.MainResponse;
import com.aaamab.testapp.pojo.TicketModel;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface TicketInterface {
    @GET("api/ticket")
    public Call<MainResponse> getTickets();
}
