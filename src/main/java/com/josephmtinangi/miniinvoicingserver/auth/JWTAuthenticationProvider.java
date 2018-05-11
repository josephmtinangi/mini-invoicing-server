package com.josephmtinangi.miniinvoicingserver.auth;

import com.josephmtinangi.miniinvoicingserver.models.User;
import com.josephmtinangi.miniinvoicingserver.repositories.UserRepository;
import io.jsonwebtoken.lang.Assert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.Collections;

@Component
public class JWTAuthenticationProvider implements AuthenticationProvider {

    @Autowired
    private UserRepository userRepository;

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {

        Assert.notNull(authentication, "No authentication data provided");

        String email = (String) authentication.getPrincipal();
        System.out.println("email = " + email);
        String password = (String) authentication.getCredentials();
        System.out.println("password = " + password);

        User user = userRepository.findFirstByEmail(email);
        System.out.println("User = " + user);

        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();

        if (user == null || !bCryptPasswordEncoder.matches(password, user.getPassword())) {
            System.out.println("Authentication Failed. Username or password is incorrect");
            throw new BadCredentialsException("Authentication Failed. Username or password is incorrect");
        }

        System.out.println("email = " + user.getEmail());
        System.out.println("password = " + user.getPassword());

        UserContext userContext = new UserContext(user.getId(), user.getEmail());

        return new UsernamePasswordAuthenticationToken(userContext, null, Collections.emptyList());
    }

    @Override
    public boolean supports(Class<?> authentication) {
        return (UsernamePasswordAuthenticationToken.class.isAssignableFrom(authentication));
    }
}
