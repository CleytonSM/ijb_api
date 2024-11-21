package br.com.unifacef.ijb.helpers;

import br.com.unifacef.ijb.exceptions.EntityAlreadyExistsException;
import jakarta.persistence.EntityNotFoundException;

import java.util.Optional;

public class OptionalHelper {

    public static <T> void verifyEntityAlreadyExists(Optional<T> optionalEntity) {
        if(optionalEntity.isPresent()) {
            throw new EntityAlreadyExistsException("This entity already exists.");
        }
    }

    public static <T> T getOptionalEntity(Optional<T> optionalEntity) {
        if(optionalEntity.isEmpty()) {
            throw new EntityNotFoundException("This entity doesn't exist");
        }

        return optionalEntity.get();
    }
}
