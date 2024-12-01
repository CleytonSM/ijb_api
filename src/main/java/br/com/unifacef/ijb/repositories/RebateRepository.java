package br.com.unifacef.ijb.repositories;

import br.com.unifacef.ijb.models.entities.Rebate;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RebateRepository extends JpaRepository<Rebate, Integer> {
    @Query("SELECT r FROM Rebate r " +
           "WHERE (r.exchange.outletProduct.outletProductName LIKE(CONCAT('%', :search, '%')) " +
           "OR r.description LIKE(CONCAT('%', :search, '%'))) " +
           "AND r.exchange.outletProduct.status = REBATED")
    List<Rebate> findAllBySearch(String search);
}
