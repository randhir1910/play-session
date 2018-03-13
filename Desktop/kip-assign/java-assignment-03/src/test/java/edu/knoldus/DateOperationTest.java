package edu.knoldus;

import org.junit.Test;

import java.math.BigInteger;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

import static org.junit.Assert.assertEquals;

public class DateOperationTest {


    @Test
    public void addTest() throws Exception {
        final String birthDate = "1993-10-19";
        final String timeZone = "Asia/Kolkata";
        DateOperation.getBirthDayOfWeek(birthDate).thenAccept(birthDayWeek -> System.out.println("BirthDayOfWeek " + birthDayWeek));
        DateOperation.getTimeFromTimeZone(timeZone).thenAccept(timezone -> System.out.println("New TimeZone " + timezone));
        DateOperation.getLeapYears().thenAccept(leapYear -> System.out.println("leap year after 1990 " + leapYear));
        DateOperation.getTotalSecondLived().thenAccept(totalSecLived -> System.out.println("Mahatma Gandhi Lived in second " + totalSecLived));

        List<String> birthWeekDays = Arrays.asList("TUESDAY", "WEDNESDAY", "THURSDAY", "SATURDAY", "SUNDAY", "MONDAY", "TUESDAY", "THURSDAY",
                "FRIDAY", "SATURDAY", "SUNDAY", "TUESDAY", "WEDNESDAY", "THURSDAY", "FRIDAY", "SUNDAY", "MONDAY", "TUESDAY",
                "WEDNESDAY", "FRIDAY", "SATURDAY", "SUNDAY", "MONDAY", "WEDNESDAY", "THURSDAY");
        List<Integer> leapYear = Arrays.asList(1904, 1908, 1912, 1916, 1920, 1924, 1928, 1932, 1936, 1940, 1944, 1948, 1952, 1956,
                1960, 1964, 1968, 1972, 1976, 1980, 1984, 1988, 1992, 1996, 2000, 2004, 2008, 2012, 2016);
        BigInteger livedInSecond = new BigInteger("2471731200");
        String newTimeZone = LocalDateTime.now().toString();

        assertEquals(birthWeekDays, DateOperation.getBirthDayOfWeek(birthDate).toCompletableFuture()
                .get(5, TimeUnit.SECONDS));
        assertEquals(leapYear, DateOperation.getLeapYears().toCompletableFuture()
                .get(5, TimeUnit.SECONDS));
        assertEquals(livedInSecond, DateOperation.getTotalSecondLived().toCompletableFuture()
                .get(5, TimeUnit.SECONDS));
        assertEquals(newTimeZone.substring(0, 11), DateOperation.getTimeFromTimeZone(timeZone).toCompletableFuture()
                .get(5, TimeUnit.SECONDS).substring(0, 11));

    }

}
