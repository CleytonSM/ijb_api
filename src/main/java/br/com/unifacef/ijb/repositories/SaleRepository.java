//package br.com.unifacef.ijb.repositories;
//
//import br.com.unifacef.ijb.models.entities.Sale;
//import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.data.jpa.repository.Query;
//import org.springframework.stereotype.Repository;
//
//import java.util.List;
//
//@Repository
//public interface SaleRepository extends JpaRepository<Sale, Integer> {
//    @Query("SELECT s FROM Sale s " +
//           "WHERE (s.outletProduct.outletProductName LIKE(CONCAT('%', :search, '%')) " +
//           "OR s.saleDescription LIKE(CONCAT('%', :search, '%'))) " +
//           "AND s.outletProduct.status = SOLD")
//    List<Sale> findAllBySearch(String search);
//}
