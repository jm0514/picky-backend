package network.picky.web.auth.dto;

import org.springframework.security.authentication.AbstractAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;

import java.util.Collection;
import java.util.Collections;

public class JwtAuthenticationToken  extends AbstractAuthenticationToken  {
    private Long id;
    private String token;

    public JwtAuthenticationToken(String token){
        super(Collections.emptyList());
        this.token = token;
    }

    public JwtAuthenticationToken(Long id, String token, Collection<? extends GrantedAuthority> authorities){
        super(authorities);
        this.id = id;
        this.token = token;
    }


    public static Authentication unauthenticated(String token){
        return new JwtAuthenticationToken(token);
    }

    public static Authentication authenticated(Long id, String token, Collection<? extends GrantedAuthority> authorities){
        return new JwtAuthenticationToken(id, token, authorities);
    }

    @Override
    public Object getPrincipal() {
        return id;
    }

    @Override
    public Object getCredentials() {
        return token;
    }

    public String getToken(){
        return token;
    }

}
