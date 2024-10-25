package br.com.unifacef.ijb.repositories;

import br.com.unifacef.ijb.models.entities.Expense;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ExpenseRepository extends JpaRepository<Expense, Integer> {
}
