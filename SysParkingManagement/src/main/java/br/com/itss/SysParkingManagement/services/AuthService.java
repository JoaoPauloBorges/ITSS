package br.com.itss.SysParkingManagement.services;

import br.com.itss.SysParkingManagement.exception.NotAuthorizedException;
import br.com.itss.SysParkingManagement.model.AuthRequest;
import br.com.itss.SysParkingManagement.util.JwtUtil;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

@Service
public class AuthService {

    private final AuthenticationManager authenticationManager;
    private final MyUserDetailService userDetailsService;
    private JwtUtil jwtTokenUtil;

    public AuthService(AuthenticationManager authenticationManager, MyUserDetailService userDetailsService, JwtUtil jwtTokenUtil) {
        this.authenticationManager = authenticationManager;
        this.userDetailsService = userDetailsService;
        this.jwtTokenUtil = jwtTokenUtil;
    }

    public String authenticate(AuthRequest authRequest) throws Exception {
        try {
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(authRequest.getUsername(), authRequest.getPassword())
            );
        } catch (BadCredentialsException e) {
            throw new NotAuthorizedException("incorrect username or password");
        }
        final UserDetails userDetails = userDetailsService
                .loadUserByUsername(authRequest.getUsername());

        return jwtTokenUtil.generateToken(userDetails);
    }
}
