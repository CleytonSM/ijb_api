package br.com.unifacef.ijb.repositories;

import br.com.unifacef.ijb.models.entities.Movement;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MovementRepository extends JpaRepository<Movement, Integer> {
}
