package spring.scurity.example.jwtSecurity.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import spring.scurity.example.jwtSecurity.model.AppUser;
import spring.scurity.example.jwtSecurity.service.AppUserService;
import spring.scurity.example.jwtSecurity.utility.HashGenerator;

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

        return ResponseEntity.ok(appUserService.verify(appUser));
    }
}
