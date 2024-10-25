package br.com.unifacef.ijb.repositories;

import br.com.unifacef.ijb.models.entities.Construction;
import br.com.unifacef.ijb.models.entities.Receipt;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReceiptRepository extends JpaRepository<Receipt, Integer> {
}
