package br.com.unifacef.ijb.repositories;

import br.com.unifacef.ijb.models.entities.MovementsSituation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface MovementsSituationRepository extends JpaRepository<MovementsSituation, Integer> {
}
