package com.teamtreehouse.restaurant.tools;

import com.teamtreehouse.restaurant.tables.Status;
import com.teamtreehouse.restaurant.tables.Table;

import java.util.*;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.Collectors;

public class Dashboard {
    protected ExecutorService executor = Executors.newSingleThreadExecutor();
    private final String SEPARATOR = "____________________";
    private List<Table> tables;

    public Dashboard() {
        this.tables = new ArrayList<>();
    }

    public void addTable(Table table) {
        tables.add(table);
    }

    public void render() {
        executor.execute(() -> {
            Map<Status, List<Table>> rows = tables.stream()
                    .collect(
                            Collectors.groupingBy(
                                    Table::getStatus,
                                    Collectors.toList()

                            ));
            System.out.println("DASHBOARD");
            System.out.println(SEPARATOR);
            rows.forEach((status, grouping) -> {
                System.out.println(" " + status.toString());
                System.out.println(SEPARATOR);
                Collections.sort(grouping, Comparator.comparing(Table::getPositionNumber));
                grouping.stream()
                        .map(table -> String.format("  Table #%d seats %d %n",
                                table.getPositionNumber(),
                                table.getNumSeats()))
                        .forEach(System.out::println);

            });
            System.out.println(SEPARATOR);
            System.out.println();
            System.out.println();
        });
    }

    public void shutdown() {
        executor.shutdownNow();
    }
}
