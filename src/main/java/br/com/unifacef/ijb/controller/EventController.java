package br.com.unifacef.ijb.controller;

import br.com.unifacef.ijb.models.dtos.EventDTO;
import br.com.unifacef.ijb.mappers.EventMapper;
import br.com.unifacef.ijb.models.entities.Event;
import br.com.unifacef.ijb.services.EventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/events")
public class EventController {

    @Autowired
    private EventService eventService;

    @GetMapping
    public ResponseEntity<List<EventDTO>> getAllEvents() {
        List<EventDTO> events = eventService.getAllEvents()
                .stream()
                .map(EventMapper::toDTO)
                .collect(Collectors.toList());
        return ResponseEntity.ok(events);
    }

    @GetMapping("/{id}")
    public ResponseEntity<EventDTO> getEventById(@PathVariable Long id) {
        Event event = eventService.getEventById(id);
        return ResponseEntity.ok(EventMapper.toDTO(event));
    }

    @PostMapping
    public ResponseEntity<EventDTO> createEvent(@RequestBody EventDTO eventDTO) {
        Event event = EventMapper.toEntity(eventDTO);
        Event createdEvent = eventService.createEvent(event);
        return ResponseEntity.ok(EventMapper.toDTO(createdEvent));
    }

    @PutMapping("/{id}")
    public ResponseEntity<EventDTO> updateEvent(@PathVariable Long id, @RequestBody EventDTO eventDTO) {
        Event event = EventMapper.toEntity(eventDTO);
        Event updatedEvent = eventService.updateEvent(id, event);
        return ResponseEntity.ok(EventMapper.toDTO(updatedEvent));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteEvent(@PathVariable Long id) {
        eventService.deleteEvent(id);
        return ResponseEntity.ok().build();
    }
}