package br.com.unifacef.ijb.repositories;

import br.com.unifacef.ijb.models.entities.DonatedMaterial;
import br.com.unifacef.ijb.models.entities.Material;
import br.com.unifacef.ijb.models.entities.PurchasedMaterial;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface MaterialRepository extends JpaRepository<Material, Integer> {

    List<Material> findAllById(Integer id);

    void deleteByDonatedMaterial(DonatedMaterial donatedMaterial);

    void deleteByPurchasedMaterial(PurchasedMaterial purchasedMaterial);

    @Query("SELECT m FROM Material m " +
           "WHERE m.donatedMaterial.id = :id")
    Optional<Material> findByDonatedMaterialId(@Param("id") Integer id);

    @Query("SELECT m FROM Material m " +
           "WHERE m.purchasedMaterial.id = :id")
    Optional<Material> findByPurchasedMaterialId(Integer id);
}
