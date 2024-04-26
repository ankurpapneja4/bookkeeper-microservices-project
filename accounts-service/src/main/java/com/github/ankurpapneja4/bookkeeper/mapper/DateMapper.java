package com.github.ankurpapneja4.bookkeeper.mapper;

import org.springframework.stereotype.Component;

import java.sql.Timestamp;
import java.time.OffsetDateTime;
import java.time.ZoneOffset;

@Component
public class DateMapper {

    public OffsetDateTime toOffsetDateTime(Timestamp timestamp){
        // Null Check
        if(timestamp == null) return null;
        // Convert
        return OffsetDateTime.ofInstant( timestamp.toInstant(), ZoneOffset.UTC );
    }

    public Timestamp toTimestamp(OffsetDateTime offsetDateTime){
        // Null Check
        if(offsetDateTime == null) return null;
        // Convert
        return Timestamp.from( offsetDateTime.toInstant() );
    }
}
