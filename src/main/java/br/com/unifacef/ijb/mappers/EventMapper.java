package br.com.unifacef.ijb.mapper;

import br.com.unifacef.ijb.dto.EventDTO;
import br.com.unifacef.ijb.model.Event;

public class EventMapper {

    
    public static EventDTO toDTO(Event event) {
        EventDTO dto = new EventDTO();
        dto.setId(event.getId());
        dto.setName(event.getName());
        dto.setDescription(event.getDescription());
        dto.setDate(event.getDate());
        dto.setState(event.getState());
        dto.setCode(event.getCode());
        return dto;
    }

    
    public static Event toEntity(EventDTO dto) {
        Event event = new Event();
        event.setId(dto.getId());
        event.setName(dto.getName());
        event.setDescription(dto.getDescription());
        event.setDate(dto.getDate());
        event.setState(dto.getState());
        event.setCode(dto.getCode());
        return event;
    }
}    
