package com.aaamab.testapp.ui.main;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.aaamab.testapp.data.Client;
import com.aaamab.testapp.pojo.MainResponse;
import com.aaamab.testapp.pojo.TicketModel;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import java.util.List;

public class TicketViewModel extends ViewModel {
    MutableLiveData<MainResponse> ticketsMutableLiveData = new MutableLiveData<>();
    MutableLiveData<String> tickets = new MutableLiveData<>();

    public void getTickets() {
        Client.getINSTANCE().getTickets().enqueue(new Callback<MainResponse>() {
            @Override
            public void onResponse(Call<MainResponse> call, Response<MainResponse> response) {
                ticketsMutableLiveData.setValue(response.body());
            }

            @Override
            public void onFailure(Call<MainResponse> call, Throwable t) {
                tickets.setValue("Error");
            }
        });
    }


}
