package br.com.unifacef.ijb.repositories;

import br.com.unifacef.ijb.models.entities.OutletProduct;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OutletProductRepository extends JpaRepository<OutletProduct, Integer> {
}
