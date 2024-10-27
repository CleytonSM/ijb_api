package br.com.unifacef.ijb.repositories;

import br.com.unifacef.ijb.models.entities.OutletProduct;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface OutletProductRepository extends JpaRepository<OutletProduct, Integer> {
    List<OutletProduct> findAllByOutletProductName(String outletProductName);

    List<OutletProduct> findAllByOutletProductDescription(String outletProductDescription);
}
