package br.com.unifacef.ijb.mappers;

import br.com.unifacef.ijb.models.dtos.EventDTO;
import br.com.unifacef.ijb.models.entities.Event;

public class EventMapper {

    public static EventDTO toDTO(Event event) {
        EventDTO dto = new EventDTO();
        dto.setId(event.getId());
        dto.setName(event.getName());
        dto.setDescription(event.getDescription());
        return dto;
    }

    public static Event toEntity(EventDTO dto) {
        Event event = new Event();
        event.setId(dto.getId());
        event.setName(dto.getName());
        event.setDescription(dto.getDescription());
        return event;
    }
}
