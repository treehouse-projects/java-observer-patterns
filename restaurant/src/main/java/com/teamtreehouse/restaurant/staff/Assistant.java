package com.teamtreehouse.restaurant.staff;

import com.teamtreehouse.restaurant.tables.Status;
import com.teamtreehouse.restaurant.tables.Table;

import java.util.Observable;

import static com.teamtreehouse.restaurant.core.Utilities.passTime;

public class Assistant extends Employee {
    public Assistant(String name) {
        super(name);
    }

    public void busTable(Table table) {
        performTask(() -> {
            announce("I'll bus table #%d", table.getPositionNumber());
            table.setStatus(Status.BUSSING);
            passTime(2);
            announce("Clink clink, wipe wipe. I cleaned table #%d", table.getPositionNumber());
            table.setStatus(Status.AVAILABLE);
        });
    }

    @Override
    public void update(Observable o, Object arg) {
        Table table = (Table) o;
        if (table.getStatus() == Status.NEEDS_BUSSING) {
            busTable(table);
        }

    }
}
