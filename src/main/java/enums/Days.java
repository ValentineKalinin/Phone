package main.java.enums;

public enum Days {
    MONDAY("Monday"), TUESDAY("Tuesday"),
    WEDNESDAY("Wednesday"), THURSDAY("Thursday"),
    FRIDAY("Friday"), SATURDAY("Saturday"),
    SUNDAY("Sunday");

    private final String day;

    Days(String day) {
        this.day = day;
    }

    public String getDay() {
        return day;
    }
}