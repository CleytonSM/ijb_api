package br.com.unifacef.ijb.repositories;

import br.com.unifacef.ijb.models.entities.DonationType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DonationTypeRepository extends JpaRepository<DonationType, Integer> {
}
