package br.com.unifacef.ijb.repositories;

import br.com.unifacef.ijb.models.entities.PurchasedMaterial;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PurchasedMaterialRepository extends JpaRepository<PurchasedMaterial, Integer> {

    List<PurchasedMaterial> findAllByMaterialName(String name);

    @Query("SELECT pm FROM PurchasedMaterial pm " +
           "WHERE pm.materialName LIKE(CONCAT('%', :search, '%')) " +
           "OR pm.description LIKE(CONCAT('%', :search, '%'))")
    List<PurchasedMaterial> findAllBySearch(String search);
}
