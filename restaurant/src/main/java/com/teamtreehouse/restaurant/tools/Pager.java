package com.teamtreehouse.restaurant.tools;

import com.teamtreehouse.restaurant.tables.Status;
import com.teamtreehouse.restaurant.tables.Table;

import java.util.Observable;
import java.util.Observer;

public class Pager implements Observer {

    public Pager(Table table) {
        table.addObserver(this);
    }

    @Override
    public void update(Observable o, Object arg) {
        Status status = (Status) arg;
        Table table = (Table) o;
        if (status == Status.AVAILABLE) {
            System.out.printf("BUZZZZZ..table #%d is ready %n",
                    table.getPositionNumber());
        }
    }
}
