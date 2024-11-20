package br.com.unifacef.ijb.repositories;

import br.com.unifacef.ijb.models.entities.VolunteerType;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface VolunteerTypeRepository extends JpaRepository<VolunteerType, Integer> {

    Optional<VolunteerType> findByVolunteerNameType(String volunteerNameType); // Método para busca pelo nome
}
