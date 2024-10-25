package br.com.unifacef.ijb.helpers;

import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.crypto.SecretKey;
import java.nio.charset.StandardCharsets;

@Component
public class SecretKeyHelper {
    @Value("${jwt.secret.key}")
    private String secretKey;

    public SecretKey secretKeyBuilder() {
        return Keys.hmacShaKeyFor(secretKey.getBytes(StandardCharsets.UTF_8));
    }
}
