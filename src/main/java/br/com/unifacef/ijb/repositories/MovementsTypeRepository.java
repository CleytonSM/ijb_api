package br.com.unifacef.ijb.repositories;

import br.com.unifacef.ijb.models.entities.MovementsType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MovementsTypeRepository extends JpaRepository<MovementsType, Integer> {
}
