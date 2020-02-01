package com.divergents.eco.model;

public class Error {

    public String message;

    public String developerMessage;

    public Error(String message, String developerMessage) {
        this.message = message;
        this.developerMessage = developerMessage;
    }

    public Error() {
    }

    public String getMessage() {
        return message;
    }

    public String getDeveloperMessage() {
        return developerMessage;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public void setDeveloperMessage(String developerMessage) {
        this.developerMessage = developerMessage;
    }

    @Override
    public String toString() {
        return "Error{" +
                "message='" + message + '\'' +
                ", developerMessage='" + developerMessage + '\'' +
                '}';
    }
}
