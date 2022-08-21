package com.aaamab.testapp.data;

import com.aaamab.testapp.pojo.MainResponse;
import com.aaamab.testapp.pojo.TicketModel;

import java.util.List;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

// api = api/Ticket
// baseUrl = http://apifm.alfoadia.com.sa/
public class Client {
    private static final String BASE_URL = "http://apifm.alfoadia.com.sa/";
    private TicketInterface postInterface;
    private static Client INSTANCE;

    public Client() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        postInterface = retrofit.create(TicketInterface.class);
    }

    public static Client getINSTANCE() {
        if (null == INSTANCE) {
            INSTANCE = new Client();
        }
        return INSTANCE;
    }

    public Call<MainResponse> getTickets() {
        return postInterface.getTickets();
    }
}


