package be.vinci.ipl.user.service;

import be.vinci.ipl.user.model.User;

import java.util.List;

public interface UsersService {

  List<User> getUsers();

  User createUser(User user);

  List<User> deleteUsers(int id);

  List<User> updateUsers(int id);

  User getUserByEmail(String email);
}


