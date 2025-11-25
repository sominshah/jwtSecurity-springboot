package spring.scurity.example.jwtSecurity.service;
import org.jspecify.annotations.Nullable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;
import spring.scurity.example.jwtSecurity.model.AppUser;
import spring.scurity.example.jwtSecurity.repo.AppUserRepository;

@Service
public class AppUserService
{
    @Autowired
    AuthenticationManager authenticationManager;

    @Autowired
    JWTService jwtService;

    @Autowired
    AppUserRepository appUserRepository;
    public AppUser register(AppUser appUser)
    {
        return appUserRepository.save(appUser);
    }
    public  boolean checkIfUsernameExists(String username)
    {
        return appUserRepository.findByUsername(username).isPresent();
    }

    public @Nullable Object verify(AppUser appUser)
    {
        Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(appUser.getUsername(), appUser.getPassword()));
        if(authentication.isAuthenticated()) return jwtService.generateToken(appUser.getUsername());
        return "failure";
    }
}
