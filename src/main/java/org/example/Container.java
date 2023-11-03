package org.example;

import lombok.*;

import java.util.Scanner;

@Builder
@NoArgsConstructor
public class Container {
    private static Scanner sc;
    @Getter
    @Setter
    private static Order OrderMenu;
    private static DBConnection dbConnection;

    public static void init() {
        sc = new Scanner(System.in);
    }

    public static void close() {
        sc.close();
    }

    public static Scanner getScanner() {
        return sc;
    }

    public static DBConnection getDBconnection() {
        if (dbConnection == null) {
            dbConnection = new DBConnection();
        }
        return dbConnection;
    }
}