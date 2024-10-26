package br.com.unifacef.ijb.repositories;

import br.com.unifacef.ijb.models.entities.MovementsOrigin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MovementsOriginRepository extends JpaRepository<MovementsOrigin, Integer> {
}
