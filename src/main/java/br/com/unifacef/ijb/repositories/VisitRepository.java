package br.com.unifacef.ijb.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.unifacef.ijb.models.entities.Visit;

@Repository
public interface VisitRepository extends JpaRepository<Visit, Integer>{
}
