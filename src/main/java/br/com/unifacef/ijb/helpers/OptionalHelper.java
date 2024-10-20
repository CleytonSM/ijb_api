package br.com.unifacef.ijb.helpers;

import br.com.unifacef.ijb.exceptions.EntityAlreadyExistsException;
import jakarta.persistence.EntityNotFoundException;

import java.util.Optional;

public class OptionalHelper {

    public static <T> void verifyEntityAlreadyExists(Optional<T> optionalEntity) {
        if(optionalEntity.isPresent()) {
            T entity = optionalEntity.get();
            throw new EntityAlreadyExistsException("This " + entity.getClass().getName() + " already exists.");
        }
    }

    public static <T> T getOptionalEntity(Optional<T> optionalEntity) {
        if(optionalEntity.isEmpty()) {
            T entity = optionalEntity.get();
            throw new EntityNotFoundException("This " + entity.getClass().getName() + "  doesn't exist");
        }

        return optionalEntity.get();
    }
}
