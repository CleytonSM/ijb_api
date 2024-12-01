//package br.com.unifacef.ijb.mappers;
//
//import br.com.unifacef.ijb.models.dtos.RebateCreateDTO;
//import br.com.unifacef.ijb.models.dtos.RebateDTO;
//import br.com.unifacef.ijb.models.entities.Exchange;
//import br.com.unifacef.ijb.models.entities.Rebate;
//
//import java.time.LocalDateTime;
//import java.util.ArrayList;
//import java.util.List;
//
//public class RebateMapper {
//    public static Rebate convertRebateCreateDTOIntoRebate(RebateCreateDTO rebateCreate) {
//        return new Rebate(ExchangeMapper.convertExchangeDTOIntoExchange(rebateCreate.getExchange()),
//                rebateCreate.getDescription(), rebateCreate.getRebateValue());
//    }
//
//    public static RebateDTO convertRebateIntoRebateDTO(Rebate rebate) {
//        return new RebateDTO(rebate.getId(), ExchangeMapper.convertExchangeIntoExchangeDTO(rebate.getExchange()),
//                rebate.getDescription(), rebate.getRebateValue());
//    }
//
//    public static List<RebateDTO> convertListOfRebateIntoListOfRebateDTO(List<Rebate> rebates) {
//        List<RebateDTO> rebateDTOs = new ArrayList<>();
//
//        for (Rebate rebate : rebates) {
//            rebateDTOs.add(convertRebateIntoRebateDTO(rebate));
//        }
//
//        return rebateDTOs;
//    }
//
//    public static void updateRebate(RebateDTO rebateUpdate, Rebate rebate) {
//        rebate.setExchange(ExchangeMapper.convertExchangeDTOIntoExchange(rebateUpdate.getExchange()));
//        rebate.setDescription(rebateUpdate.getDescription());
//        rebate.setRebateValue(rebateUpdate.getRebateValue());
//    }
//}
