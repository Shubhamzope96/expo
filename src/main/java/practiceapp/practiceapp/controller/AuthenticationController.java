package practiceapp.practiceapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.*;
import practiceapp.practiceapp.model.JWTRequest;
import practiceapp.practiceapp.model.JWTResponse;
import practiceapp.practiceapp.model.User;
import practiceapp.practiceapp.security.CustomUserDetailService;
import practiceapp.practiceapp.security.JWTUtils;

import java.security.Principal;

@RestController
@CrossOrigin("*")
public class AuthenticationController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private CustomUserDetailService customUserDetailService;

    @Autowired
    private JWTUtils jwtUtils;


    //generate token
    @PostMapping("/generate-token")
    public ResponseEntity<?> generateToken(@RequestBody JWTRequest jwtRequest) throws Exception {
        try{
            authenticate(jwtRequest.getUsername(), jwtRequest.getPassword());
        }catch(UsernameNotFoundException e){
            e.printStackTrace();
            System.out.println("user not found");
            throw new Exception("User not found");
        }
        //authenticated
        UserDetails userDetails = this.customUserDetailService.loadUserByUsername(jwtRequest.getUsername());
        String token = this.jwtUtils.generateToken(userDetails);
        return ResponseEntity.ok(new JWTResponse(token));
    }


    private void authenticate(String username, String password) throws Exception {
        try{
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));
        }catch(DisabledException e){

            throw new Exception("user desabled");
        }catch(BadCredentialsException e){

            throw new Exception("Invalid credentials "+e.getMessage());
        }
    }

    //return details of current user
    @GetMapping("/current-user")
    public User getCurrentUser(Principal principal){
        return ((User)this.customUserDetailService.loadUserByUsername(principal.getName()));
    }
}
