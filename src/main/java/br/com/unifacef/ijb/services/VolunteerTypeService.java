package br.com.unifacef.ijb.services;

import br.com.unifacef.ijb.helpers.OptionalHelper;
import br.com.unifacef.ijb.models.entities.VolunteerType;
import br.com.unifacef.ijb.repositories.VolunteerTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class VolunteerTypeService {
    @Autowired
    private VolunteerTypeRepository repository;

    public VolunteerType findByVolunteerNameType(String volunteerNameType) {
        return OptionalHelper.getOptionalEntity(repository.findByVolunteerNameType(volunteerNameType));
    }
}
