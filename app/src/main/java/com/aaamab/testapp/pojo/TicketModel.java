package com.aaamab.testapp.pojo;

public class TicketModel {
/*"Id": 0,
      "TicketNumber": "string",
      "UserId": 0,
      "DayDate": "2022-08-21T09:31:03.277Z",
      "Time": "string",
      "TicketStatusId": 0,*/

    int Id;
    String TicketNumber;
    int UserId;
    String DayDate;
    String Time;
    int TicketStatusId;

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public String getTicketNumber() {
        return TicketNumber;
    }

    public void setTicketNumber(String ticketNumber) {
        TicketNumber = ticketNumber;
    }

    public int getUserId() {
        return UserId;
    }

    public void setUserId(int userId) {
        UserId = userId;
    }

    public String getDayDate() {
        return DayDate;
    }

    public void setDayDate(String dayDate) {
        DayDate = dayDate;
    }

    public String getTime() {
        return Time;
    }

    public void setTime(String time) {
        Time = time;
    }

    public int getTicketStatusId() {
        return TicketStatusId;
    }

    public void setTicketStatusId(int ticketStatusId) {
        TicketStatusId = ticketStatusId;
    }
}
