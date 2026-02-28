package br.com.miqueiasdev.authapi.security;

import br.com.miqueiasdev.authapi.model.User;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;

import java.security.Key;
import java.util.Collections;

public class TokenUtil {

    public static final String EMISSOR = "MiqueiasDev";
    public static final long EXPIRATION = 60 * 60 * 1000;
    public static final String SECRET_KEY = "0123456789012345678901234567890123456789";
    public static MyToken encode(User user){

    }

    public static Authentication decode(HttpServletRequest request){
        String header = request.getHeader("Authorization");
        System.out.println("Request header: "+header);
        if (header != null){
            String token = header.replace("Bearer ", "");
            if (token.equals("security123")){
                return new UsernamePasswordAuthenticationToken("valido", null, Collections.emptyList());

            }
        }return null;

    }


//    public static final String EMISSOR = "Miqueias";
//    public static final long EXPIRATION = 15 * 1000;
//    public static final String SECRET_KEY = "0123456789012345678901234567890123456789";
//
//    public static MyToken enconde(User user){
//      return null;
//    }
}
