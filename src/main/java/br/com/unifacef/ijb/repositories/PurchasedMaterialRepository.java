package br.com.unifacef.ijb.repositories;

import br.com.unifacef.ijb.models.entities.PurchasedMaterial;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PurchasedMaterialRepository extends JpaRepository<PurchasedMaterial, Integer> {
}
