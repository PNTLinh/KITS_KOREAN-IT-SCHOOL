package com.topcit.aims.aims.security;

import com.topcit.aims.aims.entity.Customer;
import io.jsonwebtoken.*;
import io.jsonwebtoken.security.Keys;

import java.nio.charset.StandardCharsets;
import java.security.Key;
import java.util.Date;

public class JwtUtil {
    private static final String SECRET_KEY = "NTL_KITS";
    private static final long EXPIRATION_TIME = 36000000; // 10h

    // Tạo key từ SECRET_KEY
    private static final Key SIGN_KEY = Keys.hmacShaKeyFor(SECRET_KEY.getBytes(StandardCharsets.UTF_8));

    // Sinh token
    public static String generateToken(Customer customer) {
        return Jwts.builder()
                .setSubject(customer.getEmail())
                .setIssuer("TOPCIT")
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + EXPIRATION_TIME))
                .signWith(SIGN_KEY, SignatureAlgorithm.HS512)
                .compact();
    }

    // Giải mã token để lấy email
    public static String extractEmail(String token) {
        Claims claims = Jwts.parserBuilder()
                .setSigningKey(SIGN_KEY)
                .build()
                .parseClaimsJws(token)
                .getBody();
        return claims.getSubject();
    }
}
