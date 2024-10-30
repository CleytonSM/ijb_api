package br.com.unifacef.ijb.repositories;

import br.com.unifacef.ijb.models.entities.Material;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MaterialRepository extends JpaRepository<Material, Integer> {

    List<Material> findAllByMaterialId(Integer id);
}
