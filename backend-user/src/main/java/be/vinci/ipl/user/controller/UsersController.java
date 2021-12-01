package be.vinci.ipl.user.controller;

import be.vinci.ipl.user.model.User;
import be.vinci.ipl.user.service.UsersService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UsersController {

    private UsersService service;

    @GetMapping
    public List<User> getUsers(){
        return service.getUsers();
    }

    @GetMapping("/{email}")
    public List<User> getUser(@PathVariable("email") String email){
        return service.getUser(email);
    }


    @PostMapping
    public List<User> createUsers(@RequestBody User user){
        return service.createUsers(user);
    }

    @DeleteMapping("/{id}")
    public List<User> deleteUsers(@PathVariable("id") int id){
        return service.deleteUsers(id);
    }

    @PutMapping("/{id}")
    public List<User> updateUsers(@PathVariable("id") int id){
        return service.updateUsers(id);
    }
}
