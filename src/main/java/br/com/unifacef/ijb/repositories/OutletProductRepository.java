package br.com.unifacef.ijb.repositories;

import br.com.unifacef.ijb.models.entities.OutletProduct;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OutletProductRepository extends JpaRepository<OutletProduct, Integer> {
    @Query("SELECT op FROM OutletProduct op " +
           "WHERE op.name LIKE(CONCAT('%', :search, '%')) ")
    List<OutletProduct> findAllBySearch(String search);
}
