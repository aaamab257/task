package com.aaamab.testapp.ui.main;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import android.widget.TextView;
import android.widget.Toast;

import com.aaamab.testapp.R;
import com.aaamab.testapp.pojo.MainResponse;
import com.aaamab.testapp.pojo.TicketModel;
import com.aaamab.testapp.pojo.TicketsStatus;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    TicketViewModel viewModel ;
    private ArrayList<TicketModel> TicketsModelArrayList;
    TicketAdapter adapter ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        viewModel  = ViewModelProviders.of(this).get(TicketViewModel.class);
        viewModel.getTickets();
        RecyclerView recTickets = findViewById(R.id.recycler);



        viewModel.ticketsMutableLiveData.observe(this, new Observer<MainResponse>() {
            @Override
            public void onChanged(MainResponse mainModels) {
                TicketsModelArrayList = new ArrayList<>();
                TicketsModelArrayList = mainModels.getData().getTicketstatus().get(0).getTickets();
                TextView txt = findViewById(R.id.txtStatus);
                txt.setText(mainModels.getData().getTicketstatus().get(0) .getStatusNameEn());
                adapter = new TicketAdapter( mainModels.getData().getTicketstatus().get(0).getTickets());
                recTickets.setLayoutManager(new LinearLayoutManager(MainActivity.this));
                recTickets.setAdapter(adapter);
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();

        // inside inflater we are inflating our menu file.
        inflater.inflate(R.menu.search_menu, menu);

        // below line is to get our menu item.
        MenuItem searchItem = menu.findItem(R.id.actionSearch);

        // getting search view of our item.
        SearchView searchView = (SearchView) searchItem.getActionView();

        // below line is to call set on query text listener method.
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                // inside on query text change method we are
                // calling a method to filter our recycler view.
                filter(newText);
                return false;
            }
        });
        return true;

    }
    private void filter(String text) {

        ArrayList<TicketModel> filteredlist = new ArrayList<TicketModel>();


        for (TicketModel item : TicketsModelArrayList) {

            if (item.getTicketNumber().toLowerCase().contains(text.toLowerCase()) || String.valueOf(item.getUserId()) == text.toLowerCase()) {

                filteredlist.add(item);
            }
        }
        if (filteredlist.isEmpty()) {

            Toast.makeText(this, "No Data Found..", Toast.LENGTH_SHORT).show();
        } else {

            adapter.filterList(filteredlist);
        }
    }
}