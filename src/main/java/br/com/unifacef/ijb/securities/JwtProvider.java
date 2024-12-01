package br.com.unifacef.ijb.securities;

import br.com.unifacef.ijb.configs.UserAuthenticationProvider;
import br.com.unifacef.ijb.exceptions.InvalidJwtTokenException;
import br.com.unifacef.ijb.helpers.OptionalHelper;
import br.com.unifacef.ijb.helpers.SecretKeyHelper;
import br.com.unifacef.ijb.models.entities.Authority;
import br.com.unifacef.ijb.models.entities.User;
import br.com.unifacef.ijb.models.entities.UserInfo;
import br.com.unifacef.ijb.models.enums.Role;
import br.com.unifacef.ijb.repositories.UserInfoRepository;
import br.com.unifacef.ijb.repositories.UserRepository;
import io.jsonwebtoken.JwtException;
import io.jsonwebtoken.Jwts;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.cdi.Eager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;

import javax.crypto.SecretKey;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Component
public class JwtProvider {
    @Autowired
    private SecretKeyHelper secretKeyHelper;
    @Autowired
    private UserInfoRepository userInfoRepository;
    @Autowired
    private UserAuthenticationProvider userAuthenticationProvider;

    public String createToken(Authentication authentication) {
        Date date = new Date();
        SecretKey key = secretKeyHelper.secretKeyBuilder();

        return Jwts.builder()
                .issuer("IJB API")
                .claims(claimsSetup(authentication))
                .subject("JWT Token")
                .issuedAt(date)
                .expiration(new Date(date.getTime() + 3600000L))
                .signWith(key)
                .compact();
    }

    private Map<String, String> claimsSetup(Authentication authentication) {
        UserInfo userInfo = (UserInfo) authentication.getPrincipal();
        User user = userInfo.getUser();
        Authority authority = userInfo.getAuthority();
        Role role = authority.getRole();

        Map<String, String> claims = new HashMap<>();

        claims.put("email", user.getEmail());
        claims.put("role", role.getType());

        return claims;
    }

    public boolean validateToken(String token) {
        SecretKey secretKey = secretKeyHelper.secretKeyBuilder();

        try {
            Jwts.parser().verifyWith(secretKey).build().parseSignedClaims(token);
            return true;
        } catch (JwtException | IllegalStateException e) {
            throw new InvalidJwtTokenException(e.getMessage());
        }
    }

    public String resolveToken(HttpServletRequest request) {
        String bearerToken = request.getHeader("Authorization");

        if(bearerToken != null && bearerToken.startsWith("Bearer ")) {
            return bearerToken.substring(7);
        }

        return null;
    }

    public Authentication getAuthentication(String token) {
        UserInfo userInfo = OptionalHelper.getOptionalEntity(userInfoRepository.findByUserEmail
                (getUserEmailFromToken(token)));

        return new UsernamePasswordAuthenticationToken(userInfo, "",
                userAuthenticationProvider.grantedAuthorities(userInfo.getAuthority()));
    }

    private String getUserEmailFromToken(String token) {
        SecretKey secretKey = secretKeyHelper.secretKeyBuilder();

        return Jwts.parser().verifyWith(secretKey).build()
                .parseSignedClaims(token).getPayload().get("email", String.class);
    }
}
