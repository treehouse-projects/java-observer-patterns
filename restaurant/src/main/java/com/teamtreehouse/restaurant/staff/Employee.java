package com.teamtreehouse.restaurant.staff;

import com.teamtreehouse.restaurant.tools.Dashboard;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public abstract class Employee {
    protected boolean isAvailable;
    protected String name;
    protected ExecutorService executor = Executors.newSingleThreadExecutor();


    public Employee(String name) {
        this.name = name;
        this.isAvailable = true;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public String getName() {
        return name;
    }

    public void announce(String messageTemplate, Object ... templateArgs) {
        String message = messageTemplate;
        if (templateArgs.length > 0) {
            message = String.format(messageTemplate, templateArgs);
        }
        System.out.printf("%s %s: %s%n",
                getClass().getSimpleName(),
                name,
                message);
    }

    public void performTask(Runnable task) {
        executor.execute(() -> {
            isAvailable = false;
            task.run();
            isAvailable = true;
        });
    }

    public void clockOut() {
        executor.shutdownNow();
    }

    public void refreshDashboard(Dashboard dashboard) {
        announce("I'm available, so I will refresh the dashboard");
        dashboard.render();
    }
}
