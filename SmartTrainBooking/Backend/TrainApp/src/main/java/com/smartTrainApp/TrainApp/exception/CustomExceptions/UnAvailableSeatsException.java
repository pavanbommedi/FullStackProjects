package com.smartTrainApp.TrainApp.exception.CustomExceptions;

public class UnAvailableSeatsException extends RuntimeException {

    public UnAvailableSeatsException(String message){
        super(message);
    }

}
