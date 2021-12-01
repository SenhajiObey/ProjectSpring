package be.vinci.ipl.user.service;

import be.vinci.ipl.user.model.User;
import be.vinci.ipl.user.repository.UsersRepository;

import java.util.List;

public class UsersServiceImpl implements UsersService {

private final UsersRepository repo;

    public UsersServiceImpl(UsersRepository repo) {
        this.repo = repo;
    }

    @Override
    public List<User> getUsers() {
        return null;
    }

    @Override
    public List<User> getUser(String email) {
        return null;
    }

    @Override
    public List<User> createUsers(User user) {
        return null;
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
