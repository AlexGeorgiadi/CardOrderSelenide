package ru.netology.cardorderselenide;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Date {
    String date;
    String name;
    String phone;
    String city;

    public static String setDate(int plusDays) {
        return LocalDate.now().plusDays(plusDays).format(DateTimeFormatter.ofPattern("dd.MM.yyyy"));
    }
}