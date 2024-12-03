package br.com.unifacef.ijb.repositories;

import br.com.unifacef.ijb.models.entities.Material;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface MaterialRepository extends JpaRepository<Material, Integer> {
    @Query("SELECT m FROM Material m WHERE m.name LIKE(CONCAT('%', :search, '%'))")
    List<Material> findAllBySearch(String search);
}
