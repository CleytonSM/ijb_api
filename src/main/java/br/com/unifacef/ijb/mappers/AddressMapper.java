package br.com.unifacef.ijb.mappers;

import br.com.unifacef.ijb.models.dtos.AddressCreateDTO;
import br.com.unifacef.ijb.models.dtos.AddressDTO;
import br.com.unifacef.ijb.models.dtos.PurchasedMaterialCreateDTO;
import br.com.unifacef.ijb.models.dtos.PurchasedMaterialDTO;
import br.com.unifacef.ijb.models.entities.Address;
import br.com.unifacef.ijb.models.entities.PurchasedMaterial;

import java.util.ArrayList;
import java.util.List;

public class AddressMapper {

    public static Address convertAddressCreateDTOIntoAddress(
            AddressCreateDTO addressCreate) {
        return new Address(
                addressCreate.getCep(), addressCreate.getStreet(), addressCreate.getNumber(), addressCreate.getNeighborhood(),
                addressCreate.getComplement()
        );
    }

    public static AddressDTO convertAddressIntoAddressDTO(Address address) {
        return new AddressDTO(
                address.getId(),
                address.getCep(),
                address.getStreet(),
                address.getNumber(),
                address.getNeighborhood(),
                address.getComplement()
        );
    }

    public static List<AddressDTO> convertListOfAddressIntoListOfAddressDTO(
            List<Address> addresses) {
        List<AddressDTO> addressDTOs = new ArrayList<>();

        for (Address address : addresses) {
            addressDTOs.add(convertAddressIntoAddressDTO(address));
        }

        return addressDTOs;
    }

    public static void updateAddress(AddressDTO addressUpdate, Address address) {
        address.setCep(addressUpdate.getCep());
        address.setStreet(addressUpdate.getStreet());
        address.setNumber(addressUpdate.getNumber());
        address.setNeighborhood(addressUpdate.getNeighborhood());
        address.setComplement(addressUpdate.getComplement());

    }


    public static Address convertAddressDTOIntoAddress(AddressDTO addressDTO) {
        return new Address(
                addressDTO.getCep(),
                addressDTO.getStreet(),
                addressDTO.getNumber(),
                addressDTO.getNeighborhood(),
                addressDTO.getComplement()

        );
    }
}
