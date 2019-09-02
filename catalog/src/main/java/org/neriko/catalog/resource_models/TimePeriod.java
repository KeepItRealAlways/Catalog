package org.neriko.catalog.resource_models;

public class TimePeriod {
    private DateTime startDateTime;
    private DateTime endDateTime;

    public TimePeriod(DateTime begin, DateTime end) {
        startDateTime = begin;
        endDateTime = end;
    }
}
