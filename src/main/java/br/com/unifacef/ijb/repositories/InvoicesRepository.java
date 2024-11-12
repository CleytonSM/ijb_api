package br.com.unifacef.ijb.repositories;

import br.com.unifacef.ijb.models.entities.Invoice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InvoicesRepository extends JpaRepository<Invoice, Integer> {
}
