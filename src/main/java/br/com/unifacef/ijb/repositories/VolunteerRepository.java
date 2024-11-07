package br.com.unifacef.ijb.repositories;

import br.com.unifacef.ijb.models.entities.Volunteer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VolunteerRepository extends JpaRepository<Volunteer, Long> {}
