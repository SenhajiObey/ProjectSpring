package be.vinci.ipl.user.service;

import be.vinci.ipl.user.model.User;
import be.vinci.ipl.user.repository.UsersRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class UsersServiceImpl implements UsersService {

    private final UsersRepository repo;

    public UsersServiceImpl(UsersRepository repo) {
        this.repo = repo;
    }

    @Override
    public List<User> getUsers() {
        return null;
    }

    /*Méthode à changer car pas correct du tout mais fonctionne*/
    @Override
    public User getUserByEmail(String email) {
        List<User> list = (List<User>) repo.findAll();
        for (User u:list) {
            if(u.getEmail().equals(email)){
                System.out.println(u);
                return u;
            }

        }
        return null;
    }

    @Override
    public User createUser(User user){
        User user1 = repo.save(user);
        if(user1==null){
            return null;
        }else {
            return user1;
        }

    }

    @Override
    public List<User> deleteUsers(int id) {
        return null;
    }

    @Override
    public List<User> updateUsers(int id) {
        return null;
    }
}
