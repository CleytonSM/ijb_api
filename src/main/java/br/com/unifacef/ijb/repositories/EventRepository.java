package br.com.unifacef.ijb.repositories;

import br.com.unifacef.ijb.models.entities.Event;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EventRepository extends JpaRepository<Event, Long> {
    
}
