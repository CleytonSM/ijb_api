package br.com.unifacef.ijb.repositories;

import br.com.unifacef.ijb.models.entities.Exchange;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ExchangeRepository extends JpaRepository<Exchange, Integer> {
}