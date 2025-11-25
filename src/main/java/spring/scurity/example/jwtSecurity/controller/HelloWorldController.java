package spring.scurity.example.jwtSecurity.controller;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldController
{
    @GetMapping("/")
    public String Greeting(HttpServletRequest request)
    {

        return "Hello World! : "+"ip: "+request.getRemoteAddr()+" Host: "+request.getRemoteHost()+" Session Id: "+request.getSession().getId();
    }

    @GetMapping("/hello")
    public String sayHello()
    {
        return "Hello! user, How are you?";
    }
}
