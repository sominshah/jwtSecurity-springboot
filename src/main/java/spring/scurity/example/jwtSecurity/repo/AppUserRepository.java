package spring.scurity.example.jwtSecurity.repo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import spring.scurity.example.jwtSecurity.model.AppUser;

import java.util.Optional;
@Repository
public interface AppUserRepository extends JpaRepository<AppUser, Long>
{
Optional<AppUser> findByUsername(String username);
}
