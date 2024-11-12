package br.com.unifacef.ijb.mappers;

import br.com.unifacef.ijb.models.dtos.*;
import br.com.unifacef.ijb.models.entities.*;

import java.util.ArrayList;
import java.util.List;

public class ExchangedMaterialMapper {
    public static ExchangedMaterial convertExchangedMaterialCreateDTOIntoExchangedMaterial(
            ExchangedMaterialCreateDTO exchangedMaterialCreate) {
        return new ExchangedMaterial();
    }

    public static ExchangedMaterialDTO convertExchangedMaterialIntoExchangedMaterialDTO(ExchangedMaterial exchangedMaterial) {
        return new ExchangedMaterialDTO();
    }

    public static List<ExchangedMaterialDTO> convertListOfExchangedMaterialIntoListOfExchangedMaterialDTO(
            List<ExchangedMaterial> exchangedMaterials) {
        List<ExchangedMaterialDTO> exchangedMaterialDTOS = new ArrayList<>();

        for (ExchangedMaterial exchangedMaterial : exchangedMaterials) {
            exchangedMaterialDTOS.add(convertExchangedMaterialIntoExchangedMaterialDTO(exchangedMaterial));
        }

        return exchangedMaterialDTOS;
    }

    public static void updateExchangedMaterial(ExchangedMaterialDTO exchangedMaterialUpdate, ExchangedMaterial exchangedMaterial) {
        exchangedMaterial.setExchange(ExchangeMapper.convertExchangeDTOIntoExchange(exchangedMaterialUpdate.getExchange()));
    }

    public static ExchangedMaterial convertExchangedMaterialDTOIntoExchangedMaterial(ExchangedMaterialDTO exchangedMaterial) {
        return new ExchangedMaterial();

    }
}
