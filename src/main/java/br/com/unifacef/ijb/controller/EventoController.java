package com.example.ijbapi.controller;

import com.example.ijbapi.model.Evento;
import com.example.ijbapi.service.EventoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/eventos")
public class EventoController {

    @Autowired
    private EventoService eventoService;

    @GetMapping
    public ResponseEntity<List<Evento>> getAllEventos() {
        List<Evento> eventos = eventoService.getAllEventos();
        return ResponseEntity.ok(eventos);
    }


    @GetMapping("/{id}")
    public ResponseEntity<Evento> getEventoById(@PathVariable Long id) {
        Evento evento = eventoService.getEventoById(id);
        return ResponseEntity.ok(evento);
    }

    @PostMapping
    public ResponseEntity<Evento> createEvento(@RequestBody Evento evento) {
        Evento novoEvento = eventoService.createEvento(evento);
        return ResponseEntity.ok(novoEvento);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Evento> updateEvento(@PathVariable Long id, @RequestBody Evento evento) {
        Evento eventoAtualizado = eventoService.updateEvento(id, evento);
        return ResponseEntity.ok(eventoAtualizado);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteEvento(@PathVariable Long id) {
        eventoService.deleteEvento(id);
        return ResponseEntity.noContent().build();
    }
}
