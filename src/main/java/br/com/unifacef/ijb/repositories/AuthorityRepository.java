package br.com.unifacef.ijb.repositories;

import br.com.unifacef.ijb.models.entities.Authority;
import br.com.unifacef.ijb.models.enums.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AuthorityRepository extends JpaRepository<Authority, Integer> {
    Authority findByRole(Role role);
}
