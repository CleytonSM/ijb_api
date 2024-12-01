package br.com.unifacef.ijb.repositories;

import br.com.unifacef.ijb.models.entities.DonatedMaterial;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DonatedMaterialRepository extends JpaRepository<DonatedMaterial, Integer> {
    List<DonatedMaterial> findAllByMaterialName(String materialName);

    @Query("SELECT dm FROM DonatedMaterial dm " +
           "WHERE dm.materialName LIKE(CONCAT('%', :search, '%')) " +
           "OR dm.description LIKE(CONCAT('%', :search, '%'))")
    List<DonatedMaterial> findAllBySearch(@Param("search") String search);
}
