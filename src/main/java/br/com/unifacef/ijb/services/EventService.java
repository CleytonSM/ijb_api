package br.com.unifacef.ijb.services;

import br.com.unifacef.ijb.repository.EventRepository;

public class EventService {

    private final EventRepository eventRepository;

    public EventService(EventRepository eventRepository) {
        this.eventRepository = eventRepository;
    }

    public void saveEvent() {
        eventRepository.saveEvent();
    }
}
