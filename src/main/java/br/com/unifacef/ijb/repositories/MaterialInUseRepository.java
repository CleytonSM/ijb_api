package br.com.unifacef.ijb.repositories;

import br.com.unifacef.ijb.models.entities.MaterialInUse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MaterialInUseRepository extends JpaRepository<MaterialInUse, Integer> {
}
