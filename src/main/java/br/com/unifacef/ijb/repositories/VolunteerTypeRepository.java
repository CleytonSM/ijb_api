package br.com.unifacef.ijb.repositories;

import br.com.unifacef.ijb.models.entities.VolunteerType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface VolunteerTypeRepository extends JpaRepository<VolunteerType, Integer> {
    Optional<VolunteerType> findByVolunteerNameType(String volunteerNameType);
}
