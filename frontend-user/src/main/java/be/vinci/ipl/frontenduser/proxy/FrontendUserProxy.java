package be.vinci.ipl.frontenduser.proxy;



import be.vinci.ipl.frontenduser.model.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

@Component
@FeignClient(name = "backend-user", url = "localhost:9003")
public interface FrontendUserProxy {

    @PostMapping("/register")
    boolean createUser(@RequestBody User user);

    @PostMapping("/token")
    String createToken(@RequestBody User user);

    @PostMapping("/login")
    boolean checkUser(@RequestBody User user);
}
