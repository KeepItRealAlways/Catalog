package org.neriko.catalog.resource_models;

import java.sql.Timestamp;

public class DateTime {
    private Timestamp value;

    public DateTime(Timestamp timestamp) {
        value = timestamp;
    }

    @Override
    public String toString() {
        return value.toInstant().toString();
    }
}
