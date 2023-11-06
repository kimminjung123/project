package org.example;

import lombok.Getter;
import lombok.Setter;
import org.example.db.DBConnection;

import java.util.Scanner;

public class Container {
    @Setter
    @Getter
    private static Scanner sc;
    private static DBConnection dbConnection;

    static void scan() {
        sc = new Scanner(System.in);
    }

    public static void close() {
        sc.close();
    }
    public static DBConnection getDBconnection() {
        if (dbConnection == null) {
            dbConnection = new DBConnection();
        }
        return dbConnection;
    }
}