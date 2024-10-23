package br.com.unifacef.ijb.repositories;

import br.com.unifacef.ijb.models.entities.Donation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DonationRepository extends JpaRepository<Donation, Integer> {
}
