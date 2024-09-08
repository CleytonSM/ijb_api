package br.com.unifacef.ijb.helper;

import br.com.unifacef.ijb.models.dtos.AuthorityDTO;
import br.com.unifacef.ijb.models.entities.Authority;

public class AuthorityConverter {

    public static AuthorityDTO convertAuthorityToAuthorityDTO(Authority authority) {
        return new AuthorityDTO(authority.getId(), authority.getRole());
    }

    public static Authority convertAuthorityDTOToAuthority(AuthorityDTO authorityDTO) {
        return new Authority(authorityDTO.getRole());
    }
}
