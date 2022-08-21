package com.aaamab.testapp.pojo;

public class MainResponse {

    int Status ;
    String Message ;
    DataResponse Data ;

    public int getStatus() {
        return Status;
    }

    public void setStatus(int status) {
        Status = status;
    }

    public String getMessage() {
        return Message;
    }

    public void setMessage(String message) {
        Message = message;
    }

    public DataResponse getData() {
        return Data;
    }

    public void setData(DataResponse data) {
        Data = data;
    }
}
