package com.teamtreehouse.restaurant.tables;

import java.util.Observable;

public class Table extends Observable {
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

        setChanged();
        notifyObservers(newStatus);
    }

    public Status getStatus() {
        return status;
    }
}
