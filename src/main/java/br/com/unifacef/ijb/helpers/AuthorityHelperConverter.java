package br.com.unifacef.ijb.helpers;

import br.com.unifacef.ijb.models.dtos.AuthorityDTO;
import br.com.unifacef.ijb.models.entities.Authority;

public class AuthorityHelperConverter {

    public static AuthorityDTO convertAuthorityToAuthorityDTO(Authority authority) {
        return new AuthorityDTO(authority.getId(), authority.getRole());
    }

    public static Authority convertAuthorityDTOToAuthority(AuthorityDTO authorityDTO) {
        return new Authority(authorityDTO.getRole());
    }
}
