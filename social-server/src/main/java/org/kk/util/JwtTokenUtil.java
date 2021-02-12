package org.kk.util;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.Claim;
import com.auth0.jwt.interfaces.DecodedJWT;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

import java.io.UnsupportedEncodingException;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;


public class JwtTokenUtil {
    // Token请求头
    public static final String TOKEN_HEADER = "Authorization";

    // 签名主题
    public static final String SUBJECT = "kkSocial030806";
    // 过期时间 三十天
    public static final int EXPIRE = 60 * 60 * 12 * 60;

    public static final String SECRET = "sdjhakdhajdklsl;o653632";

    /**
     * 生成Token
     */
    public static String createToken(String id) throws UnsupportedEncodingException {
        Calendar nowTime = Calendar.getInstance();
        nowTime.add(Calendar.SECOND, EXPIRE);
        Date expireDate = nowTime.getTime();
        HashMap<String,Object> map = new HashMap<>();
        map.put("alg", "HS256");
        map.put("typ", "JWT");

        String token = JWT.create()
                .withHeader(map)
                .withClaim("id",id)
                .withSubject(SUBJECT)
                .withIssuedAt(new Date())
                .withExpiresAt(expireDate)
                .sign(Algorithm.HMAC256(SECRET));
        return token;
    }

    /**
     * 校验Token
     */
    public static Boolean checkJWT(String token)throws Exception {
        JWTVerifier verifier = JWT.require(Algorithm.HMAC256(SECRET)).build();
        DecodedJWT jwt;
        try {
            jwt = verifier.verify(token);
        }catch (Exception e){
            throw new RuntimeException("凭证已过期，请重新登录");
        }
        Claim id = jwt.getClaim("id");
        return id != null;
    }

    /**
     * 从Token中获取username
     */
    public static String getUserId(String token) {
        DecodedJWT decodedJWT = JWT.decode(token);
        Claim id = decodedJWT.getClaim("id");
        String userId = id.asString();
        return userId;
    }

    /**
     * 校验Token是否过期
     */
    public static boolean isExpiration(String token) throws NoClassDefFoundError{
        DecodedJWT decodedJWT = JWT.decode(token);
        Map<String, Claim> claims = decodedJWT.getClaims();
        return false;
    }
}