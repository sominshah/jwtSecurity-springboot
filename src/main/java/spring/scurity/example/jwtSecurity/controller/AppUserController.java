package spring.scurity.example.jwtSecurity.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;
import spring.scurity.example.jwtSecurity.model.AppUser;
import spring.scurity.example.jwtSecurity.service.AppUserService;
import spring.scurity.example.jwtSecurity.utility.HashGenerator;

import java.util.Map;

@RestController
public class AppUserController
{
    @Autowired
    private AppUserService appUserService;

    @PostMapping("/register")
    public ResponseEntity<?> registerUser(@RequestBody AppUser appUser)
    {
        if(appUserService.checkIfUsernameExists(appUser.getUsername()))
        {
            return ResponseEntity.badRequest().body("User name ["+appUser.getUsername()+"] is not available.");
        }
        appUser.setPassword(HashGenerator.getHash(appUser.getPassword()));
    return ResponseEntity.ok(appUserService.register(appUser));
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody AppUser appUser)
    {
        System.out.println("Login Request for "+appUser);
        if (!appUserService.checkIfUsernameExists(appUser.getUsername()))
        {
            return ResponseEntity.badRequest().body("Username ["+appUser.getUsername()+"] is not available.");
        }
        String token =appUserService.verify(appUser);
        System.out.println("Login Response for Token: "+token);
        return ResponseEntity.ok(token);
    }


    @GetMapping("/api/user/me")
    public ResponseEntity<?> me(  @AuthenticationPrincipal UserDetails userDetails)
    {
        System.out.println("Me Request for "+userDetails);
        if (userDetails == null) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }
        return ResponseEntity.ok(Map.of(
                        "username", userDetails.getUsername(),
                        "roles", userDetails.getAuthorities()));
    }
}
