package br.com.unifacef.ijb.repositories;

import br.com.unifacef.ijb.models.entities.Movement;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MovementRepository extends JpaRepository<Movement, Integer> {
}
