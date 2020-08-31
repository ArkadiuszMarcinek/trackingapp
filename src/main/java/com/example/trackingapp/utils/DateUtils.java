package com.example.trackingapp.utils;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Optional;

@NoArgsConstructor(access = AccessLevel.PRIVATE)

public class DateUtils {

    public static LocalDateTime getIndefinite() {
        return LocalDateTime.of(9999, 12, 31, 23, 59, 59);
    }

    public static DateTimeFormatter getISODateFormatted() {
        return DateTimeFormatter.ISO_LOCAL_DATE_TIME;
    }

    public static DateTimeFormatter getDateFormatted() {
        return DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
    }

    public static String getFormattedDate(LocalDateTime dateTo) {
        return Optional.ofNullable(dateTo)
                .map(dateTime -> dateTime.format(DateUtils.getDateFormatted()))
                .orElse("");
    }

    public static LocalDateTime getLocalDateTime(String dateTo) {
        return Optional.ofNullable(dateTo)
                .filter(formattedDateTo -> !formattedDateTo.isEmpty())
                .map(formattedDateTo -> LocalDateTime.parse(formattedDateTo, DateUtils.getISODateFormatted()))
                .orElse(null);
    }
}
