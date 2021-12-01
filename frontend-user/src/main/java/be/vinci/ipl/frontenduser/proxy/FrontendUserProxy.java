package be.vinci.ipl.frontenduser.proxy;



import be.vinci.ipl.frontenduser.model.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

@Component
@FeignClient(name = "backend-user", url = "localhost:9002")
public interface FrontendUserProxy {

    @PostMapping("/user/sign-up")
    User createUser(@RequestBody User user);

    @PostMapping("/user/sign-in")
    boolean verifyUser(@RequestBody User user);

    @GetMapping("/user/{mail}")
    User getUser(@PathVariable("mail") String mail);

}
