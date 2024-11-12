package br.com.unifacef.ijb.repositories;

import br.com.unifacef.ijb.models.entities.DonatedMaterial;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DonatedMaterialRepository extends JpaRepository<DonatedMaterial, Integer> {
    List<DonatedMaterial> findAllByMaterialName(String materialName);

}
