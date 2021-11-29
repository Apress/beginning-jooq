package com.apress.jooq.record.converter;

import org.jooq.Converter;

import java.time.Instant;
import java.time.Year;
import java.time.temporal.ChronoField;

public class YearConverter implements Converter<Long, Year> {
    @Override
    public Year from(Long columnValue) {
       return Year.from(Instant.ofEpochMilli(columnValue));
    }

    @Override
    public Long to(Year userValue) {
        return userValue.getLong(ChronoField.YEAR);
    }

    @Override
    public Class<Long> fromType() {
        return Long.class;
    }

    @Override
    public Class<Year> toType() {
        return Year.class;
    }
}
