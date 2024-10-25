package br.com.unifacef.ijb.repositories;

import br.com.unifacef.ijb.models.entities.Invoices;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InvoicesRepository extends JpaRepository<Invoices, Integer> {
}
