package com.teamtreehouse.restaurant.staff;

import com.teamtreehouse.restaurant.tables.Status;
import com.teamtreehouse.restaurant.tables.Table;

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
}
