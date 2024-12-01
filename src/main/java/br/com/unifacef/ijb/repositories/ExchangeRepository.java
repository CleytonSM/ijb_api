package br.com.unifacef.ijb.repositories;

import br.com.unifacef.ijb.models.entities.Exchange;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ExchangeRepository extends JpaRepository<Exchange, Integer> {
    @Query("SELECT e FROM Exchange e " +
           "WHERE (e.outletProduct.outletProductName LIKE(CONCAT('%', :search, '%')) " +
           "OR e.exchangesDescription LIKE(CONCAT('%', :search, '%'))) " +
           "AND e.outletProduct.status = EXCHANGED")
    List<Exchange> findAllBySearch(String search);
}
