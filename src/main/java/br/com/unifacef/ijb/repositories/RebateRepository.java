package br.com.unifacef.ijb.repositories;

import br.com.unifacef.ijb.models.entities.Rebate;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RebateRepository extends JpaRepository<Rebate, Integer> {
}
