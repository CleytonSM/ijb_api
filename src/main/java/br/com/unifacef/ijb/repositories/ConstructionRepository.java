package br.com.unifacef.ijb.repositories;

import br.com.unifacef.ijb.models.entities.Construction;
import br.com.unifacef.ijb.models.entities.OutletProduct;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ConstructionRepository extends JpaRepository<Construction, Integer> {
    List<Construction> findAllByConstructionDescription(String constructionDescription);
}
