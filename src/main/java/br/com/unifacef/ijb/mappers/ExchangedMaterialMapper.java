package br.com.unifacef.ijb.mappers;

import br.com.unifacef.ijb.models.dtos.*;
import br.com.unifacef.ijb.models.entities.*;

import java.util.ArrayList;
import java.util.List;

public class ExchangedMaterialMapper {
    public static ExchangedMaterial convertExchangedMaterialCreateDTOIntoExchangedMaterial(
            ExchangedMaterialCreateDTO exchangedMaterialCreate) {
        return new ExchangedMaterial(MaterialMapper.convertMaterialCreateDTOIntoMaterial(exchangedMaterialCreate.getMaterial()),
                ExchangeMapper.convertExchangeCreateDTOIntoExchange(exchangedMaterialCreate.getExchange()));
    }

    public static ExchangedMaterialDTO convertExchangedMaterialIntoExchangedMaterialDTO(ExchangedMaterial exchangedMaterial) {
        return new ExchangedMaterialDTO(MaterialMapper.convertMaterialIntoMaterialDTO(exchangedMaterial.getMaterials()),
                ExchangeMapper.convertExchangeIntoExchangeDTO(exchangedMaterial.getExchange()));
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
        exchangedMaterial.setMaterials(MaterialMapper.convertMaterialDTOIntoMaterial(exchangedMaterialUpdate.getMaterial()));
        exchangedMaterial.setExchange(ExchangeMapper.convertExchangeDTOIntoExchange(exchangedMaterialUpdate.getExchange()));
    }

    public static ExchangedMaterial convertExchangedMaterialDTOIntoExchangedMaterial(ExchangedMaterialDTO exchangedMaterial) {
        return new ExchangedMaterial(MaterialMapper.convertMaterialDTOIntoMaterial(exchangedMaterial.getMaterial()),
                ExchangeMapper.convertExchangeDTOIntoExchange(exchangedMaterial.getExchange())
                );

    }
}
