package util;

import java.time.LocalDate;

public class Util {
    public static String nowDateTime(){
        LocalDate now = LocalDate.now();
        return  now.toString();
    }
}