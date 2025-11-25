package spring.scurity.example.jwtSecurity.service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import spring.scurity.example.jwtSecurity.model.AppUser;
import spring.scurity.example.jwtSecurity.model.AppUserPrincipal;
import spring.scurity.example.jwtSecurity.repo.AppUserRepository;

import java.util.Optional;

@Service
public class AppUserDetailsService implements UserDetailsService
{
    @Autowired
    AppUserRepository userRepository;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException
    {
        System.out.println("Username Come to verify: " + username);
        Optional<AppUser> loginUser =userRepository.findByUsername(username);
        System.out.println("loginUser: "+loginUser);
        if(loginUser.isEmpty()) throw new UsernameNotFoundException("User not found "+username);
        AppUser user = loginUser.get();
        return new AppUserPrincipal(user);
    }

}
