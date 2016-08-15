package com.teamtreehouse.restaurant.tables;

public class Table {
    private Status status;
    private int positionNumber;
    private int numSeats;

    public Table(int positionNumber, int numSeats) {
        this.positionNumber = positionNumber;
        this.numSeats = numSeats;
        status = Status.AVAILABLE;
    }

    public int getPositionNumber() {
        return positionNumber;
    }

    public int getNumSeats() {
        return numSeats;
    }

    public void setStatus(Status newStatus) {
        status = newStatus;
    }

    public Status getStatus() {
        return status;
    }
}
