package edu.knoldus;

import java.math.BigInteger;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;

/**
 * date operation (timezone,birthDayWeeks,leapYears,gandhi lived in second).
 */
public class DateOperation {

    /**
     * @param birthDay as input.
     * @return day of weeks.
     */
    private static List<String> birthWeek(String birthDay) {
        List<String> birthDayOfWeek = new ArrayList<>();
        LocalDate birthDate = LocalDate.parse(birthDay);
        while (birthDate.isBefore(LocalDate.now())) {
            birthDayOfWeek.add(birthDate.getDayOfWeek().toString());
            birthDate = birthDate.plusYears(1);
        }
        return birthDayOfWeek;
    }

    /**
     * @param timeZone as input.
     * @return according to given timezone.
     */
    private static String timeFromTimeZone(String timeZone) {
        LocalDateTime localDateTime = LocalDateTime.now();
        ZoneId zoneId = ZoneId.of(timeZone);
        return ZonedDateTime.of(localDateTime, zoneId).toString();
    }

    /**
     * @return leap years after 1990.
     */
    private static List<Integer> leapYears() {
        LocalDate currentDate = LocalDate.parse("1900-01-01");
        List<Integer> leapYearList = new ArrayList<>();
        while (currentDate.isBefore(LocalDate.now())) {
            if (currentDate.isLeapYear()) {
                leapYearList.add(currentDate.getYear());
            }
            currentDate = currentDate.plusYears(1);
        }
        return leapYearList;
    }

    /**
     * @return mahatma gandhi lived in second.
     */
    private static BigInteger mahatmaGandhiLived() {

        LocalDate birthDay = LocalDate.parse("1869-10-02");
        LocalDate deathDay = LocalDate.parse("1948-01-30");
        BigInteger dayInSecond = new BigInteger("86400");
        long days = ChronoUnit.DAYS.between(birthDay, deathDay);
        return dayInSecond.multiply(BigInteger.valueOf(days));
    }

    public static CompletableFuture<List<String>> getBirthDayOfWeek(final String birthDay) {
        return CompletableFuture.supplyAsync(() -> birthWeek(birthDay));
    }

    public static CompletableFuture<String> getTimeFromTimeZone(final String timeZone) {
        return CompletableFuture.supplyAsync(() -> timeFromTimeZone(timeZone));
    }

    public static CompletableFuture<List<Integer>> getLeapYears() {
        return CompletableFuture.supplyAsync(() -> leapYears());
    }

    public static CompletableFuture<BigInteger> getTotalSecondLived() {
        return CompletableFuture.supplyAsync(() -> mahatmaGandhiLived());
    }
}
