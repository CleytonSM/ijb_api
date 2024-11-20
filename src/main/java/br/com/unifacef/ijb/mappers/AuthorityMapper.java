package br.com.unifacef.ijb.mappers;

import br.com.unifacef.ijb.models.dtos.AuthorityDTO;
import br.com.unifacef.ijb.models.entities.Authority;

public class AuthorityMapper {
    public static AuthorityDTO convertAuthorityIntoAuthorityDTO(Authority authority) {
        return new AuthorityDTO(authority.getId(), authority.getRole(), authority.getCreatedAt(),
                authority.getUpdatedAt(), authority.getDeletedAt());
    }

    public static Authority convertAuthorityDTOIntoAuthority(AuthorityDTO authority) {
        return new Authority(authority.getId(), authority.getRole(), authority.getCreatedAt(),
                authority.getUpdatedAt(), authority.getDeletedAt());
    }
}
