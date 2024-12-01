//package br.com.unifacef.ijb.services;
//
//import br.com.unifacef.ijb.helpers.OptionalHelper;
//import br.com.unifacef.ijb.models.dtos.SaleCreateDTO;
//import br.com.unifacef.ijb.models.dtos.SaleDTO;
//import br.com.unifacef.ijb.models.entities.Sale;
//import br.com.unifacef.ijb.repositories.SaleRepository;
//import jakarta.transaction.Transactional;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import java.util.List;
//import java.util.Optional;
//
//@Service
//public class SaleService {
//    @Autowired
//    private SaleRepository repository;
//
//    public Sale save(Sale sale) {
//        return repository.save(sale);
//    }
//
//    public Sale getById(Integer id) {
//        return OptionalHelper.getOptionalEntity(repository.findById(id));
//    }
//
//    @Transactional
//    public SaleDTO createSale(SaleCreateDTO saleCreate) {
//        Sale sale = SaleMapper.convertSaleCreateDTOIntoSale(saleCreate);
//
//        return SaleMapper.convertSaleIntoSaleDTO(save(sale));
//    }
//
//    public List<SaleDTO> getAllSales() {
//        return SaleMapper.convertListOfSaleIntoListOfSaleDTO(repository.findAll());
//    }
//
//    @Transactional
//    public SaleDTO updateOutletProduct(SaleDTO saleUpdate) {
//        Sale sale = getById(saleUpdate.getId());
//        updateRetrievedEntity(saleUpdate, sale);
//
//        return SaleMapper.convertSaleIntoSaleDTO(save(sale));
//    }
//
//
//    private void updateRetrievedEntity(SaleDTO saleUpdate, Sale sale) {
//        SaleMapper.updateSale(saleUpdate, sale);
//    }
//
//    public List<SaleDTO> findByFilter(String search) {
//        List<Sale> sales = findSalesBySearch(search);
//        if(Optional.ofNullable(sales).isPresent() && !sales.isEmpty()) {
//            return SaleMapper.convertListOfSaleIntoListOfSaleDTO(sales);
//        }
//
//        return null;
//    }
//
//    private List<Sale> findSalesBySearch(String search) {
//        return repository.findAllBySearch(search);
//    }
//
//    public void deleteById(Integer id) {
//        repository.delete(getById(id));
//    }
//}
