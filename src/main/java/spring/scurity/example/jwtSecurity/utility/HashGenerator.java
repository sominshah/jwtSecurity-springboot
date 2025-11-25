package spring.scurity.example.jwtSecurity.utility;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
public class HashGenerator
{
static BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder(12);
public HashGenerator()
{

}
public static String getHash(String password)
{
    return bCryptPasswordEncoder.encode(password);
}
static public BCryptPasswordEncoder getBCryptPasswordEncoder()
{
    return bCryptPasswordEncoder;
}
}
