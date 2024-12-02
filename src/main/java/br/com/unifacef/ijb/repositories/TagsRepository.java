package br.com.unifacef.ijb.repositories;

import br.com.unifacef.ijb.models.entities.Tags;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TagsRepository extends JpaRepository<Tags, Integer>{
    
}

