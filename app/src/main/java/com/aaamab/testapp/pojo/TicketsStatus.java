package com.aaamab.testapp.pojo;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class TicketsStatus {
    String StatusNameEn ;
    ArrayList<TicketModel> Tickets ;

    public String getStatusNameEn() {
        return StatusNameEn;
    }

    public void setStatusNameEn(String statusNameEn) {
        StatusNameEn = statusNameEn;
    }

    public ArrayList<TicketModel> getTickets() {
        return Tickets;
    }

    public void setTickets(ArrayList<TicketModel> tickets) {
        Tickets = tickets;
    }
}
