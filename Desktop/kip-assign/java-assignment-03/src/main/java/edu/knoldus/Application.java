package edu.knoldus;

public class Application {

    public static void main(String[] args) {

        final String birthDate = "1993-10-19";
        final String timeZone = "Asia/Kolkata";

        DateOperation.getBirthDayOfWeek(birthDate).thenAccept(birthDayWeek ->
                System.out.println("BirthDayOfWeek " + birthDayWeek));
        DateOperation.getTimeFromTimeZone(timeZone).thenAccept(timezone ->
                System.out.println("New TimeZone " + timezone));
        DateOperation.getLeapYears().thenAccept(leapYear ->
                System.out.println("leap years after 1990 " + leapYear));
        DateOperation.getTotalSecondLived().thenAccept(totalSecLived ->
                System.out.println("Mahatma Gandhi Lived in second " + totalSecLived));

        try {
            Thread.sleep(10000);
        } catch (InterruptedException ie) {
            ie.getStackTrace();
        }
    }
}
