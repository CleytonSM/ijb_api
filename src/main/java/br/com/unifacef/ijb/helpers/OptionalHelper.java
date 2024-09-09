package br.com.unifacef.ijb.helpers;

import br.com.unifacef.ijb.exceptions.EntityAlreadyExistsException;

import java.util.Optional;

public class OptionalHelper {

    public static <T> void verifyEntityAlreadyExists(Optional<T> optional) {
        if(optional.isPresent()) {
            T entity = optional.get();
            throw new EntityAlreadyExistsException("This " + entity.getClass().getName() + " already exists.");
        }
    }
}
