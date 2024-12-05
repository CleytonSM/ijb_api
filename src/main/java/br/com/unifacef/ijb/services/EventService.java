package br.com.unifacef.ijb.services;

import br.com.unifacef.ijb.repository.EventRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EventService {

    @Autowired
    private EventRepository repository;

    public void saveEvent() {
        repository.saveEvent();
    }
}