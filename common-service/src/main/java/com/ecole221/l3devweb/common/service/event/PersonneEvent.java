package com.ecole221.l3devweb.common.service.event;

import com.ecole221.l3devweb.common.service.dto.PersonneDto;
import lombok.*;

import java.util.Date;
import java.util.UUID;

@Setter
@Getter
@NoArgsConstructor
public class PersonneEvent implements Event {

    private PersonneDto personneDto;

    private PersonneStatus personneStatus;

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

    public PersonneEvent(PersonneDto personneDto, PersonneStatus personneStatus) {
        this.personneDto = personneDto;
        this.personneStatus = personneStatus;
    }
}
