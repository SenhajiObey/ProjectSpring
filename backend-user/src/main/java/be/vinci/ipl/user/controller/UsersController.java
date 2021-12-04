package be.vinci.ipl.user.controller;

import antlr.ASTFactory;
import be.vinci.ipl.user.model.User;
import be.vinci.ipl.user.repository.UsersRepository;
import be.vinci.ipl.user.service.UsersService;
import be.vinci.ipl.user.service.UsersServiceImpl;
import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/")
public class UsersController {


    private UsersService service;
    private final Algorithm jwtAlgorithm = Algorithm.HMAC256("Secret");

    public UsersController(UsersService usersService){
        this.service = usersService;
    }

    @GetMapping
    public List<User> getUsers(){
        return service.getUsers();
    }

    @PostMapping("/login")
    public boolean checkUser(@RequestBody User user){
        User u = null;
        try {
            u = (User) service.getUserByEmail(user.getEmail());
        } catch (Exception e) {
            return false;
        }
        return new BCryptPasswordEncoder().matches(user.getPassword(), u.getPassword());
    }

    @PostMapping("/register")
    public boolean createUser(@RequestBody User user){
        User u = null;
        System.out.println(user);

        try {
            System.out.println("Avant appel service");
            System.out.println(service.createUser(user));
            return true;

        } catch (Exception e) {
            return false;
        }
    }


    @DeleteMapping("/{id}")
    public List<User> deleteUsers(@PathVariable("id") int id){
        return service.deleteUsers(id);
    }

    @PutMapping("/{id}")
    public List<User> updateUsers(@PathVariable("id") int id){
        return service.updateUsers(id);
    }

    @PostMapping("/token")
    public String createToken(User user){
        String token = JWT.create().withIssuer("auth0").withClaim("user", user.getId()).sign(jwtAlgorithm);
        return token;
    }

}


