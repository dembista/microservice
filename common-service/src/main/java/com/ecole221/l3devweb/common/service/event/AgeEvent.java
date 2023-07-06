package com.ecole221.l3devweb.common.service.event;

import com.ecole221.l3devweb.common.service.dto.PersonneAgeDto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
import java.util.UUID;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class AgeEvent implements  Event{

    private AgeStatus ageStatus;
    private PersonneAgeDto personneAgeDto;

    private UUID eventId = UUID.randomUUID();

    private Date eventDate = new Date();

    @Override
    public UUID getEventId() {
        return eventId;
    }

    @Override
    public Date getEventDate() {
        return eventDate;
    }
}
