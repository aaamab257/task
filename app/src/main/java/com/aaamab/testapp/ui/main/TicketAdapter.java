package com.aaamab.testapp.ui.main;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.aaamab.testapp.R;
import com.aaamab.testapp.pojo.MainResponse;
import com.aaamab.testapp.pojo.TicketModel;

import java.util.ArrayList;
import java.util.List;

public class TicketAdapter extends RecyclerView.Adapter<TicketAdapter.TicketViewHolder> {
    ArrayList<TicketModel> ticketModelArrayList ;

    public TicketAdapter(ArrayList<TicketModel> tikectsList) {
        ticketModelArrayList = tikectsList;
    }

    public void filterList(ArrayList<TicketModel> filterlist) {
        ticketModelArrayList = filterlist;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public TicketViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new TicketViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.ticket_item, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull TicketViewHolder holder, int position) {
        holder.ticketNum.setText(ticketModelArrayList.get(position).getTicketNumber());
        holder.dayDate.setText(ticketModelArrayList.get(position).getDayDate());
        holder.userId.setText(ticketModelArrayList.get(position).getUserId()+"");
    }

    @Override
    public int getItemCount() {
        return ticketModelArrayList
                .size();
    }

    public class TicketViewHolder extends RecyclerView.ViewHolder {
        TextView ticketNum , userId , dayDate ;
        public TicketViewHolder(@NonNull View itemView) {
            super(itemView);
            ticketNum = itemView.findViewById(R.id.txt_ticketNum);
            userId = itemView.findViewById(R.id.txt_userId);
            dayDate = itemView.findViewById(R.id.txt_dayDate);
        }
    }
}
