package com.teamtreehouse.restaurant.staff;

import com.teamtreehouse.restaurant.tables.Status;
import com.teamtreehouse.restaurant.tables.Table;

import java.util.Random;

import static com.teamtreehouse.restaurant.core.Utilities.passTime;

public class Server extends Employee {
    public Server(String name) {
        super(name);
    }

    public void leadToTable(Table table) {
        performTask(() -> {
            table.setStatus(Status.OCCUPIED);
            announce("Hi I'm %s, and I'll be your server. Follow me to your table (#%d)",
                    name,
                    table.getPositionNumber());
            passTime(2);
            announce("Here are your menus (#%d)", table.getPositionNumber());
        });
        // Allows patrons to eat for a random amount of time
        executor.execute(() -> {
            passTime(new Random().nextInt(6));
            table.setStatus(Status.FINISHED);
        });
    }

    public void closeOutTable(Table table) {
        performTask(() -> {
            announce("Here is your bill...(#%d)", table.getPositionNumber());
            table.setStatus(Status.CLOSING_BILL);
            passTime(1);
            announce("Thank you for your generous tip!  See you next time! (#%d)", table.getPositionNumber());
            table.setStatus(Status.NEEDS_BUSSING);
        });

    }
}
