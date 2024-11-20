package br.com.unifacef.ijb.mappers;

import br.com.unifacef.ijb.models.dtos.*;
import br.com.unifacef.ijb.models.entities.Construction;
import br.com.unifacef.ijb.models.entities.OutletProduct;

import java.util.ArrayList;
import java.util.List;

public class ConstructionMapper {
    public static Construction convertConstructionCreateDTOIntoConstruction(
            ConstructionCreateDTO constructionCreate) {
        return new Construction(AddressMapper.convertAddressCreateDTOIntoAddress(constructionCreate.getAddress()),
                constructionCreate.getDescription(), constructionCreate.getStartDate(), constructionCreate.getEndDate(),
                constructionCreate.getConstructionStatus(), constructionCreate.getEstimatedCost(), constructionCreate.getTotalCost());
    }

    public static ConstructionDTO convertConstructionIntoConstructionDTO(Construction construction) {
        return new ConstructionDTO(construction.getId(),
                AddressMapper.convertAddressIntoAddressDTO(construction.getAddress()),
                construction.getDescription(), construction.getStartDate(), construction.getEndDate(),
                construction.getConstructionStatus(), construction.getEstimatedCost(), construction.getTotalCost());
    }

    public static List<ConstructionDTO> convertListOfConstructionIntoListOfConstructionDTO(
            List<Construction> constructions) {
        List<ConstructionDTO> constructionDTOs = new ArrayList<>();

        for (Construction construction : constructions) {
            constructionDTOs.add(convertConstructionIntoConstructionDTO(construction));
        }

        return constructionDTOs;
    }

    public static void updateConstruction(ConstructionDTO constructionUpdate, Construction construction) {
        construction.setAddress(AddressMapper.convertAddressDTOIntoAddress(constructionUpdate.getAddress()));
        construction.setDescription(constructionUpdate.getDescription());
        construction.setStartDate(construction.getStartDate());
        construction.setEndDate(construction.getEndDate());
        construction.setConstructionStatus(construction.getConstructionStatus());
        construction.setEstimatedCost(construction.getEstimatedCost());
        construction.setTotalCost(construction.getTotalCost());
    }

    public static Construction convertConstructionDTOIntoConstruction(ConstructionDTO construction) {
        return new Construction(AddressMapper.convertAddressDTOIntoAddress(construction.getAddress()),
                construction.getDescription(), construction.getStartDate(),
                construction.getEndDate(), construction.getConstructionStatus(),
                construction.getEstimatedCost(), construction.getTotalCost());
    }
}