package br.com.unifacef.ijb.repositories;

import br.com.unifacef.ijb.models.entities.DonatedMaterial;
import br.com.unifacef.ijb.models.entities.OutletProduct;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DonatedMaterialRepository extends JpaRepository<DonatedMaterial, Integer> {
    List<DonatedMaterial> findAllByDonatedMaterialName(String donatedMaterialName);

}
